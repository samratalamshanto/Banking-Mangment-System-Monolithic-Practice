package com.application.banking_system_monolithic.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class CommonAttributes {
    @CreationTimestamp
    private LocalDateTime createdDT;
    private LocalDateTime updatedDT;
    private LocalDateTime deletedDT;
}
