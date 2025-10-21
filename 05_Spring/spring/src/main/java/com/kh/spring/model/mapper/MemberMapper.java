package com.kh.spring.model.mapper;

import com.kh.spring.model.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
*   @Mapper : Mybatis의 mapper 인터페이스를 정의할 때 사용하는 어노테이션
*             스프링 Bean으로 등록하여 의존성 주입이 가능하게 만들어진다.
* */

@Mapper
public interface MemberMapper {
    Member getMemberById(@Param("memberId") String memberId);
    int getMemberCountById(@Param("memberId") String memberId);
    int addMember(Member member);
    //@Param을 사용하면 mapper.xml에서는 member.을 앞에 붙여야 하며
    //parameterType을 작성하지 말아야 한다.
}
