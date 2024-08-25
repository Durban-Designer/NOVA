package com.neuronaut.nova.model;

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

    @ManyToOne(mappedBy="endpoints")
    private Service service;
}
