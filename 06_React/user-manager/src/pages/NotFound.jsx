import { useNavigate }from 'react'

const NotFound = () => {
  const navigate = useNavigate();
  const goBack = () => {
        navigate("/");
    }

  return (
    <div>
      <h1>페이지를 찾을 수 없습니다.</h1>
      <button onClick={goBack}>돌아가기</button>
    </div>
  )
}

export default NotFound