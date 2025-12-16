package com.kh.jpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "PROFILE")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROFILE_ID")
    private Long profileId;

    //프로필 : 회원 (1 : 1) - 연관 관계 주인으로 Profile을 사용, 반대로 해도 가능

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", unique = true, nullable = false)
    private Member member;

    @Column(name = "PROFILE_IMAGE", length = 100)
    private String profileImage;

    @Column(name = "INTRO", length = 300)
    private String introduction;
}
