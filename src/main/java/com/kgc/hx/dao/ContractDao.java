package com.kgc.hx.dao;

import com.kgc.hx.pojo.Contract;
import com.kgc.hx.pojo.ContractVO;

import java.util.Map;


public interface ContractDao extends BaseDao<Contract> {
	public void updateState(Map map);			//修改状态
	public ContractVO view(String contractId);	//查询某个合同
}
