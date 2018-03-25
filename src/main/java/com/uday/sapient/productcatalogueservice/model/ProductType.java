package com.uday.sapient.productcatalogueservice.model;

public enum ProductType {
	
	SHOES(0),
	SUITS(1),
	FORMAL_DRESS(2),
	CASUAL_DRESS(3);
	
	
	//private String value;
	private int type;
	
	ProductType(int type){
		this.type = type;
		//this.value = value;
	}
	
	public int getType(){
		return this.type;
	}
	
	/*public String getValue(){
		return this.value;
	}*/

}
