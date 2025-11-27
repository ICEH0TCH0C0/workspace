import React from 'react'

const Grade = ({isLogin}) => {
  return (
    <div>
        {
            isLogin && <div>골드 등급</div>
        }
    </div>
  )
}

export default Grade