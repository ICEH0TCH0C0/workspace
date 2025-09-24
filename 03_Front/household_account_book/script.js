//================= 전역 변수 ========================================
let balances = JSON.parse(localStorage.getItem('balances')) || [];
let incomeExpenseType = 'income'; // 기본값으로 'income' 설정
let filterType = 'allFilter'; // 기본값으로 'all' 설정

//====================== DOM ========================================
let list = document.getElementById('list');
document.getElementById('all-filter-btn').classList.add('clicked');

//총 수입, 총 지출 변환 버튼
const incomeBtn = document.getElementById('income-btn');
const expenseBtn = document.getElementById('expense-btn');

//전체, 총 수입, 총 지출 필터 변환 버튼
const allfilterbtn = document.getElementById('all-filter-btn');
const incomefilterbtn = document.getElementById('income-filter-btn');
const expensefilterbtn = document.getElementById('expense-filter-btn');

//===================================================================
//DOM이 모두 그려지면 init 함수 시작
document.addEventListener('DOMContentLoaded', init);

function init(){
    bindEvents();
    render();
}

function render() {
    //모두 지우기
    list.innerHTML = ""; 

    //새로운 배열 생성하여 type에 맞는 객체 담기
    let filteredBalances = [];
    //필터링
    if (filterType === 'incomeFilter') {
        filteredBalances = balances.filter(function(balance) {
            return balance.type === 'income';
        });
    } else if (filterType === 'expenseFilter') {
        filteredBalances = balances.filter(function(balance) {
            return balance.type === 'expense';
        });
    } else { // 'allFilter' 또는 그 외의 경우
        filteredBalances = balances; // 모든 데이터를 그대로 사용
    }

    //리스트 반복 생성
    filteredBalances.forEach(function(balance) {
        balanceItemRender(balance); 
    });

    //계산
    filterItemRender(); 
}

//버튼 이벤트들
function bindEvents(){
    const addBtn = document.getElementById('add-btn');
    addBtn.addEventListener('click', addIncomeExpense);

    //클릭시 버튼 색상 유지 및 데이터 타입 가져오기
    incomeBtn.addEventListener('click', handleIncomeExpenseTypeClick);

    expenseBtn.addEventListener('click', handleIncomeExpenseTypeClick);

    //클릭시 버튼 생상 유지 및 데이터 타입 가져오기
    allfilterbtn.addEventListener('click', handleTypeClick);

    incomefilterbtn.addEventListener('click', handleTypeClick);

    expensefilterbtn.addEventListener('click', handleTypeClick);
}

//수입과 수출 버튼의 타입에 따른 색상과 타입 데이터 가져오기
function handleIncomeExpenseTypeClick(event) {
    incomeExpenseType = event.target.dataset.type;

    //수입, 지출 타입에 따른 버튼 변환
    if (incomeExpenseType === 'income') {
        incomeBtn.classList.add('clicked');
        expenseBtn.classList.remove('clicked');
    } else {
        expenseBtn.classList.add('clicked');
        incomeBtn.classList.remove('clicked');
    }
}

//전체, 수입, 지출 타입과 색상 데이터 가져오기
function handleTypeClick(event) {
    filterType = event.target.dataset.type;

    //전체, 수입, 지출 타입에 따른 버튼 변환
    if (filterType === 'allFilter') {
        allfilterbtn.classList.add('clicked');
        incomefilterbtn.classList.remove('clicked');
        expensefilterbtn.classList.remove('clicked');

    } else if (filterType === 'incomeFilter') {
        incomefilterbtn.classList.add('clicked');
        allfilterbtn.classList.remove('clicked');
        expensefilterbtn.classList.remove('clicked');

    } else if (filterType === 'expenseFilter') {
        expensefilterbtn.classList.add('clicked');
        allfilterbtn.classList.remove('clicked');
        incomefilterbtn.classList.remove('clicked');
    }
    
    render();
}

//==================================================
//리스트 생성 함수
function balanceItemRender(balance){
    //오퍼레이터 추가
    let operator = '';
    if(balance.type === 'income') {operator = '+';}
    else {operator = '-';}

    //리스트 생성
    const balanceItem = document.createElement('li');
    balanceItem.className = 'balance-item';
    balanceItem.innerHTML = `<div class="balance-item-content">
                                <div class="balance-list-content">
                                    <p id="date">${balance.date}</p>
                                    <p id="description">${balance.description}</p>
                                </div>
                                <div class="${balance.type === 'income' ? 'income' : 'expense'}">
                                    <p>${operator} ${balance.amount.toLocaleString()}원</p>
                                    <button class="delete-btn">삭제</button>
                                </div>
                            </div>`;
    const balanceItemContent = balanceItem.querySelector('.balance-item-content');
    
    //삭제 버튼
    const deleteBtn = balanceItem.querySelector('.delete-btn');
    deleteBtn.addEventListener('click', function(){
        deleteBalance(balance.id);
    });

    //추가
    list.appendChild(balanceItemContent);
}

//계산 함수
function filterItemRender(){
    const incomeAll = document.getElementById('filter-income');
    const expenseAll = document.getElementById('filter-expense');
    const balanceAll = document.getElementById('filter-balance');
    const balanceHeader = document.getElementById('balance');

    let income = 0;
    let expense = 0;

    //balances 반복하며 타입에 따라 더함
    balances.forEach(function(balance){
        if(balance.type === 'income'){
            income += balance.amount;
        } else {
            expense += balance.amount;
        }
    });

    //잔액 계산
    const balance = income - expense;

    //toLocaleString() 금액 포맷 3자리마다 , 추가
    incomeAll.innerText = income.toLocaleString() + '원';
    expenseAll.innerText = expense.toLocaleString() + '원';
    balanceAll.innerText = balance.toLocaleString() + '원';
    balanceHeader.innerText = balance.toLocaleString() + '원';

    //local에 balances 저장
    saveBalances();
}

//데이터를 리스트에 추가 
function addIncomeExpense(){
    const text = document.getElementById('content-input').value.trim();
    const amount = document.getElementById('amount-input').value.trim();
    let type = incomeExpenseType; // 선택된 타입 사용
    
    if(!text || !amount) return;

    //버림 계산으로 1000원 단위
    const roundedAmount = Math.floor(amount/1000)*1000;

    //객체 생성
    const balance = {
        id: Date.now(),// 고유 ID(시간을 활용해서 만들어주기)
        description: text, // 거래 내용
        amount: Number(roundedAmount), // 금액
        type: type, // 거래 타입 (income/expense)
        date: new Date().toLocaleString() // 거래 날짜
    };

    //배열에 추가
    balances.push(balance);

    saveBalances();
    render();
}

//삭제 함수
function deleteBalance(id){
    let newBalances = balances.filter(function(balance){
        return balance.id !== id;
    });
    balances = newBalances;
    
    saveBalances();
    render();
}

//===================================================

//localStorage에 저장하는 함수
function saveBalances(){
    localStorage.setItem('balances', JSON.stringify(balances));
}

//===================================================

