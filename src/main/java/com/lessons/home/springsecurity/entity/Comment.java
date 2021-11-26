package com.lessons.home.springsecurity.entity;

import com.lessons.home.springsecurity.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID = 4911927409123736484L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(columnDefinition = "varchar(500)")
    private String text;

    @NotNull
    @Column(name = "date_of_create", updatable = false)
    private LocalDate dateOfCreate;

    private boolean likes;
    private boolean dislikes;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User author;
}
