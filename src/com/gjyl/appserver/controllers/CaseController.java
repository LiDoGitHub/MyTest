package com.gjyl.appserver.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Cases;
import com.gjyl.appserver.service.CaseService;

/**
 * 病例信息
 * @author LiD
 *
 */
@Controller
@RequestMapping("/case")
public class CaseController {
	
	@Resource
	private CaseService caseService;

	/**
	 * 我的病例
	 * @param userid:用户ID
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/getMyCases",method=RequestMethod.POST)
	public void getMyCases(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String userid = request.getParameter("userid");
		List<Cases> list= caseService.getMyCases(userid);
		response.getWriter().write(JSON.toJSONString(list));
	}
	
	/**
	 * 添加病例
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/addCases",method=RequestMethod.POST)
	public void addCases(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		Cases cases = new Cases();
		BeanUtils.populate(cases, request.getParameterMap());
		if (cases.getCasename()!=null) {
			Boolean rst= caseService.addCases(cases);
			response.getWriter().write(JSON.toJSONString(rst));
		}else {
			response.getWriter().write(JSON.toJSONString("Error"));
		}
	}
	
	/**
	 * 病例详情
	 * @param caseid:病例ID
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/getCaseInfo",method=RequestMethod.POST)
	public void getCaseInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String id = request.getParameter("caseid");
		Cases mycase = caseService.getCaseInfo(id);
		response.getWriter().write(JSON.toJSONString(mycase));
	}
	
	/**
	 * 删除病例
	 * @param caseid:病例ID
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteCase",method=RequestMethod.POST)
	public void deleteCase(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String id = request.getParameter("caseid");
		Boolean rst=caseService.deleteCase(id);
		response.getWriter().write(JSON.toJSONString(rst));
	}
	
}
