import { useLocation, useParams } from 'react-router-dom'

const Profile = () => {
    const {username} = useParams();

    const {search} = useLocation(); // 모든 쿼리스트림
    const query = new URLSearchParams(search);
    const sort = query.get("sort");
    console.log(sort);

  return (
    <>
        <div>프로필 페이지 입니다.</div>
        <p>사용자 : {username}</p>
    </>
  )
}

export default Profile