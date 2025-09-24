document.addEventListener('DOMContentLoaded', init);
todos = [];

function init(){
    bindEvents();
    render();
}

function render(){
    const todoList = document.getElementById('todo-list');
    todoList.innerHTML = "";
}

function bindEvents(){
    const addBtn = document.getElementById('todo-add-btn');
    addBtn.addEventListener('click', addTodo);
}

function addTodo(){
    const text = todoinput.value.trim();
    if(!text) return;

    let todo = {
        id: Date.now(),
        content: text,
        completed: false,
        createdAt: new Date().toLocaleString(),
    }
    todos.push(todo);
    todoInput,value = "";
    render();
}

function todoItemRender(todo){
    const todoitem = document.createElement('li');
    todoitem.className = 'todo-item' + (todo.completed ? 'completed' : '');

    todoitem.innerHTML = `<div class="todo-checkbox ${todo.completed ? 'checked' : ''}"></div>
                            <span>${todo.content}</span>
                            <button class="delete-btn">삭제</button>`;

    const checkBox = tpdoitem.querySelector('.todo-checkbox');

}

function deleteTodo(id){

}

function updateTode(id){
    
}