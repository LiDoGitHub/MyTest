package com.gjyl.appserver.controllers;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Doctor;
import com.gjyl.appserver.pojo.DoctorWithBLOBs;
import com.gjyl.appserver.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Resource
	private DoctorService doctorService;

	/**
	 * 主页随机获取三名医生
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getRanDomDr")
	public void getRandomDr(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<DoctorWithBLOBs> list = doctorService.getRandomDr();
		response.getWriter().write(JSON.toJSONString(list));
//		return (JSON) JSON.toJSON(list);
	}

	/**
	 * 获取医生列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getDrList")
	public void getDrList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<DoctorWithBLOBs> list = doctorService.getDrList();
//		return (JSON) JSON.toJSON(list);
		response.getWriter().write(JSON.toJSONString(list));
	}

	/**
	 * 医生详情
	 * @throws Exception
	 */
	@RequestMapping(value="/getDrInfo")
	public void getDrInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String docId = request.getParameter("docId");
		Doctor doctor = doctorService.getDrInfo(docId);
		response.getWriter().write(JSON.toJSONString(doctor));
//		return (JSON) JSON.toJSON(doctor);
	}
}
