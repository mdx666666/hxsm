package com.kgc.hx.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class Factory {
	
	private String id; // 将主键都映射成id
	private String fullName; // 全称
	private String factoryName; // 简称
	private String contacts; // 联系人
	private String phone; // 电话
	private String mobile; // 手机
	private String fax; // 传真
	private String cnote; // 备注
	private String inspector; // 验货员
	private Integer orderNo; // 排序号
	private String state; // 状态
	private String createBy; // 创建人
	private String createDept; // 创建部门
	private Date createTime; // 排序号
	private String contractor;

	public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }
}
