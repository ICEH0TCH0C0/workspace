import React, { Component } from 'react'
import Comment from './Comment'


const serverCommentData = [
    {
        id: 1,
        msg: "안녕하세요. 홍길동입니다."
    }, {
        id: 2,
        msg: "안녕하세요. 홍길서입니다."
    }, {
        id: 3,
        msg: "안녕하세요. 홍길남입니다."
    },
]

export default class CommentBox extends Component {
    constructor(props){
        super(props);
        this.state = {
            commentList: [],
        }
    }

    componentDidMount() {
        setInterval(() => {
            const {commentList} = this.state;
            
            if(commentList.length < serverCommentData.length){
                const nextComment = serverCommentData[commentList.length];
                this.setState({
                    commentList: [...commentList, nextComment]
                })
            } else {
                this.setState({
                    commentList: [],
                })
            }
        }, 3000)
    }

    render() {
        const {commentList} = this.state;
        return (
            <>
                {
                    commentList.map(c => {
                        <Comment 
                            key={c.id}
                            msg={c.msg}
                        />
                    })
                }
            </>
        )
    }
}
