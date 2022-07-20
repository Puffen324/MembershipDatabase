package com.andresoderlund.membership.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "Förnamn")
    private String firstName;
    @Column(name = "Efternamn")
    private String lastName;
    @Column(name = "Födelsedatum")
    private String birthDate;
    @Enumerated
    private AgeRange ageRange;
    @Column(name = "Tävlingslicens")
    private boolean license;
    @Column(name = "Aktiv")
    private boolean active;

    public Member() {

    }

}
