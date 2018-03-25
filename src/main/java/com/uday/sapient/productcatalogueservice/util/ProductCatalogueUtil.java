package com.uday.sapient.productcatalogueservice.util;

import com.uday.sapient.productcatalogueservice.exception.ProductCatalougeServiceException;
import com.uday.sapient.productcatalogueservice.model.ProductType;

public class ProductCatalogueUtil {
	
	public static ProductType getProductType(int productTypeCode) throws ProductCatalougeServiceException{
		switch(productTypeCode){
		case 0:
			return ProductType.SHOES;
		case 1:
			return ProductType.SUITS;
		case 2:
			return ProductType.FORMAL_DRESS;
		case 3:
			return ProductType.CASUAL_DRESS;
		default:
			throw new ProductCatalougeServiceException("Invalid ProductType code.");
		}
	}

}
