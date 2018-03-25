package com.uday.sapient.productcatalogueservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="PRODUCT")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="PRODUCT_CODE")
	private String productCode;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_DESC")
	private String desc;
	
	@Column(name="PRODUCT_TYPE")
	private ProductType productType;
}
