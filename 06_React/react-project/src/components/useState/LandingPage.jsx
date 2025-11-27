import React from 'react'
import Toolbar from './Toolbar'
import Grade from './Grade'
import { useState } from 'react'

/* 
    상태 끌어올리기
    여러 컴포넌트에서 사용하는 데이터를 상위 컴포넌트에 state로 저장하고
    이를 props로 하위 컴포넌트에 전달한다.
    또한 state 변경 함수는 상위 컴포넌트에 정의하고, 하위 컴포넌트에서 직접 setState를 사용하지 않는다.
*/

const LandingPage = () => {
  const [isLogin, setIsLogin] = useState(false);

  const onclickLogin = () => {
    setIsLogin(true);
  }

  const onclickLogout = () => {
    setIsLogin(false);
  }

    return (
      <div>
          <Toolbar 
            isLogin={isLogin}
            onclickLogin={onclickLogin}
            onclickLogout={onclickLogout}
          />
          <Grade isLogin={isLogin}/>
      </div>
    )
}

export default LandingPage