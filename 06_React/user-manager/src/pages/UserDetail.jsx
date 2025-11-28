import React from 'react'
import { useParams } from 'react-router-dom'
import UserContext from "./userContext";
import { useNavigate } from "react-router-dom";
import { Detail, H2, Offline, Online, User } from './Pages.styled';

const UserDetail = () => {
    const userList = React.useContext(UserContext);
    

    const { id } = useParams();
    
    //쿼리 스트림은 문자열임
    const userId = parseInt(id, 10);
    console.log(userId);

    // const user = localStorage.getItem("userList") ? JSON.parse(localStorage.getItem("userList")).find(user => user.id === userId) : null;
    const user = userList.find(user => user.id === userId);

    const navigate = useNavigate();
    const goBack = () => {
        navigate("/");
    }

    const deleteUser = () => {
        userList.splice(user.id - 1, 1); //현재 user의 id에 1을 뺀 index를 삭제
        alert("탈퇴 완료");
        // localStorage.removeItem("userList");
        // localStorage.setItem("userList", JSON.stringify(userList));
        navigate("/")
    }

    if (!user) {
        return <div>사용자를 찾을 수 없습니다.</div>;
    }

    return (
        <Detail>
            <H2>사용자 상세 정보</H2>
            <User>
                <div>{user.isOnline ? <Online /> : <Offline />}</div>
                <p><strong>ID:</strong> {user.id}</p>
                <p><strong>이름:</strong> {user.name}</p>
                <p><strong>나이:</strong> {user.age}</p>
            </User>
            <button onClick={deleteUser}>탈퇴하기</button>
            <button onClick={goBack}>돌아가기</button>
        </Detail>
    )
}

export default UserDetail