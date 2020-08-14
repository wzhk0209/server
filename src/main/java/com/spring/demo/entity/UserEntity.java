package com.spring.demo.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String UserName;

    private String password;

    public UserEntity(String userName, String password) {
        UserName = userName;
        this.password = password;
    }
}
