package com.carbowitz.nova.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.Optional;

import com.carbowitz.nova.model.Service;

@Component
public interface ServiceRepository extends PagingAndSortingRepository<Service, Long> {
    Page<Service> findAll(Pageable pageable);
    Page<Service> findAllByName(String name, Pageable pageable);
    Optional<Service> findById(Long id);
    Service findByName(String name);
    void deleteById(Long serviceId);
}