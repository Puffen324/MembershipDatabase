package com.andresoderlund.membership.dto;

import com.andresoderlund.membership.model.AgeRange;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private AgeRange ageRange;

    private boolean license;

    private boolean active;
}
