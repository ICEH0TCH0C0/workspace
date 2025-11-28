import { useNavigate } from "react-router-dom";
import React from 'react'
import { Table, Th, Td, Online, Offline} from "./Pages.styled";
import UserContext from "./userContext";
import { useState } from "react";

const UserList = () => {
    // const getUserList = localStorage.getItem("userList") ? JSON.parse(localStorage.getItem("userList")) : null;
    const getUserList = React.useContext(UserContext);

    const navigate = useNavigate();

    const userDetail = (id)=> {
        navigate(`/user/${id}`);
    }

    const userRegistation = () => {
        navigate("/user");
    }

  return (
    <>
        <Table>
            <thead>
                <tr>
                    <Th>online</Th>
                    <Th>id</Th>
                    <Th>name</Th>
                    <Th>age</Th>
                    <Th>detail</Th>
                </tr>
            </thead>
            <tbody>
                {getUserList.map((user) => {
                    return (
                        <tr key={user.id}>
                            <Td>{user.isOnline ? <Online /> : <Offline/>}</Td>
                            <Td>{user.id}</Td>
                            <Td>{user.name}</Td>
                            <Td>{user.age}</Td>
                            <Td>
                                <button onClick={() => userDetail(user.id)}>상세보기</button>
                            </Td>
                        </tr>
                    )
                })}
            </tbody>
        </Table>
        <button onClick={userRegistation}>사용자 등록</button>
    </>
  )
}

export default UserList