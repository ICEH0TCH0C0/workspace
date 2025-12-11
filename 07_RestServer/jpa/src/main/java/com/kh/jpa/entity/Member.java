package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
public class Member {

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
    private String userGender;

    @Column(name = "AGE")
    private int userAge;

    @Column(name = "PHONE", length = 13)
    private String userPhone;

    @Column(name = "ADDRESS", length = 100)
    private String userAddress;

    @Column(name = "ENROLL_DATE")
    @CreationTimestamp
    private LocalDateTime userEnrollDate;

    @Column(name = "MODIFY_DATE")
    @UpdateTimestamp
    private LocalDateTime userModifiedDate;

    @Column(name = "STATUS", nullable = false, length = 1)
    @Enumerated(EnumType.STRING)
    private Status status = Status.Y;

    @PrePersist
    @PreUpdate
    public void checkGender() {
        if (this.userGender == null || (!this.userGender.equals("M") && !this.userGender.equals("F"))) {
            throw new IllegalArgumentException("성별 오류 : M 도는 F");
        }
    }
}
