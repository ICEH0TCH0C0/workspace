import React from 'react'

const Head = ({type, children}) => {
    if(type === "h2") {
        //?를 붙이면, null일 경우 오류가 발생하는것을 방지하는 안전 장치
        return <h2>안녕하세요</h2>
    
    }
  return (
    <>
        <h1>안녕하세요</h1>
        {children}
    </>
  )
}

export default Head