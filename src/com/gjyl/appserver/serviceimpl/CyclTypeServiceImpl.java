package com.gjyl.appserver.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.CyclTypeMapper;
import com.gjyl.appserver.pojo.CyclType;
import com.gjyl.appserver.service.CyclTypeService;

@Service("/cyclTypeService")
public class CyclTypeServiceImpl implements CyclTypeService {
	
	@Resource
	private CyclTypeMapper dao;

	public List<CyclType> getAllTypes() {
		
		return dao.getAllTypes();
	}
	
}
