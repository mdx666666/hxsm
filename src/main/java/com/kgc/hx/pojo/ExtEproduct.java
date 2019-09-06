package com.kgc.hx.pojo;

import lombok.Data;

@Data
public class ExtEproduct {
	private String id;
	
	private String exportProductId;
	private String factoryId;
	
	private String factoryName;
	private String ctype;
	
	private String productNo;
	private String productImage;
	private String productDesc;
	private Integer cnumber;
	private String packingUnit;			//包装单位
	private Double price;
	private Double amount;
	private String productRequest;
	private Integer orderNo;

}
