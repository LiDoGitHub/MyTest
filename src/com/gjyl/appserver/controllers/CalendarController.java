package com.gjyl.appserver.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Calendar;
import com.gjyl.appserver.service.CalendarCService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

	@Resource
	private CalendarCService calendarService;

	/**
	 * 获取当月日历事件
	 * @param userid:用户id
	 * @param date:要获取的日期,精确到月
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getCalendarList")
	public void getCalendarList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String userid = request.getParameter("userid");
		String date = request.getParameter("date");
		List<Calendar> list = calendarService.getCalendarList(userid,date);
//		return (JSON) JSON.toJSON(list);
		response.getWriter().write(JSON.toJSONString(list));
	}

	public void getCalendarInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String userid = request.getParameter("userid");
		String date = request.getParameter("date");
		calendarService.getCalenDarInfo(userid,date);
		response.getWriter().write(JSON.toJSONString(""));
//		return (JSON) JSON.toJSON("");
	}
}
