package com.kgc.hx.pojo;

import lombok.Data;

@Data
public class ExportProduct {
	private String id;
	
	private String exportId;
	private String factoryId;
	
	private String factoryName;
	private String productNo;
	private Integer cnumber;
	private String packingUnit;
	private Double price;
	private Integer boxNum;
	
	private Double grossWeight;
	private Double netWeight;
	private Double sizeLength;
	private Double sizeWidth;
	private Double sizeHeight;
	private Double exPrice;
	private Double tax;
	
	private Integer orderNo;


}
