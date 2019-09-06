package com.kgc.hx.service;

import com.kgc.hx.pojo.OutProductVO;

import java.util.List;




public interface OutProductService {
	public List<OutProductVO> find(String inputDate);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
}
