package com.lessons.home.springsecurity.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Persistent object "User" for Spring Security
 *
 * @author  Vitalik Skuratovskyj
 */
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Wrong format for email")
    private String email;

    @Size(min = 6, max = 32, message = "Wrong format, the name range is from 6 to 32")
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @Size(min = 6, max = 64, message = "Wrong format, the password range is from 6 to 64")
    @NotBlank(message = "Password cannot be empty")
    private String password;
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
