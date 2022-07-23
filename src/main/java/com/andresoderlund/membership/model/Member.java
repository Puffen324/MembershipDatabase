package com.andresoderlund.membership.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Firstname")
    private String firstName;
    @Column(name = "Lastname")
    private String lastName;
    @Column(name = "Birthdate")
    private String birthDate;
    @Column(name = "Phonenumber")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "License")
    private boolean license;
    @Column(name = "Active")
    private boolean active;
    @Enumerated(EnumType.STRING)
    @Column(name = "Class")
    private AgeRange ageRange;

    public Member() {

    }

}
