package com.kgc.hx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kgc.hx.dao.OutProductDao;
import com.kgc.hx.service.OutProductService;
import com.kgc.hx.pojo.OutProductVO;


@Service
public class OutProductServiceImpl implements OutProductService {
	@Resource
	OutProductDao outProductDao;

	public List<OutProductVO> find(String inputDate) {
		Map paraMap = new HashMap();
		paraMap.put("inputDate", inputDate);		//按条件查询，船期
		
		return outProductDao.find(paraMap);
	}
	
}
