package com.andresoderlund.membership;

import com.andresoderlund.membership.model.Member;
import com.andresoderlund.membership.service.DbService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.andresoderlund.membership.repository")
@SpringBootApplication
public class MembershipApplication {

    public static void main(String[] args) {
        SpringApplication.run(MembershipApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(DbService dbService) {
        return args -> {
            Member member = new Member();
            member.setFirstName("André");
            dbService.saveMember(member);

        };
    }

}
