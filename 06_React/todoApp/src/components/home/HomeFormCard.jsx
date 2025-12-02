import React, { useState } from 'react'


const HomeFormCard = () => {
    const [count, setCount] = useState(0);

    const storedData = localStorage.getItem('todos');
    const todoArray = storedData ? JSON.parse(storedData) : [];
    const totalCount = todoArray.length;

    const todoCompleate = todoArray.
  return (
    <>
        <div>
            {totalCount}
        </div>
        <div>
            {totalCount}
        </div>
        <div>
            {totalCount}
        </div>
    </>
  )
}

export default HomeFormCard