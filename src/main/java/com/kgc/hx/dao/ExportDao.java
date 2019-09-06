package com.kgc.hx.dao;

import com.kgc.hx.pojo.Export;

import java.util.Map;


public interface ExportDao extends BaseDao<Export> {
	public void updateState(Map map);			//修改状态
}
