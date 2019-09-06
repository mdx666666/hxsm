package com.kgc.hx.dao;

import com.kgc.hx.pojo.Factory;

import java.util.Map;

public interface FactoryDao extends BaseDao<Factory> {
	public void updateState(Map map);			//修改状态
}
