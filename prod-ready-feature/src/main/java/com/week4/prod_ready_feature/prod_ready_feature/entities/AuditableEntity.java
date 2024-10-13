package com.week4.prod_ready_feature.prod_ready_feature.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Audited

public class AuditableEntity {

    @CreatedDate
    private String createdBate;

    @LastModifiedDate
    private String updatedDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatesBy;

}
