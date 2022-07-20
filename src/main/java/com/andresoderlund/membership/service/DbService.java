package com.andresoderlund.membership.service;

import com.andresoderlund.membership.model.Member;
import com.andresoderlund.membership.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record DbService(MemberRepository memberRepository) {


    /*public Member findMemberById(Integer id) {
        return memberRepository.findById(id).orElse(null);
    }*/

    public Optional<Member> findMemberById(Integer id) {
        return memberRepository.findById(id);
    }

   /* public void saveMember(Member member) {
        if (member != null) {
            memberRepository.save(member);
        }
    }*/

    public void saveMember(Optional<Member> member) {
        member.ifPresent(memberRepository::save);
    }


}
