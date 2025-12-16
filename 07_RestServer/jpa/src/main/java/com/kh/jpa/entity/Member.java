package com.kh.jpa.entity;

import com.kh.jpa.enums.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 스펙상 필수
@Table(name = "MEMBER")
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "USER_ID", length = 30)
    private String userId;

    @Column(name = "USER_PWD",length = 100, nullable = false)
    private String userPwd;

    @Column(name = "USER_NAME",length = 15, nullable = false)
    private String userName;

    @Column(name = "EMAIL", length = 254)
    private String userEmail;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender userGender;

    @Column(name = "AGE")
    private Integer userAge;

    @Column(name = "PHONE", length = 13)
    private String userPhone;

    @Column(name = "ADDRESS", length = 100)
    private String userAddress;

    //cascade : Member 객체가 상태 자체가 삭제(변경)되면, profile에도 영향을 주겠다.
    //orphanRemoval : Member 객체에서 profile의 참조 값이 삭제되면 실제 DB에 반영하겠다.
    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    @Column(name = "STATUS", nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private Status status = Status.Y;

    @OneToMany(mappedBy = "boardWriter", fetch = FetchType.LAZY)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "replyWriter", fetch = FetchType.LAZY)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "noticeWriter", fetch = FetchType.LAZY)
    private List<Notice> notices = new ArrayList<>();

//    @PrePersist
//    @PreUpdate
//    public void checkGender() {
//        if (this.userGender == null || (!this.userGender.equals("M") && !this.userGender.equals("F"))) {
//            throw new IllegalArgumentException("성별 오류 : M 도는 F");
//        }
//    }
    private enum Gender {
        M, F
    }
}
