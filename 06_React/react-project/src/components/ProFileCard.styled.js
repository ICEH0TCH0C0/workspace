import styled from "styled-components";

export const ProFileState = styled.h3`
    font-size: 16px;
    font-weight: 400;
`

export const IsOnline = styled.p`
    font-size: 14px;
    font-weight: 400;
`

export const Container = styled.div`
    display: flex;
    align-items: center;
    border-bottom: 1px  solid white;
    border-top: 1px solid white;
    padding: 0 8px;
    gap: 10px;
    border-radius: 20%;
`

export const Offline = styled.div`
    display: flex;
    width: 10px;
    height: 10px;
    border-radius: 50%;
    background-color: red;
`
export const Online = styled.div`
    display: flex;
    width: 10px;
    height: 10px;
    border-radius: 50%;
    background-color: green;
`
