package com.kh.jpa.service;

import com.kh.jpa.dto.MemberDto;
import com.kh.jpa.entity.Member;
import com.kh.jpa.repositoty.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public String createMember(MemberDto.Create createMemberDto) {
        Member member = createMemberDto.toEntity();
        memberRepository.save(member); //member는 이 시점에서 영속상태
        return member.getUserId();
    }

    @Override
    public List<MemberDto.Response> getAllMember() {
        return memberRepository.findAll()
                .stream().map(member -> MemberDto.Response.of(
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

//        List<Member> memberLsit = memberRepository.findAll();
//        List<MemberDto.Response> responseList = new ArrayList<>();
//        for (Member member : memberLsit) {
//            MemberDto.Response response = MemberDto.Response.of(
//                    member.getUserId(),
//                    member.getUserName(),
//                    member.getUserEmail(),
//                    member.getUserGender(),
//                    member.getUserAge(),
//                    member.getUserPhone(),
//                    member.getUserAddress(),
//                    member.getCreateDate(),
//                    member.getModifyDate()
//            );
//
//            responseList.add(response);
//        }
    }

    @Override
    public MemberDto.Response getMemberByUserId(String userId) {
        return memberRepository.findById(userId)
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
        //findById는 Optional리턴함
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        //영속상태의 member를 수정하기때문에 트랜잭션 완료시점에 실제 update문이 절잘된다.
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
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        memberRepository.delete(member);
    }

    @Override
    public List<MemberDto.Response> getMembersByName(String keyword) {
        return memberRepository.findByUserNameContaining(keyword)
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
