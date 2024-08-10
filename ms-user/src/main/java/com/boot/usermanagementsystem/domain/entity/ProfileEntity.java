package com.boot.usermanagementsystem.domain.entity;//package com.boot.userapp.domain.entity;
//
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//public class ProfileEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private UserEntity user;
//
//    @Column(nullable = false, length = 50)
//    private String firstName;
//
//    @Column(nullable = false, length = 50)
//    private String lastName;
//
//    @Column(length = 100)
//    private String address;
//
//    @Column(length = 15)
//    private String phoneNumber;
//
//    @Column(length = 100)
//    private String email;
//
//    @Lob
//    @Column(name = "profile_image", columnDefinition = "TEXT")
//    private String image;
//
//}
