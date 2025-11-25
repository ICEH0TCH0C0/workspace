import React from 'react'
import styled from 'styled-components'
import { Container } from './VideoCard.styled'

const Container = styled.div`
    display: flex;
    justify-content: flex-start;
    gap: 16px;
    flex-wrap: wrap;
`

const Videos = ({videoList}) => {
    
  return (
    <Container>
        {videoList.map((v, index) => <videoCard key={index} video={v}/>)}
    </Container>
  )
}

export default Videos