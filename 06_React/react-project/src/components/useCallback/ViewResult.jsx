import React, { useEffect } from 'react'
import { useState } from 'react'

const ViewResult = React.memo(({getResult}) => {

    const [items, setItems] = useState([]);

    //컴포넌트가 마운트될 때 실행되는 함수
    useEffect(() => {   
        console.log("ViewResult 렌더링 / getResult가 변경")
        setItems(getResult());
    }, [getResult])
  return (
    <div>
        <h4>결과</h4>
        <ul>
            {items.map((item, index) => 
                <li key={index}>{item}</li>
            )}
        </ul>
    </div>
  )
})

export default ViewResult