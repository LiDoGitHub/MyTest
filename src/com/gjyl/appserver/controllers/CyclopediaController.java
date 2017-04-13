package com.gjyl.appserver.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Cyclopedia;
import com.gjyl.appserver.service.CyclopediaService;

@Controller
@RequestMapping(value="/cyclopedia")
public class CyclopediaController {

	private static final String HOTID="66c1b532f82b4017b53f8ae2cf3c05a7";

	@Resource
	private CyclopediaService cyclopediaService;

	/**
	 * 随机获取三篇文章
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getTwoCycl")
	public void getTwoCyclopedia(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<Cyclopedia> list = cyclopediaService.getRandomArt();
		response.getWriter().write(JSON.toJSONString(list));
//		return (JSON) JSON.toJSON(list);
	}

	/**
	 * 分页获取文章
	 * @param pageNum:页号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCyclByPage",method=RequestMethod.GET)
	public void getCyclByPage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/json;charset=utf-8");
		Integer pageNum =Integer.valueOf(request.getParameter("pageNum"));
		List<Cyclopedia> list = cyclopediaService.getCyclByPage(pageNum);
		response.getWriter().write(JSON.toJSONString(list));
//		return (JSON) JSON.toJSON(list);
	}

	/**
	 * 获取文章详情
	 * @param cyclId:文章ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCyclInfo",method=RequestMethod.GET)
	public void getCyclInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String cyclId = request.getParameter("cyclId");
		Cyclopedia cyclInfo = cyclopediaService.getCyclInfo(cyclId);
		response.getWriter().write(JSON.toJSONString(cyclInfo));
//		return (JSON) JSON.toJSON(cyclInfo);
	}
	/**
	 * 获取所有文章,后台用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getAllCycl",method=RequestMethod.POST)
	public void getCyclopedia(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("application/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Method", "*");
		response.addHeader("Access-Control-Max-Age", "10000");
		response.setContentType("text/json;charset=utf-8");
		List<Cyclopedia> list = cyclopediaService.getAllCyclopedias();
		response.getWriter().write(JSON.toJSONString(list));
//		return (JSON) JSON.toJSON(list);
	}
	/**
	 * 删除文章
	 * @param cyclId:文章ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/delCyclopedia",method=RequestMethod.POST)
	public void delCyclopedia(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String cycId = request.getParameter("cyclId");
		Boolean result = cyclopediaService.delCyclopedia(cycId);
		response.getWriter().write(JSON.toJSONString(result));
//		return (JSON) JSON.toJSON(result);
	}


	/**
	 * 获取分类文章
	 * @param typeId:分类ID
	 * @param pageNum:页码
	 * @throws Exception
	 */
	@RequestMapping(value="/getCyclByType",method=RequestMethod.POST)
	public void getCyclByType(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String typeId = request.getParameter("typeId");
		String page = request.getParameter("pageNum");
		if (page==null||page=="") {
			page="0";
		}
		List<Cyclopedia> list=new ArrayList<Cyclopedia>();
		if (typeId.equals(HOTID)) {
			list= cyclopediaService.getHotCycl();
		}else {
			list =cyclopediaService.getCyclByType(typeId,page);
		}
		response.getWriter().write(JSON.toJSONString(list));
	}
}
