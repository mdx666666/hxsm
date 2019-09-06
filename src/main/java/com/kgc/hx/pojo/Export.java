package com.kgc.hx.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Export {
	private String id;
	private Date inputDate;
	
	private String epnum;
	private String extnum;
	
	private String contractIds;			//打断设计，合同的ID集合
	private String customerContract;	//合同或确认书号
	private String lcno;				//信用证号
	private String consignee;			//收货人及地址
	private String marks;				//唛头
	private String remark;
	private String shipmentPort;		//装运港
	private String destinationPort;		//目的港
	private String transportMode;		//运输方式
	private String priceCondition;		//价格条件
	private Integer state;				//0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务
	private Double grossWeight;			//毛重	
	private Double netWeight;			//净重
	private Double measurement;			//体积
	
	private String createBy;
	private String createDept;
	private Date createTime;
}
