package com.kgc.hx.pojo;

import lombok.Data;

@Data
public class ContractProduct {
	private String id;
	
	//private Contract contract;		//将复杂的关联关系变成单表操作
	private String contractId;			//关联关系的表（外键），都成为普通字段
	private String factoryId;
	
	private String factoryName;
	private String productNo;
	private String productImage;
	private String productDesc;
	private Integer cnumber;
	private Integer outNumber;
	private String loadingRate;			//装率
	private Integer boxNum;				//箱数
	private String packingUnit;			//包装单位
	private Double price;
	private Double amount;
	private Integer finished;
	private String exts;
	private Integer orderNo;

}
