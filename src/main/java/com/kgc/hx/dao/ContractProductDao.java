package com.kgc.hx.dao;

import com.kgc.hx.pojo.ContractProduct;

import java.io.Serializable;

public interface ContractProductDao extends BaseDao<ContractProduct> {
	public void deleteByContractProductById(Serializable[] ids);
	public void deleteByContractId(Serializable[] ids);
}
