package com.gjyl.appserver.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.CyclType;
import com.gjyl.appserver.service.CyclTypeService;

@Controller
@RequestMapping("/cyclType")
public class CyclTypeController {

	@Resource
	private CyclTypeService cyclTypeService;
	
	/**
	 * 获取分类
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping(value="/getAllTypes",method=RequestMethod.GET)
	public void getTypes(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<CyclType> types = cyclTypeService.getAllTypes();
		response.getWriter().write(JSON.toJSONString(types));
	}
}
