package com.andresoderlund.membership;

import com.andresoderlund.membership.model.AgeRange;
import com.andresoderlund.membership.model.Member;
import com.andresoderlund.membership.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class MembershipApplication {

    public static void main(String[] args) {
        SpringApplication.run(MembershipApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(MemberService memberService) {
        return args -> {
            for (int i = 0; i <= 250; i++) {
                Member member = new Member();
                member.setId(i);
                member.setFirstName("André".concat(String.valueOf(i)));
                member.setLastName("Söderlund".concat(String.valueOf(i)));
                if (i % 2 == 0) {
                    member.setAgeRange(AgeRange.ADULT);
                } else {
                    member.setAgeRange(AgeRange.RETIREE);
                }
                member.setActive(true);
                member.setLicense(true);
                member.setBirthDate("950206-9454".concat(String.valueOf(i)));
                memberService.saveMember(member);
            }

        };
    }

}
