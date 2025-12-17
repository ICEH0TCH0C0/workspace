package com.kh.jpa.service;

import com.kh.jpa.dto.MemberDto;
import com.kh.jpa.entity.Member;

import java.util.List;

public interface MemberService {
    String createMember(MemberDto.Create createMemberDto);
    List<MemberDto.Response> getAllMember();
    MemberDto.Response getMemberByUserId(String id);
    MemberDto.Response updateMember(String userId,  MemberDto.Update updateMemberDto);
    void deleteMember(String userId);
    List<MemberDto.Response> getMembersByName(String keyword);
}
