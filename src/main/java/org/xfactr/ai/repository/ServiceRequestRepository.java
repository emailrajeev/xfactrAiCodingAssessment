package org.xfactr.ai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.xfactr.ai.entity.ServiceRequest;


public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
}
