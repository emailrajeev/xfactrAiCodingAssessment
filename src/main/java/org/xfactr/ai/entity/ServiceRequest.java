package org.xfactr.ai.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


import org.xfactr.ai.enums.CurrentStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ServiceRequest")
public class ServiceRequest {

    @Id
    @GeneratedValue
    private Long id;
    private String buildingCode;
    private String description;
    
    @Enumerated(EnumType.STRING)
    private CurrentStatus currentStatus;
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

   
}


