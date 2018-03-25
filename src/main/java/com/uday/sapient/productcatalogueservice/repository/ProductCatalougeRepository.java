package com.uday.sapient.productcatalogueservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uday.sapient.productcatalogueservice.exception.ProductCatalougeServiceException;
import com.uday.sapient.productcatalogueservice.model.Product;
import com.uday.sapient.productcatalogueservice.model.ProductType;

@Repository
public interface ProductCatalougeRepository extends JpaRepository<Product, Long>{
	public Product findByProductCode(String productCode) throws ProductCatalougeServiceException;
	public List<Product> findByProductType(ProductType productType) throws ProductCatalougeServiceException;
	public Product deleteByProductCode(String productCode) throws ProductCatalougeServiceException;
}
