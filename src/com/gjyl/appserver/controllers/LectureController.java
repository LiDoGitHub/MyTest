package com.gjyl.appserver.controllers;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Lecture;
import com.gjyl.appserver.service.LectureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/lecture")
public class LectureController {

	@Resource
	private LectureService lectureService;
	/**
	 * 获取所有视频列表
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getAllLectures")
	public void getAllLectures(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<Lecture> list= lectureService.getAllLectures();
//		return (JSON) JSON.toJSON(list);
		response.getWriter().write(JSON.toJSONString(list));
	}
}
