package com.jastip.entity.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jastip.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Data
@Entity
@Table(name = "c_security_user")
public class User extends BaseEntity {

    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters")
    private String username;

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Size(min = 2, max = 50, message = "Email must be between 2 and 50 characters")
    private String email;

    @NotNull(message = "Phone Number cannot be null")
    @NotBlank(message = "Phone Number cannot be blank")
    @Size(min = 2, max = 15, message = "Phone number must be between 2 and 50 characters")
    private String phone;

    private boolean active;

    @JsonIgnore
    @OneToOne(mappedBy = "user", optional = true, orphanRemoval = true)
    @Cascade({CascadeType.ALL})
    private UserPassword userPassword;

    @NotNull(message = "Role cannot be null")
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role role;



}
