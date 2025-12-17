package com.kh.jpa.dto;

import com.kh.jpa.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

public class MemberDto {

    @NoArgsConstructor
    @Setter
    @Getter
    @AllArgsConstructor
    public static class Create {
        private String user_id;
        private String user_pwd;
        private String user_name;
        private String user_email;
        private Member.Gender user_gender;
        private Integer user_age;
        private String user_phone;
        private String user_address;

        public Member toEntity() {
            return Member.builder()
                    .userId(user_id)
                    .userPwd(user_pwd)
                    .userName(user_name)
                    .userEmail(user_email)
                    .userGender(user_gender)
                    .userAge(user_age)
                    .userPhone(user_phone)
                    .userAddress(user_address)
                    .build();
        }
    }

    @NoArgsConstructor
    @Setter
    @Getter
    @AllArgsConstructor
    public static class Update {
        private String user_name;
        private String user_email;
        private Member.Gender user_gender;
        private Integer user_age;
        private String user_phone;
        private String user_address;

    }

    @NoArgsConstructor
    @Setter
    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String user_id;
        private String user_name;
        private String user_email;
        private Member.Gender user_gender;
        private Integer user_age;
        private String user_phone;
        private String user_address;
        private LocalDateTime create_date;
        private LocalDateTime modify_date;

        public static Response of(String user_id,
                                  String user_name,
                                  String user_email,
                                  Member.Gender user_gender,
                                  Integer user_age,
                                  String user_phone,
                                  String user_address,
                                  LocalDateTime create_date,
                                  LocalDateTime modify_date) {
            return Response.builder()
                    .user_id(user_id)
                    .user_name(user_name)
                    .user_email(user_email)
                    .user_gender(user_gender)
                    .user_age(user_age)
                    .user_phone(user_phone)
                    .user_address(user_address)
                    .create_date(create_date)
                    .modify_date(modify_date)
                    .build();
        }
    }
}

