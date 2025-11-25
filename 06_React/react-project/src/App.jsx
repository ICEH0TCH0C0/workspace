
// import { useState } from 'react'
import JavaScript from './components/JavaScript'
import './App.css'
import Style from './components/Style'
import ProfileCards from './components/ProfileCards'

const proFileCards =[{
  name : "홍길동",
  age : 22,
  isOnline : true,
},{
  name : "홍길서",
  age : 23,
  isOnline : false,
},{
  name : "홍길남",
  age : 24,
  isOnline : true,
},{
  name : "홍길북",
  age : 25,
  isOnline : false,
}]

function App() {
  // const [count, setCount] = useState(0)

  return (
    <>
      <ProfileCards proFileCards={proFileCards} />
    </>
  )
}

export default App
