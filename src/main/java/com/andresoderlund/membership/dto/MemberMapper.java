package com.andresoderlund.membership.dto;

import com.andresoderlund.membership.model.Member;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMapper {

    public static MemberDto toDto(Member member) {
        if (member == null) {
            return null;
        }
        MemberDto memberDto = new MemberDto();
        memberDto.setId(member.getId());
        memberDto.setFirstName(member.getFirstName());
        memberDto.setLastName(member.getLastName());
        memberDto.setEmail(member.getEmail());
        memberDto.setPhone(member.getPhone());
        memberDto.setAgeRange(member.getAgeRange());
        memberDto.setActive(member.isActive());
        memberDto.setLicense(member.isLicense());

        return memberDto;
    }

    public static List<MemberDto> listToDto(List<Member> members) {
        if (members == null) {
            return null;
        }
        return members.stream().map(MemberMapper::toDto).collect(Collectors.toList());
    }

    public static Member toEntity(MemberDto memberDto) {
        if (memberDto == null) {
            return null;
        }
        Member member = new Member();

        member.setId(memberDto.getId());
        member.setFirstName(memberDto.getFirstName());
        member.setLastName(memberDto.getLastName());
        member.setAgeRange(memberDto.getAgeRange());
        member.setEmail(memberDto.getEmail());
        member.setPhone(memberDto.getPhone());
        member.setActive(memberDto.isActive());
        member.setLicense(memberDto.isLicense());

        return member;
    }

    public static List<Member> listToEntity(List<MemberDto> members) {
        if (members == null) {
            return null;
        }
        return members.stream().map(MemberMapper::toEntity).collect(Collectors.toList());
    }
}
