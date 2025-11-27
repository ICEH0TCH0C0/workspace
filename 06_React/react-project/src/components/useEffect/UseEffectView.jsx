import React from 'react'
import { useState } from 'react'
import UseEffectTest from './UseEffectTest';

const UseEffectView = () => {
    const [isView, setIsView] = useState(false);

  return (
    <div>
        <button onClick={() => setIsView(prev => !prev)}> 
            화면출력
        </button>
        {
            isView &&
            <UseEffectTest />
        }
    </div>
  )
}

export default UseEffectView