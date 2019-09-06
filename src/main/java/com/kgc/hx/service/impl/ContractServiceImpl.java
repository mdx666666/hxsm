package com.kgc.hx.service.impl;

import com.kgc.hx.dao.ContractDao;
import com.kgc.hx.dao.ContractProductDao;
import com.kgc.hx.dao.ExtCproductDao;
import com.kgc.hx.pagination.Page;
import com.kgc.hx.pojo.Contract;
import com.kgc.hx.service.ContractService;
import com.kgc.hx.pojo.ContractVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class ContractServiceImpl implements ContractService {
	@Resource
	ContractDao contractDao;
	@Resource
	ContractProductDao contractProductDao;
	@Resource
	ExtCproductDao extCproductDao;

	public List<Contract> findPage(Page page) {
		return contractDao.findPage(page);
	}

	public List<Contract> find(Map paraMap) {
		return contractDao.find(paraMap);
	}

	public Contract get(Serializable id) {
		return contractDao.get(id);
	}

	public void insert(Contract contract) {
		contract.setId(UUID.randomUUID().toString());
		contract.setState(0);					//0草稿1已上报
		contractDao.insert(contract);
	}

	public void update(Contract contract) {
		contractDao.update(contract);
	}

	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCproductDao.deleteByContractId(ids);			//删除当前这些合同下的附件信息
		contractProductDao.deleteByContractId(ids);		//删除当前这些合同下的货物信息
		contractDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractId(ids);			//删除当前这些合同下的附件信息
		contractProductDao.deleteByContractId(ids);		//删除当前这些合同下的货物信息
		contractDao.delete(ids);
	}

	public void submit(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 1);				//1已上报
		map.put("ids", ids);
		
		contractDao.updateState(map);
	}

	public void cancel(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", 0);				//0草稿
		map.put("ids", ids);
		
		contractDao.updateState(map);
	}

	public ContractVO view(String contractId) {
		return contractDao.view(contractId);
	}

}
