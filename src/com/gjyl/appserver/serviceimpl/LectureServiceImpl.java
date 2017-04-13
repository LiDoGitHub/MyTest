package com.gjyl.appserver.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.LectureMapper;
import com.gjyl.appserver.pojo.Lecture;
import com.gjyl.appserver.service.LectureService;

@Service("lectureService")
public class LectureServiceImpl implements LectureService {

	@Resource
	private LectureMapper dao;

	public List<Lecture> getAllLectures() {
		return dao.getAllLectures();
	}

	
}
