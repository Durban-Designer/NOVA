package com.carbowitz.nova.service;

import com.carbowitz.nova.dto.ManagedApiCreationDTO;
import com.carbowitz.nova.model.ManagedApi;
import com.carbowitz.nova.repository.ManagedApiRepository;
import com.carbowitz.nova.utility.ResponseMessages;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ManagedApiService {

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 10;

    private final ManagedApiRepository managedApiRepository;

    @Autowired
    public ManagedApiService(ManagedApiRepository managedApiRepository) {
        this.managedApiRepository = managedApiRepository;
    }

    @Transactional
    public ManagedApi createManagedApi(ManagedApiCreationDTO managedApiCreationDTO) throws IllegalArgumentException {
        if (managedApiCreationDTO == null || managedApiCreationDTO.getName() == null) {
            throw new IllegalArgumentException(ResponseMessages.NoNullManagedApiCreationDto);
        }
        if (managedApiRepository.findByName(managedApiCreationDTO.getName()) != null) {
            throw new IllegalArgumentException(ResponseMessages.NameExistsManagedApiCreation(managedApiCreationDTO.getName()));
        }
        ManagedApi managedApi = new ManagedApi();
        managedApi.setName(managedApiCreationDTO.getName());
        managedApiRepository.save(managedApi);
        return managedApi;
    }

    @Transactional
    public Iterable<ManagedApi> findAll(Pageable paging) {
        return managedApiRepository.findAll(paging);
    }

    @Transactional
    public Iterable<ManagedApi> findAllByName(String name, Pageable paging) {
        return managedApiRepository.findAllByName(name, paging);
    }

    public Pageable createPageable(Integer pageNumber, Integer pageSize) {
        int validPageNumber = (pageNumber == null || pageNumber < 0) ? DEFAULT_PAGE_NUMBER : pageNumber;
        int validPageSize = (pageSize == null || pageSize <= 0) ? DEFAULT_PAGE_SIZE : pageSize;
        return PageRequest.of(validPageNumber, validPageSize);
    }
}