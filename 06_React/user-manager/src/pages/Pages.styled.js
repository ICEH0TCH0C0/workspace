import styled from "styled-components";

export const Online = styled.div`
    width: 10px;
    height: 10px;
    background-color: green;
    border-radius: 50%;
    margin-left: 10px;
`

export const Offline = styled.div`
    width: 10px;
    height: 10px;
    background-color: red;
    border-radius: 50%;
    margin-left: 10px;
`

export const Table = styled.table`
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    border: 1px solid white;
`

export const Th = styled.th`
    border: 1px solid white;
    padding: 0 12px;
`

export const Td = styled.td`
    border-bottom: 1px solid white;
    padding: 0 12px;
`

// =================== 회원 가입 =====================

export const Form = styled.form`
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 10px;
    border: 1px solid white;
`

export const Input = styled.input`
    display: flex;
    padding: 12px;
    font-size: 18px;
`

// =================== 상세 보기 =======================

export const Detail = styled.div`
    border: 1px solid white;
    padding: 12px;
`

export const User = styled.div`
    display: flex;
    align-items: center;
    gap: 18px;
    margin-bottom: 12px;
    border-top: 1px solid white;
    border-bottom: 1px solid white;
`

export const H2 = styled.h2`
    font-size: 24px;
    margin-bottom: 32px;
`