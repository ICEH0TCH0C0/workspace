import './App.css'
// import MyInfo from './components/customHook/MyInfo'
// import ToggleBox from './components/customHook/ToggleBox'
import Header from './components/useContext/Header'
import { UserProvider } from './components/useContext/UserContext'
// import UseContextTest from './components/useContext/UseContextTest'
// import UseCallBackTest from './components/useCallback/UseCallBackTest'
// import UseEffectView from './components/useEffect/UseEffectView'
// import UseMemoTest from './components/useMemo/UseMemoTest'
// import UseRefScroll from './components/useRef/UseRefScroll'
// import UseRefTest from './components/useRef/UseRefTest'
// import LandingPage from './components/useState/LandingPage'
// import Signup from './components/useState/Signup'
// import UseStateTest from './components/UseStateTest'

function App() {

  return (
    <>
      {/* <UseStateTest /> */}
      {/* <Signup /> */}
      {/* <LandingPage /> */}
      {/* <UseRefTest /> */}
      {/* <UseRefScroll /> */}
      {/* <UseMemoTest /> */}
      {/* <UseCallBackTest /> */}
      {/* <UseEffectView /> */}
      {/* <UseContextTest /> */}
      {/* <MyInfo /> */}
      {/* <ToggleBox /> */}
      <UserProvider>
        <Header />
      </UserProvider>
    </>
  )
}

export default App
