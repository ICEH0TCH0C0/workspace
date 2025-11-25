import React from 'react'
import { Container, Online, Offline, ProFileState, IsOnline} from './ProFileCard.styled'

const ProfileCard = ({proFileCard}) => {
  return (
    <Container>
        <IsOnline>{proFileCard.isOnline ? <Online/> : <Offline/>}</IsOnline>
        <ProFileState>{proFileCard.name} | {proFileCard.age}</ProFileState>
    </Container>
  )
}

export default ProfileCard