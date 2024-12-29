package com.jastip.entity.security;

import com.jastip.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "c_security_permission")
public class Permission extends BaseEntity {

    @NotNull(message = "Permission label cannot be null")
    @NotBlank(message = "Permission label cannot be blank")
    @Size(min = 2, max = 100, message = "Permission label must be between 2 and 100 characters")
    @Column(name = "permission_label")
    private String permissionLabel;

    @NotNull(message = "Permission value cannot be null")
    @NotBlank(message = "Permission value cannot be blank")
    @Size(min = 2, max = 100, message = "Permission value must be between 2 and 100 characters")
    @Column(name = "permission_value", nullable = false, length = 100)
    private String permissionValue;


}