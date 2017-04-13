package com.gjyl.appserver.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Collect;
import com.gjyl.appserver.service.CollectService;

@Controller
@RequestMapping("/collect")
public class CollectController {
	@Resource
	private CollectService collectService;

	/**
	 * 收藏文章
	 * @param request
	 * @return
	 * @throws Exception 
	 * @throws  
	 */
	@RequestMapping(value="/collectCycl")
	public void collectCycl(HttpServletRequest request,HttpServletResponse response) throws  Exception {
		response.setContentType("text/json;charset=utf-8");
		Collect collect = new Collect();
		DateConverter dc = new DateConverter("yyyy-MM-dd hh:mm:ss");
		ConvertUtils.register(dc, java.util.Date.class);
		BeanUtils.populate(collect, request.getParameterMap());
		Boolean result = collectService.collectCycl(collect);
//		return (JSON) JSON.toJSON(result);
		 response.getWriter().write(JSON.toJSONString(result));
	}
	
	/**
	 * 取消收藏
	 * @param userId:用户ID
	 * @param cyclId:文章ID
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/cancleCollect")
	public void cancleCollect(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String userId = request.getParameter("userId");
		String cyclId = request.getParameter("cyclId");
		Boolean result = collectService.cancleCollect(userId,cyclId);
		response.getWriter().write(JSON.toJSONString(result));
//		return (JSON) JSON.toJSON(result);
	}
	
	/**
	 * 是否收藏
	 * @param userId:用户ID
	 * @param cyclId:文章ID
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="isCollected")
	public void isCollected(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String userId = request.getParameter("userId");
		String cyclId = request.getParameter("cyclId");
		Boolean result = collectService.isCollected(userId,cyclId);
		response.getWriter().write(JSON.toJSONString(result));
//		return (JSON) JSON.toJSON(result);
	}
	
	/**
	 * 收藏列表
	 * @param userId:用户ID
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/getUserCollect")
	public void getUserCollect(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String userId = request.getParameter("userId");
		List<Collect> list = collectService.getCollectByUserId(userId);
		response.getWriter().write(JSON.toJSONString(list));
//		return (JSON) JSON.toJSON(list);
	}
}
