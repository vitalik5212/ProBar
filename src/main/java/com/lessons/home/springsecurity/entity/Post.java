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
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 2874128254638251712L;
    
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "text_content",
            columnDefinition = "varchar(1500)")
    private String textContent;

    @NotNull
    @Column(name = "date_of_create")
    private LocalDate dateOfCreate;

    private Integer raiting;

    private boolean likes;
    private boolean dislikes;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",
            columnDefinition = "bigint")
    private Set<Comment> comments = new HashSet<>();
}
