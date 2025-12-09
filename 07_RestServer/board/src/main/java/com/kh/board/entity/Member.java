package com.kh.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int email;
    private String password;
    private String nickname;
    private String createdAt;
    private String updatedAt;

}
