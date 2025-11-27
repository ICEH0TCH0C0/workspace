import React from 'react'
import { useState, useEffect } from 'react'

const UseEffectTest = () => {
    const [name, setName] = useState("홍길동");
    const [num, setNum] = useState(0);

    const handleChangeName = (ev) => setName(ev.target.value);
    const handleChangeNum = () => setNum(prev => prev + 1 );

    //1. 의존성 배열 없이 단순하게 이펙트 함수만 전달할 때
    useEffect(() => {
        console.log("의존성 없음 : 모든 렌더링마다 실행")
    })

    //2. 빈 배열을 의존성 배열로 설정할 때
    useEffect(() => {
        console.log("의존성 빈 배열 : 컴포넌트가 마운트될 때 1회 실행")
    }, [])

    //3. 의존성 배열에 특정 state를 넣었을 때
    useEffect(() => {
        console.log("의존성 배열에 name을 넣었을 때 : name이 변경될 때마다 실행")
    }, [name])

    //4. 클린업 함수(컴포넌트가 사라질 때 실행하는 함수) : 특정값이 변경되기 이전 값을 활용하고 싶을 때(언마운트 전에 실행됨)
    //수정되었지만, 수정되기 전 값을 사용하고 싶을 때
    useEffect(() => {
        return () => {
            console.log(`클린업 함수 : 컴포넌트가 사라질 때 실행: ${num}`)
        }
    }, [num])

    //5. 컴포넌트가 완전히 사라질 때 실행되는 함수
    useEffect(() => {
        return () => {
            console.log(`클린업 함수, 빈 배열 : 컴포넌트가 완전하게 사라질 때 실행: ${num}`)
        }
    }, [])
    
  return (
    <div>
        <h2>useEffectTest</h2>
        <p>안녕하세요. <strong>{name}</strong>입니다.</p>

        <input 
            type="text" 
            value={name} 
            onChange={handleChangeName}
            placeholder='이름을 입력해주세요...'
        />

        <p>버튼을 <strong>{num}</strong>번 클릭하셨습니다.</p>
        <button onClick={handleChangeNum}>+</button>
    </div>
  )
}

export default UseEffectTest