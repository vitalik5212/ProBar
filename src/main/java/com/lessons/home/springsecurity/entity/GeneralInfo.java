package com.lessons.home.springsecurity.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "general_info")
public class GeneralInfo extends BaseEntity {

    private String name;

    private String info;
}
