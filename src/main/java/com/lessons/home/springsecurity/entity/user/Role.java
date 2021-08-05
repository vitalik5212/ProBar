package com.lessons.home.springsecurity.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 *  Persistent object that has roles for Users in Spring Security
 *
 * @author Vitalik Skuratovskyj
 */
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}