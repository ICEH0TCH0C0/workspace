// import React from 'react'
import { useState } from 'react'

// 이름과 성별을 입력받는 창을 만들고
// submit 버튼을 클릭시 이름 : ~ 성별: ~ 를 출력
const Signup = () => {
    const [name, setName] = useState("");
    const [gender, setGender] = useState("man");

    // 필수로 작성
    const handleSubmit = (ev) => {
        ev.preventDefault(); // a태그나 submit 같은 고유 동작을 가진 태그에 이벤트를 중단해주기 위한 함수
        // onSubmit 자체에 서버로 데이터를 전송하고 페이지를 이동하는 기능이 있지만,
        // react에서는 form 태그 자체의 표준적인 구조는 사용하지만, 이벤트 기능은 SPA와 맞지 않아 사용하지 않음.
        console.log(ev);
        alert(`이름 : ${name}, 성별 : ${gender}`);
    }

    const handleNameChange = (ev) => {
        setName(ev.target.value);
    }

    const handleGenderChange = (ev) => {
        setGender(ev.target.value);
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                이름 : <input type="text" value={name} onChange={handleNameChange}/>
            </label>
            <br /><br />
            <label>
                성별 : 
                <select value={gender} onChange={handleGenderChange}>
                    <option value="male">남자</option>
                    <option value="female">여자</option>
                </select>
            </label>
            <br /><br />
            <button type="submit">제출</button>
        </form>
    )
}

export default Signup