package com.jastip.entity.security;

import com.jastip.constants.UserType;
import com.jastip.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "c_security_role")
public class Role extends BaseEntity {

    @NotNull(message = "Role name cannot be null")
    @NotBlank(message = "Role name cannot be blank")
    @Size(min = 2, max = 15, message = "Permission label must be between 2 and 15 characters")
    @Column(name = "name", unique = true)
    private String name;

    @Size(max = 100)
    @Column(name = "description", length = 100)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.MEMBER;

    @ManyToMany
    @OrderBy("permissionValue asc")
    @JoinTable(
            name="c_security_role_permission",
            joinColumns=@JoinColumn(name="id_role", nullable=false, columnDefinition = "VARCHAR(36)"),
            inverseJoinColumns=@JoinColumn(name="id_permission", nullable=false, columnDefinition = "VARCHAR(36)")
    )
    private Set<Permission> permissions = new HashSet<Permission>();

}
