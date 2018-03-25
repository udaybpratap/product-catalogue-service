package com.uday.sapient.productcatalogueservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uday.sapient.productcatalogueservice.exception.ProductCatalougeServiceException;
import com.uday.sapient.productcatalogueservice.model.Product;
import com.uday.sapient.productcatalogueservice.repository.ProductCatalougeRepository;
import com.uday.sapient.productcatalogueservice.util.ProductCatalogueUtil;

@Service
@Transactional
public class ProductCatalougeServiceImpl implements ProductCatalougeService{

	@Autowired
	private ProductCatalougeRepository productCatalougeRepository;
	
	@Override
	public Product getProductByCode(String productCode) throws ProductCatalougeServiceException {
		return productCatalougeRepository.findByProductCode(productCode);
	}

	@Override
	public List<Product> getAllProducts() throws ProductCatalougeServiceException {
		return productCatalougeRepository.findAll();
	}

	@Override
	public Product addNewProduct(Product product) throws ProductCatalougeServiceException {
		return productCatalougeRepository.save(product);		
	}

	@Override
	public Product updatedProduct(Product product) throws ProductCatalougeServiceException {
		return productCatalougeRepository.saveAndFlush(product);
	}

	@Override
	public Product deleteProduct(String productCode) throws ProductCatalougeServiceException {
		return productCatalougeRepository.deleteByProductCode(productCode);
	}

	@Override
	public List<Product> getAllProductByType(int productTypeCode) throws ProductCatalougeServiceException {		
		return productCatalougeRepository.findByProductType(ProductCatalogueUtil.getProductType(productTypeCode));
	}

}
