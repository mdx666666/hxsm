package com.kgc.hx.pojo;

import lombok.Data;

@Data
public class ExtCproduct {
	private String id;
	
	private String contractProductId;			//关联关系的表（外键），都成为普通字段
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
