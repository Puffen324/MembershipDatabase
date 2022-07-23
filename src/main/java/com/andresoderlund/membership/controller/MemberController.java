package com.andresoderlund.membership.controller;

import com.andresoderlund.membership.dto.MemberDto;
import com.andresoderlund.membership.model.Member;
import com.andresoderlund.membership.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        List<MemberDto> members = memberService.findAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable("id") Integer id) {
        MemberDto member = memberService.findMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member newMember = memberService.saveMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MemberDto> updateMember(@RequestBody MemberDto member) {
        MemberDto updatedMember = memberService.saveMember(member);
        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Integer id) {
        memberService.deleteMemberById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
