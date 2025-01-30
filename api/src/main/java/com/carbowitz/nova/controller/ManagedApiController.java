package com.carbowitz.nova.controller;

import com.carbowitz.nova.dto.ManagedApiCreationDTO;
import com.carbowitz.nova.model.ManagedApi;
import com.carbowitz.nova.service.ManagedApiService;
import com.carbowitz.nova.utility.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/managed/api")
public class ManagedApiController {

    private final ManagedApiService managedApiService;

    @Autowired
    public ManagedApiController(ManagedApiService managedApiService) {
        this.managedApiService = managedApiService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createServiceRecord(@RequestBody ManagedApiCreationDTO managedApiCreationDTO) {
        try {
            ManagedApi managedApi = managedApiService.createManagedApi(managedApiCreationDTO);
            return ResponseEntity.ok(managedApi);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllServices(
            @RequestParam( value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam( value = "pageSize", defaultValue = "10") int pageSize
    ) {
        try {
            return ResponseEntity.ok(managedApiService.findAll(managedApiService.createPageable(pageNumber, pageSize)));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(ResponseMessages.failedToFindAllServices);
        }
    }

    @GetMapping(
            value = "/name",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> getAllServicesByName(
            @RequestParam( value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam( value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam( value = "name") String name
    ) {
        try {
            return ResponseEntity.ok(managedApiService.findAllByName(name, managedApiService.createPageable(pageNumber, pageSize)));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(ResponseMessages.failedToFindAllServices);
        }
    }
}
