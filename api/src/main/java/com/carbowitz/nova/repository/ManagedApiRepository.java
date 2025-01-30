package com.carbowitz.nova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.carbowitz.nova.model.ManagedApi;

@Component
public interface ManagedApiRepository extends JpaRepository<ManagedApi, Long> {
    Page<ManagedApi> findAllByName(String name, Pageable pageable);
    ManagedApi findByName(String name);
}