package com.lessons.home.springsecurity.entity.content;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * This class that has general info for main pages in web platform.
 * Values saves in name and info  (temporary alternative 'key-value')
 */
@Entity
@Table(name = "general_info")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GeneralInfo implements Serializable {

    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String info;
}
