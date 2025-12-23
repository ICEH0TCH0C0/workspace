package com.kh.jpa.service;

import com.kh.jpa.dto.MemberDto;
import com.kh.jpa.entity.Member;
import com.kh.jpa.repository.MemberJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceJpa implements MemberService {

    private final MemberJPARepository memberJPARepository;

    @Override
    public String createMember(MemberDto.Create createMemberDto) {
        Member member = createMemberDto.toEntity();
        memberJPARepository.save(member);
        return member.getUserId();
    }

    @Override
    public List<MemberDto.Response> getAllMember() {
        return memberJPARepository.findAll()
                .stream()
                .map(member -> MemberDto.Response.of(
                        member.getUserId(),
                        member.getUserName(),
                        member.getUserEmail(),
                        member.getUserGender(),
                        member.getUserAge(),
                        member.getUserPhone(),
                        member.getUserAddress(),
                        member.getCreateDate(),
                        member.getModifyDate()
                )).toList();
    }

    @Override
    public MemberDto.Response getMemberByUserId(String userId) {
        return memberJPARepository.findById(userId)
                .map(member -> MemberDto.Response.of(
                        member.getUserId(),
                        member.getUserName(),
                        member.getUserEmail(),
                        member.getUserGender(),
                        member.getUserAge(),
                        member.getUserPhone(),
                        member.getUserAddress(),
                        member.getCreateDate(),
                        member.getModifyDate())
                )
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    @Override
    public MemberDto.Response updateMember(String userId, MemberDto.Update updateMemberDto) {
        Member member = memberJPARepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        member.putUpdate(
                updateMemberDto.getUser_name(),
                updateMemberDto.getUser_email(),
                updateMemberDto.getUser_gender(),
                updateMemberDto.getUser_age(),
                updateMemberDto.getUser_phone(),
                updateMemberDto.getUser_address()
        );

        return MemberDto.Response.of(
                member.getUserId(),
                member.getUserName(),
                member.getUserEmail(),
                member.getUserGender(),
                member.getUserAge(),
                member.getUserPhone(),
                member.getUserAddress(),
                member.getCreateDate(),
                member.getModifyDate()
        );
    }

    @Override
    public void deleteMember(String userId) {
        Member member = memberJPARepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        memberJPARepository.delete(member);
    }

    @Override
    public List<MemberDto.Response> getMembersByName(String keyword) {
        return  memberJPARepository.findByUserNameContaining(keyword)
                .stream()
                .map((member) -> MemberDto.Response.of(
                        member.getUserId(),
                        member.getUserName(),
                        member.getUserEmail(),
                        member.getUserGender(),
                        member.getUserAge(),
                        member.getUserPhone(),
                        member.getUserAddress(),
                        member.getCreateDate(),
                        member.getModifyDate()
                )).toList();
    }
}
