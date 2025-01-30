package com.carbowitz.nova.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "services")
@Data
public class ManagedApi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "managedApi", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Endpoint> endpoints;
}
