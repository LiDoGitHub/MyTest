package com.gjyl.appserver.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.MyDoctor;
import com.gjyl.appserver.service.MyDoctorService;

/**
 * 我的医生
 * @author LiD
 *
 */
@Controller
@RequestMapping("/myDoctor")
public class MyDoctorController {

	@Resource
	private MyDoctorService myDrService;

	/**
	 * 我的医生
	 * @param userId:用户ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getMyDoctor")
	public void getMyDoctor(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String userId = request.getParameter("userId");
		List<MyDoctor> list = myDrService.getMyDoctor(userId);
		response.getWriter().write(JSON.toJSONString(list));
//		return (JSON) JSON.toJSON(list);
	}
	/**
	 * 添加我的医生
	 * @param userid:用户ID
	 * @param doctorid:医生ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addMyDoctor")
	public void addMyDoctor(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		MyDoctor myDoctor = new MyDoctor();
		Boolean result = myDrService.addMyDoctor(myDoctor);
		response.getWriter().write(JSON.toJSONString(result));
//		return (JSON) JSON.toJSON(result);
	}
}
