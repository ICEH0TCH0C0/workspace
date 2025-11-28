import React from 'react'
import useInput from './useInput'
import UserContext from './userContext'
import { useNavigate } from "react-router-dom";
import { Form, Input } from './Pages.styled';

const UserRegistation = () => {
    const userList = React.useContext(UserContext);
    
    const navigate = useNavigate();
    const name = useInput('');
    const age = useInput('');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(name.value, age.value);

        if(age.value.typeof === "number" && age.value > 0) {

            userList.push({
                id: userList.length + 1,
                name: name.value,
                age: age.value,
                isOnline: true
            })
        } else {
            return alert("나이는 숫자로 입력해주세요.")
        }

        // localStorage.setItem("userList", JSON.stringify(userList));

        alert("등록 완료");
        navigate("/");
    }

    const goBack = () => {
        navigate("/");
    }

  return (
    <>
        <Form onSubmit={handleSubmit}>
            <h2>사용자 등록</h2>
            <Input type="text" placeholder='이름' required value={name.value} onChange={name.onChange}/>
            <Input type="text" placeholder='나이' required value={age.value} onChange={age.onChange}/>
            <button type="submit">등록</button>
        </Form>

        <button onClick={goBack}>돌아가기</button>
    </>
  )
}

export default UserRegistation