package com.jastip.entity;

import com.jastip.entity.security.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member extends BaseEntity {


    @NotNull(message = "First name cannot be null")
    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;


    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    private String imgProfileUrl;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false, columnDefinition = "varchar(36)")
    private User user;

}