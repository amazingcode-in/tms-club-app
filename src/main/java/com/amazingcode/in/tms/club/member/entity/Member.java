package com.amazingcode.in.tms.club.member.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Size(min = 2, max = 20, message = "First name must be greater than 1 or equal to 20 character long.")
    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 20, message = "Middle name must be greater than 1 or equal to 20 character long.")
    @NotBlank(message = "Middle name is mandatory")
    @Column(name = "middle_name")
    private String middleName;

    @Size(min = 2, max = 20, message = "Last name must be greater than 1 or equal to 20 character long.")
    @NotBlank(message = "Last name is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Date of birth is mandatory.")
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Size(min = 2, max = 20,message = "Gender must be greater than 1 or equal to 20 character long.")
    @NotBlank(message = "Gender is mandatory")
    @Column(name = "gender",length = 20, nullable = false)
    private String gender;

    @Size(min = 2, max = 200, message = "Address must be greater than 1 or equal to 200 character long.")
    @NotBlank(message = "Address is mandatory.")
    @Column(name = "address")
    private String address;

    @Size(min = 10, max = 15,message = "Phone number must be greater than 9 or equal to 15 digits long.")
    @NotBlank(message = "Phone number is mandatory")
    @Column(name = "phone_number",length = 15, nullable = false, unique = true)
    private String phoneNumber;

    @Size(min = 10, max = 40,message = "Email address must be greater than 9 or equal to 40 character long.")
    @NotBlank(message = "Email address is mandatory")
    @Column(name = "email_address",length = 40, nullable = false, unique = true)
    private String emailAddress;

    @Size(min = 2, max = 30, message = "Profession must be greater than 1 or equal to 30 character long.")
    @NotBlank(message = "Profession is mandatory.")
    @Column(name = "profession")
    private String profession;

    @Column(name = "club_joining_date", nullable = false)
    private LocalDate clubJoiningDate;
}
