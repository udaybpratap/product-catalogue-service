package com.uday.sapient.productcatalougeservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.uday.sapient.productcatalogueservice.ProductCatalogueServiceApplication;
import com.uday.sapient.productcatalogueservice.exception.ProductCatalougeServiceException;
import com.uday.sapient.productcatalogueservice.model.Product;
import com.uday.sapient.productcatalogueservice.model.ProductType;
import com.uday.sapient.productcatalogueservice.repository.ProductCatalougeRepository;
import com.uday.sapient.productcatalogueservice.service.ProductCatalougeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductCatalogueServiceApplication.class)
@ActiveProfiles("test")
public class ProductCatalougeServiceTests {

	@Mock
	ProductCatalougeRepository productCatalougeRepository;
	
	@InjectMocks
	ProductCatalougeServiceImpl productCatalougeService;
	
	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetProductByCode() throws ProductCatalougeServiceException {
		Product product = new Product(1l, "C1001", "Casual", "Casual dress", ProductType.CASUAL_DRESS);
		when(productCatalougeService.getProductByCode("C1001")).thenReturn(product);

		Product returned = productCatalougeService.getProductByCode("C1001");

		assertNotNull(returned);
		assertEquals(returned, product);
	}

	@Test
	public void testGetAllProducts() throws ProductCatalougeServiceException {
		List<Product> productList = new ArrayList<>();
		Product product1 = new Product(10l, "C10010", "T-Shirt", "Casual deress", ProductType.CASUAL_DRESS);
		Product product2 = new Product(11l, "C10011", "T-Shirt", "Casual deress", ProductType.CASUAL_DRESS);
		Product product3 = new Product(12l, "C10012", "T-Shirt", "Casual deress", ProductType.CASUAL_DRESS);

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		when(productCatalougeService.getAllProducts()).thenReturn(productList);
		
		List<Product> resultProductList = productCatalougeService.getAllProducts();
		
		assertNotNull(resultProductList);
		assertTrue(resultProductList.size() > 0);
		assertTrue(resultProductList.containsAll(productList));
	}

	@Test
	public void testAddNewProduct() throws ProductCatalougeServiceException {
		Product product = new Product(10l, "C10010", "T-Shirt", "Casual deress", ProductType.CASUAL_DRESS);
		when(productCatalougeService.addNewProduct(product)).thenReturn(product);

		Product result = productCatalougeService.addNewProduct(product);

		assertNotNull(result);
		assertEquals(result, product);
	}

	@Test
	public void testUpdatedProduct() throws ProductCatalougeServiceException {
		Product product = new Product(10l, "C10010", "T-Shirt", "Casual deress", ProductType.CASUAL_DRESS);
		
		when(productCatalougeService.updatedProduct(product)).thenReturn(product);
		
		Product result = productCatalougeService.updatedProduct(product);
		
		assertEquals(result, product);

	}

	@Test
	public void deleteProduct() throws ProductCatalougeServiceException {
		when(productCatalougeService.deleteProduct("C10010")).thenReturn(true);
		

	}

	@Test
	public void testGetAllProductByType() throws ProductCatalougeServiceException {
		List<Product> productList = new ArrayList<>();
		Product product1 = new Product(10l, "C10010", "T-Shirt", "Casual deress", ProductType.CASUAL_DRESS);
		Product product2 = new Product(11l, "C10011", "T-Shirt", "Casual deress", ProductType.CASUAL_DRESS);
		Product product3 = new Product(12l, "C10012", "T-Shirt", "Casual deress", ProductType.CASUAL_DRESS);

		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		when(productCatalougeService.getAllProductByType(ProductType.CASUAL_DRESS.getType())).thenReturn(productList);

		List<Product> resultProductList = productCatalougeService.getAllProductByType(ProductType.CASUAL_DRESS.getType());
		assertNotNull(resultProductList);
		assertTrue(resultProductList.size() > 0);

		assertTrue(resultProductList.containsAll(productList));
	}

	@Test(expected = ProductCatalougeServiceException.class)
	public void testGetAllProductByTypeException() throws ProductCatalougeServiceException {
		when(productCatalougeService.getAllProductByType(5)).thenThrow(new ProductCatalougeServiceException("Invalid ProductType code"));

		assertEquals(productCatalougeService.getAllProductByType(5),
				new ProductCatalougeServiceException("Invalid ProductType code"));

	}

}
