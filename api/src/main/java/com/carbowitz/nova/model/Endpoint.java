package com.carbowitz.nova.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "endpoints")
@Data
public class Endpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "url")
    private String url;

    @NotBlank
    @Column(name = "maxWaitTime")
    private Long maxWaitTime;

    @NotBlank
    @Column(name = "requestType")
    private String requestType;

    @ManyToOne
    private ManagedApi managedApi;
}
