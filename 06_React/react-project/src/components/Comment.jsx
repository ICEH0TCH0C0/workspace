import React, { Component } from 'react'
import { styled } from 'styled-components'


const Container = styled.div`
    display: flex;
    border: 1px solid black;
    padding: 10px;
`

export default class Comment extends Component {
    constructor(props) {
        super(props)

        this.state = {}
    }

    //컴포넌트가 마운트가 된 후 호출
    componentDidMount() {
        console.log("componentDidMount : 컴포넌트 마운트 완료")
    }

    //컴포넌트가 업데이트가 된 후 호출
    componentDidUpdate(prevProps, prevState){
        console.log("componentDidUpdate : 컴포넌트 업데이트 완료")
        console.log("prevProps(이전 props) : ", prevProps)
        console.log("prevState(이전 state) : ", prevState)
    }

    //컴포넌트가 언마운트가 된 후 호출
    componentWillUnmount() {
        console.log("componentWillUnmount : 컴포넌트 제거 완료")
    
    }

  render() {
    return (
      <Container>
        <span>{this.props.msg}</span>
      </Container>
    )
  }
}
