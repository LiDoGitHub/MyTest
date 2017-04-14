package com.gjyl.appserver.controllers;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Cyclopedia;
import com.gjyl.appserver.service.CyclopediaService;
import com.gjyl.appserver.utils.FileUploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
	@RequestMapping(value="/getCyclByPage")
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
	@RequestMapping(value="/getCyclInfo")
	public void getCyclInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Method", "*");
		response.addHeader("Access-Control-Max-Age", "10000");
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
	@RequestMapping(value="/getAllCycl")
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
	@RequestMapping(value="/delCyclopedia")
	public void delCyclopedia(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Method", "*");
		response.addHeader("Access-Control-Max-Age", "10000");
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
	@RequestMapping(value="/getCyclByType")
	public void getCyclByType(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String typeId = request.getParameter("typeId");
		String page = request.getParameter("pageNum");
		if (page==null||page.equals("")) {
			page="0";
		}
		List<Cyclopedia> list;
		if (typeId.equals(HOTID)) {
			list= cyclopediaService.getHotCycl();
		}else {
			list =cyclopediaService.getCyclByType(typeId,page);
		}
		response.getWriter().write(JSON.toJSONString(list));
	}

	/**
	 * 更新文章信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateCyclopedia")
	public void updateCyclopedia(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Method", "*");
		response.addHeader("Access-Control-Max-Age", "10000");
		String cyclId=request.getParameter("cyclId");
		Cyclopedia cyclopedia=cyclopediaService.getCyclInfo(cyclId);
		BeanUtils.populate(cyclopedia,request.getParameterMap());
		List<String> list = FileUploadUtils.uploadImage(request);
		if (list.size()==2) {
			cyclopedia.setIcon(list.get(0));
			cyclopedia.setCover(list.get(1));
		}
		if (cyclopedia.getIcon()!=null&&cyclopedia.getCover()!=null) {
			//图片已保存,才存储数据
			Boolean result = cyclopediaService.addCycl(cyclopedia);
			response.getWriter().write(JSON.toJSONString(result));
		}else {
			response.getWriter().write(JSON.toJSONString(Boolean.FALSE));
		}
	}
}
