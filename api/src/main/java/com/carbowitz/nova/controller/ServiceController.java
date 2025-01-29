package com.carbowitz.nova.controller;

import com.carbowitz.nova.repository.ServiceRepository;
import com.carbowitz.nova.utilities.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllServices(
            @RequestParam( value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam( value = "pageSize", defaultValue = "10") int pageSize
    ) {
        try {
            // get all services
            Pageable paging = PageRequest.of(pageNumber, pageSize);
            return ResponseEntity.ok(serviceRepository.findAll(paging));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(ResponseMessages.failedToFindAllServices);
        }
    }
}
