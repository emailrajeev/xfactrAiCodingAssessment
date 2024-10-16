package org.xfactr.ai.service;


import org.springframework.stereotype.Service;
import org.xfactr.ai.entity.ServiceRequest;
import org.xfactr.ai.repository.ServiceRequestRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceRequestService {

    private final ServiceRequestRepository repository;

    public ServiceRequestService(ServiceRequestRepository repository) {
        this.repository = repository;
    }

    public List<ServiceRequest> getAll() {
        return repository.findAll();
    }

    public Optional<ServiceRequest> getById(Long id) {
        return repository.findById(id);
    }

    public ServiceRequest create(ServiceRequest serviceRequest) {
        serviceRequest.setId(serviceRequest.getId());
        serviceRequest.setCreatedDate(LocalDateTime.now());
        return repository.save(serviceRequest);
    }

    public ServiceRequest update(Long id, ServiceRequest serviceRequest) {
        serviceRequest.setId(id);
        serviceRequest.setLastModifiedDate(LocalDateTime.now());
        return repository.save(serviceRequest);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

	
}
