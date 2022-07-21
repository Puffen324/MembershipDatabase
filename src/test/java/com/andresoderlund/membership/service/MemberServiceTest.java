package com.andresoderlund.membership.service;

import com.andresoderlund.membership.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void itShouldFindAllMembers() {
        //given
        List<MemberDto> members = memberService.findAllMembers();

        //when
        int expected = 250;

        //then
        assertThat(members.size() == expected).isTrue();
    }

    @Test
    void itShouldFindMemberById() {
        //given
        int id = 5;
        Optional<MemberDto> member = memberService.findMemberById(id);

        //when
        String expected = "André5";

        //then
        assertThat(member.isPresent()).isTrue();
        assertThat(member.get().getFirstName()).isEqualTo(expected);
    }

    @Test
    void itShouldSaveMember() {
        //given
        String name = "Test";
        Optional<MemberDto> member = memberService.findMemberById(10);
        member.ifPresent(e -> e.setFirstName(name));
        memberService.saveMember(member);

        //when
        String expected = "Test";

        //then
        assertThat(memberService.findMemberById(10).get().getFirstName()).isEqualTo(expected);
        assertThat(memberService.findMemberById(10).map(MemberDto::getFirstName)).isEqualTo(Optional.of(expected));
    }

    @Test
    void itShouldDeleteMember() {
        //given
        Optional<MemberDto> member = memberService.findMemberById(5);

        //when
        memberService.deleteMember(member);

        //then
        assertThat(memberService.findMemberById(5)).isEmpty();
    }

    @Test
    void memberRepository() {
    }
}