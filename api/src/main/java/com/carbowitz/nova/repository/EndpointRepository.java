package com.carbowitz.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

import com.carbowitz.nova.model.Endpoint;

@Component
public interface EndpointRepository extends JPARepository<Endpoint, Long> {
    Optional<Endpoint> findById(Long id);
    Endpoint findByName(String name);
    long deleteByEndpointId(Long endpointId);
}