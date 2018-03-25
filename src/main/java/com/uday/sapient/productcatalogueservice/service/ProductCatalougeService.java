package com.uday.sapient.productcatalogueservice.service;

import java.util.List;

import com.uday.sapient.productcatalogueservice.exception.ProductCatalougeServiceException;
import com.uday.sapient.productcatalogueservice.model.Product;
import com.uday.sapient.productcatalogueservice.model.ProductType;

public interface ProductCatalougeService {	
	public Product getProductByCode(String productCode) throws ProductCatalougeServiceException;
	public List<Product> getAllProducts() throws ProductCatalougeServiceException;
	public Product addNewProduct(Product product) throws ProductCatalougeServiceException;
	public Product updatedProduct(Product product) throws ProductCatalougeServiceException;
	public void deleteProduct(String productCode) throws ProductCatalougeServiceException;
	public List<Product> getAllProductByType(int productTypeCode) throws ProductCatalougeServiceException;
}
