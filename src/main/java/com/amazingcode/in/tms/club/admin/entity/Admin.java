package com.amazingcode.in.tms.club.admin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "amdin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_id",length = 4, nullable = true, unique = true)
    private Long adminId;

    @Size(min = 5, max = 20, message = "Password must be greater that 4 or equal to 20 character long.")
    @NotBlank(message = "Password is mandatory")
    @Column(name = "password", length = 40, nullable = false)
    private String password;

    @Size(min = 2, max = 20,message = "First name must be greater than 1 or equal to 20 character long.")
    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name",length = 20, nullable = false)
    private String firstName;

    @Column(name = "middle_name",length = 20, nullable = true)
    private String middleName;

    @Size(min = 2, max = 20,message = "Last name must be greater than 1 or equal to 20 character long.")
    @NotBlank(message = "Last name is mandatory")
    @Column(name = "last_name",length = 20, nullable = false)
    private String lastName;

    @Size(min = 2, max = 20,message = "Gender must be greater than 1 or equal to 20 character long.")
    @NotBlank(message = "Gender is mandatory")
    @Column(name = "gender",length = 20, nullable = false)
    private String gender;

    @Size(min = 10, max = 15,message = "Phone number must be greater than 9 or equal to 15 digits long.")
    @NotBlank(message = "Phone number is mandatory")
    @Column(name = "phone_number",length = 15, nullable = false, unique = true)
    private String phoneNumber;

    @Size(min = 10, max = 40,message = "Email address must be greater than 9 or equal to 40 character long.")
    @NotBlank(message = "Email address is mandatory")
    @Column(name = "email_address",length = 40, nullable = false, unique = true)
    private String emailAddress;

    @NotNull(message = "Date of birth is mandatory")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PostPersist
    protected void onPostPersist() {
        if (adminId == null) {
            adminId = 1000 + id;
        }
    }
}
