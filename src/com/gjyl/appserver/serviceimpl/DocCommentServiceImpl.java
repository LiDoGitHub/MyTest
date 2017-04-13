package com.gjyl.appserver.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.DocCommentMapper;
import com.gjyl.appserver.dao.DoctorMapper;
import com.gjyl.appserver.pojo.DocComment;
import com.gjyl.appserver.pojo.DoctorWithBLOBs;
import com.gjyl.appserver.service.DocCommentService;

@Service("docComService")
public class DocCommentServiceImpl implements DocCommentService {

	@Resource
	private DocCommentMapper dao;
	@Resource
	private DoctorMapper docDao;

	@Override
	public List<DocComment> getHealthComment(String healthId) {
		List<DocComment> list = dao.getHealthComment(healthId);
		for (DocComment docComment : list) {
			DoctorWithBLOBs drInfo = docDao.getDrInfo(docComment.getDoctorid());
			docComment.setDoctor(drInfo);
		}
		return list;
	}

	public Boolean addDocComment(DocComment docComment) {

		int result=dao.addDocComment(docComment);
		if (result>0) {
			return true;
		}
		return false;
	}
	
}
