package com.gjyl.appserver.controllers;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Doctor;
import com.gjyl.appserver.service.DoctorService;
import com.gjyl.appserver.utils.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		List<Doctor> list = doctorService.getRandomDr();
		response.getWriter().write(JSON.toJSONString(list));
//		return (JSON) JSON.toJSON(list);
	}

	/**
	 * 获取医生列表,后台共用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getDrList")
	public void getDrList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Method", "*");
		response.addHeader("Access-Control-Max-Age", "10000");
		List<Doctor> list = doctorService.getDrList();
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
	}

	/**
	 * 导入Excel表格
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataFromExcel",method = RequestMethod.POST)
	public void getDataFromExcel(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/json;charset=utf-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Method", "*");
		response.addHeader("Access-Control-Max-Age", "10000");
		List<Object> list = ExcelUtil.getDataFromExcel(request, Doctor.class);
		if (list!=null&&list.size()>0){
			Boolean rst = doctorService.executeBatch(list);
			response.getWriter().write(JSON.toJSONString(Boolean.TRUE));
		}else {
			response.getWriter().write(JSON.toJSONString(Boolean.FALSE));
		}
	}

}
