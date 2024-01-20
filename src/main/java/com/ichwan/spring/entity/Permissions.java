package com.ichwan.spring.entity;

import com.ichwan.spring.enumeration.PermissionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Permissions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Enumerated(value = EnumType.STRING)
    private PermissionType permissionType;

    @ManyToOne
    private Roles roles;
}
