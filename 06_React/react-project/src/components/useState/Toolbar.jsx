import React from 'react'

const Toolbar = ({isLogin, onclickLogin, onclickLogout}) => {

  return (
    <div>
        {
            isLogin ? 
            <div>
                <div>안녕하세요. 홍길동님</div>
                <button onClick={onclickLogout}>로그아웃</button>
            </div> :
            <div>
                <div>로그인이 필요한 서비스 입니다.</div>
                <button onClick={onclickLogin}>로그인</button>
            </div>
        }   
    </div> 
  )
}

export default Toolbar