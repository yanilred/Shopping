package com.tcs.shopping.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
	@JsonIgnore
	@Column(name = "is_active")
	private int isActive=1;
	@JsonIgnore
	@Column(name = "created_on")
	@Temporal(TemporalType.TIMESTAMP)
    private Date  createdOn;
	@JsonIgnore
	@Null
	@Column(name = "created_by")
	private String createdBy;
	@Null
	@JsonIgnore
	@Column(name = "updated_on")
	@Temporal(TemporalType.TIMESTAMP)
    private Date  updatedOn;
	@Null
	@JsonIgnore
	@Column(name = "updated_by")
	private String updatedBy;
	
	
}
