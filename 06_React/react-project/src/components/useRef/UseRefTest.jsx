import React, { useEffect, useRef } from 'react'
import { useState } from 'react'

const UseRefTest = () => {
    const [name, setName] = useState("");
    const [gender, setGender] = useState("man");
    const useInput = useRef();


    // 필수로 작성
    const handleSubmit = (ev) => {
        ev.preventDefault(); 
        console.log(ev);
        alert(`이름 : ${name}, 성별 : ${gender}`);
    }

    const handleNameChange = (ev) => {
        setName(ev.target.value);
    }

    const handleGenderChange = (ev) => {
        setGender(ev.target.value);
    }

    const handleReset = () => {
        setName("");
        setGender("man");
        // const userInput = document.getElementById("name-input");
        // userInput.focus();
        // 이처럼 직접 DOM을 건들면, React가 UI를 렌더링하는 흐름이 예측하기 어려워진다.
        // 타이밍상 DOM이 아직 그려지지 않았을 때 getElementById()가 실행될 수 있다.
        // id 속성은 컴포넌트와 무관하다. -> id를 사용하면, 다른 컴포넌트의 id를 가져올 수 있고 이렇게 되면, 코드의 결합도가 증가한다.

        useInput.current?.focus();
        //DOM 직접 탐색없이 React가 input을 참조하게 된다.

    }

    useEffect(() => {
        const userInput = document.getElementById("name-input");
        userInput.focus();
    }, [name, gender])

    return (
        <form onSubmit={handleSubmit}>
            <label>
                이름 : <input id="name-input" type="text" value={name} onChange={handleNameChange} ref={useInput}/>
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
            <button type="button" onClick={handleReset}>취소</button>
        </form>
    )
}

export default UseRefTest