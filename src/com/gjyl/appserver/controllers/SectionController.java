package com.gjyl.appserver.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Section;
import com.gjyl.appserver.service.SectionService;

@Controller
@RequestMapping("/section")
public class SectionController {

	@Resource
	private SectionService sectionService;
	
	@RequestMapping(value="/getSecList")
	public void getSecList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<Section> secList = sectionService.getSecList();
//		return (JSON) JSON.toJSON(secList);
		response.getWriter().write(JSON.toJSONString(secList));
	}
}
