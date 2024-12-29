package com.jastip.entity.security;

import com.jastip.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@Table(name = "c_security_user_password")
public class UserPassword extends BaseEntity {

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user", nullable = false, columnDefinition = "varchar(36)")
    private User user;

    @Column(nullable = false, name = "user_password")
    private String password;


}