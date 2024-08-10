package com.boot.usermanagementsystem.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false, length = 15)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 15)
    private String lastname;

    @Column(name = "pin", nullable = false, unique = true, length = 7)
    @Size (min = 7, max = 7, message = ("Pin must be exactly 7 symbol!"))
    private String pin;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

//    @OneToOne(mappedBy = "user")
//    private ProfileEntity profile;

}
