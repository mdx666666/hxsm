package com.kgc.hx.service.impl;

import com.kgc.hx.dao.SysCodeDao;
import com.kgc.hx.pojo.SysCode;
import com.kgc.hx.service.SysCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



@Service
public class SysCodeServiceImpl implements SysCodeService {
	@Resource
	SysCodeDao sysCodeDao;

	public List<SysCode> find(Map paraMap) {
		return sysCodeDao.find(paraMap);
	}

}
