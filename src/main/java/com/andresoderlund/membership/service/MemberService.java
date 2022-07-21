package com.andresoderlund.membership.service;

import com.andresoderlund.membership.dto.MemberDto;
import com.andresoderlund.membership.dto.MemberMapper;
import com.andresoderlund.membership.model.Member;
import com.andresoderlund.membership.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record MemberService(MemberRepository memberRepository) {

    //Vill inte exponera personnummer mot användare, därav DTO objekt som inte har personnummer.
    //Direkt när vi hämtar alla medlemmar så gör vi om dem till DTO objekt.
    public List<MemberDto> findAllMembers() {
        return MemberMapper.listToDto(memberRepository.findAll());
    }


    public Optional<MemberDto> findMemberById(Integer id) {
        return memberRepository.findById(id).map(MemberMapper::toDto);
    }

    public Optional<Member> saveMember(Optional<MemberDto> member) {
        return member.map(e -> memberRepository.save(MemberMapper.toEntity(member.get())));
    }

    //För nuvarande mockdata lösning krävs en savemetod som tar en entitet. I övrigt DTOer överallt.
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    public void deleteMember(Optional<MemberDto> member) {
        member.ifPresent(e -> memberRepository.delete(MemberMapper.toEntity(member.get())));
    }
}
