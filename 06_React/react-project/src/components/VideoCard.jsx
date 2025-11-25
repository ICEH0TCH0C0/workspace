import React from 'react'
import { Container, Thumbnail } from './VideoCard.styled'

const VideoCard = ({video}) => {
  return (
    <Container>
        <Thumbnail 
            src={video.url}
            alt={video.title}
        />
        <ChannelInfo>
            <ChannelLogo 
                src="{video.logo}" 
                alt="video.channelName" 
            />
            <ChannelDetails>
                <Title>{video.title}</Title>
                <ChannelName>{video.channelName}</ChannelName>
                <p>{video.views} 조회수 | {video.date}</p>
            </ChannelDetails>
        </ChannelInfo>
    </Container>
  )
}

export default VideoCard