package com.gjyl.appserver.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.CalendarMapper;
import com.gjyl.appserver.pojo.Calendar;
import com.gjyl.appserver.service.CalendarCService;

@Service("calendarService")
public class CalendarCServiceImpl implements CalendarCService {
	@Resource
	private CalendarMapper dao;

	public List<Calendar> getCalendarList(String userid, String date) {
		Map<String, String>map=new HashMap<String, String>();
		map.put("userid", userid);
		map.put("cdate", date);
		return dao.getCalendarList(map);
	}

	public Calendar getCalenDarInfo(String userid, String date) {
		Map<String, String>map=new HashMap<String, String>();
		map.put("userid", userid);
		map.put("cdate", date);
		
		return dao.getCalendarInfo(userid,date);
	}
}
