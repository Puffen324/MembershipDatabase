package com.andresoderlund.membership.service;

import com.andresoderlund.membership.model.Member;
import com.andresoderlund.membership.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public record DbService(MemberRepository memberRepository) {


    public void saveMember(Member member) {
        memberRepository.save(member);
    }


}
