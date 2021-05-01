package com.smart.stock.models;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private  Integer id;
	
	//@CreatedDate
	@Column(name="creationDate")
	private Instant creationDate;
	
	
	//@LastModifiedDate
	@Column(name="lastUpdateDate")
	private Instant lastUpdateDate;
	
	@PrePersist
	void prePersist() {
		creationDate=Instant.now();
	}
	
	@PreUpdate
	void preUpdate() {
		lastUpdateDate=Instant.now();
	}
	

}
