package com.tcs.shopping.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
	
	@Column(name = "is_active")
	private int isActive=1;
	
	@Column(name = "created_on")
	@Temporal(TemporalType.TIMESTAMP)
    private Date  createdOn;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "updated_on")
	@Temporal(TemporalType.TIMESTAMP)
    private Date  updatedOn;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	
}
