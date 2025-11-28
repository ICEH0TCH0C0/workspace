import { BrowserRouter, Routes, Route} from 'react-router-dom'
import './App.css'
import UserList from './pages/UserList'
import UserDetail from './pages/UserDetail'
import UserRegistation from './pages/UserRegistation'
import NotFound from './pages/NotFound'
import UserContext from './pages/userContext'

const users = [
  {
    id: 1,
    name: '홍길동',
    age: 22,
    isOnline: false
  },
  {
    id: 2,
    name: '홍길서',
    age: 22,
    isOnline: true
  },
  {
    id: 3,
    name: '홍길남',
    age: 22,
    isOnline: false
  },
  {
    id: 4,
    name: '홍길북',
    age: 22,
    isOnline: true
  }
]

function App() {

  return (
    <BrowserRouter>
        {/* <nav>
          <Link to="/">사용자 목록 페이지</Link>
          <Link to="/user">사용자 등록 페이지</Link>
        </nav> */}
      <UserContext.Provider value={users}>
        <Routes>
          <Route path="/" element={<UserList />} />
          <Route path="/user/:id" element={<UserDetail />} />
          <Route path="/user" element={<UserRegistation />} />
          <Route path="/*" element={<NotFound />} />
        </Routes>
      </UserContext.Provider>
    </BrowserRouter>
  )
}

export default App
