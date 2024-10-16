package org.xfactr.ai.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xfactr.ai.entity.ServiceRequest;
import org.xfactr.ai.service.ServiceRequestService;

import java.util.List;


@RestController
@RequestMapping("/api/servicerequest")
public class ServiceRequestController {

    private final ServiceRequestService service;

    public ServiceRequestController(ServiceRequestService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequest>> getAll() {
        List<ServiceRequest> requests = service.getAll();
        return requests.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(requests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceRequest> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ServiceRequest> create(@RequestBody ServiceRequest serviceRequest) {
        ServiceRequest createdRequest = service.create(serviceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRequest> update(@PathVariable Long id, @RequestBody ServiceRequest serviceRequest) {
        
    		if( service.getById(id).isEmpty()) {
    			return ResponseEntity.notFound().build();
    		}
            ServiceRequest updatedRequest = service.update(id, serviceRequest);
        	return ResponseEntity.ok(updatedRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	if( service.getById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			service.delete(id);
			return ResponseEntity.notFound().build();
		}
    	
    }
}
