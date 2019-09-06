package com.kgc.hx.dao;

import com.kgc.hx.pojo.ExtCproduct;

import java.io.Serializable;


public interface ExtCproductDao extends BaseDao<ExtCproduct> {
	public void deleteByContractProductById(Serializable[] ids);
	public void deleteByContractId(Serializable[] contractIds);
}
