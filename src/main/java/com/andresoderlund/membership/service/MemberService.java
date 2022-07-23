package com.andresoderlund.membership.service;

import com.andresoderlund.membership.dto.MemberDto;
import com.andresoderlund.membership.dto.MemberMapper;
import com.andresoderlund.membership.exception.MemberNotFoundException;
import com.andresoderlund.membership.model.Member;
import com.andresoderlund.membership.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //Vill inte exponera personnummer mot användare, därav DTO objekt som inte har personnummer.
    //Direkt när vi hämtar alla medlemmar så gör vi om dem till DTO objekt.
    public List<MemberDto> findAllMembers() {
        return MemberMapper.listToDto(memberRepository.findAll());
    }

    public MemberDto findMemberById(Integer id) {
        return memberRepository.findById(id).map(MemberMapper::toDto)
                .orElseThrow(() -> new MemberNotFoundException("Member with id " + id + " not found!"));
    }

    public MemberDto saveMember(MemberDto member) {
        memberRepository.save(MemberMapper.toEntity(member));
        return memberRepository.findById(member.getId()).map(MemberMapper::toDto)
                .orElseThrow(() -> new MemberNotFoundException("Member with id " + member.getId() + " not found!"));
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(Optional<MemberDto> member) {
        member.ifPresent(e -> memberRepository.delete(MemberMapper.toEntity(member.get())));
    }

    public void deleteMemberById(Integer id) {
        memberRepository.deleteMemberById(id);
    }
}
