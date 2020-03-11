package com.nouhoun.springboot.jwt.integration.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by nydiarra on 06/05/17.
 */
@Entity
@Table(name="app_role")
@Getter
@Setter
public class Role {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name")
    private String roleName;

    @Column(name="description")
    private String description;
}
