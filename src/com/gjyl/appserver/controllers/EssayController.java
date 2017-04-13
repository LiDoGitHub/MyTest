package com.gjyl.appserver.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Essay;
import com.gjyl.appserver.service.EssayService;

@Controller
@RequestMapping(value="/essay")
public class EssayController {
	
	@Resource
	private EssayService essayService;
	
	/**
	 * 成长树文章列表
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getEssaies")
	public void getEssaies(HttpServletRequest request,HttpServletResponse response) {
		
	}
	
	/**
	 * 发布文章数
	 * @param request
	 * @param response
	 * @throws Exception  
	 */
	@RequestMapping(value="/publishEssay")
	public void publishEssay(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		Essay essay = new Essay();
		BeanUtils.populate(essay, request.getParameterMap());
		Boolean rst=essayService.publishEssay(essay);
		response.getWriter().write(JSON.toJSONString(rst));
	}
}
