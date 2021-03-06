package com.uday.sapient.productcatalogueservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uday.sapient.productcatalogueservice.exception.ProductCatalougeServiceException;
import com.uday.sapient.productcatalogueservice.model.Product;
import com.uday.sapient.productcatalogueservice.service.ProductCatalougeService;

@RestController
public class ProductCatalogueController {
	@Autowired
	private ProductCatalougeService productCatalougeService;	
	
	private Product product;
	private List<Product> productList;
	
	@RequestMapping(value="/products/product/{productCode}", method= RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable("productCode") String productCode) throws ProductCatalougeServiceException{
		product = productCatalougeService.getProductByCode(productCode);
		
		return (product == null ? new ResponseEntity<Product>(HttpStatus.NOT_FOUND):
				new ResponseEntity<Product>(product, HttpStatus.OK));
	}
	
	@RequestMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductCatalougeServiceException{
		return new ResponseEntity<List<Product>>(productCatalougeService.getAllProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/products/producttype/{productTypeCode}", method= RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProductsByType(@PathVariable("productTypeCode") int productTypeCode) throws ProductCatalougeServiceException{
		productList = productCatalougeService.getAllProductByType(productTypeCode);
		
		return ((productList == null || productList.size() < 1 )
				? new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<List<Product>>(productList, HttpStatus.OK));
	}
	
	@RequestMapping(value="/products/product", method= RequestMethod.POST)
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) throws ProductCatalougeServiceException{
		return new ResponseEntity<Product>(productCatalougeService.addNewProduct(product), HttpStatus.OK);
	}	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/products/product/{productCode}", method= RequestMethod.DELETE)
	public ResponseEntity deleteProduct(@PathVariable("productCode") String productCode) throws ProductCatalougeServiceException{
		productCatalougeService.deleteProduct(productCode);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/products/product", method= RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ProductCatalougeServiceException{
		return new ResponseEntity<Product>(productCatalougeService.updatedProduct(product), HttpStatus.OK);
	}	
	
}
