import React from 'react'
import ProfileCard from './ProfileCard'
import styled from 'styled-components'

const Container = styled.div`
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  justify-content: center;
  align-items: center;
  /* border-left: 1px solid white;
  border-right: 1px solid white; */
  gap: 10px;
`

const ProfileCards = ({proFileCards}) => {
  return (
    <Container>
      {proFileCards.map((p, index) => (
        <ProfileCard key={index} proFileCard={p} />))}
    </Container>
  )
}

export default ProfileCards