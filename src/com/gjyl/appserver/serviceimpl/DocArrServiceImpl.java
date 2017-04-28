package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.DocArrangementMapper;
import com.gjyl.appserver.dao.DoctorMapper;
import com.gjyl.appserver.pojo.DocArrangement;
import com.gjyl.appserver.pojo.Doctor;
import com.gjyl.appserver.service.DocArrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LiD on 2017/4/27.
 */
@Service("docArrService")
public class DocArrServiceImpl implements DocArrService {

    @Resource
    private DocArrangementMapper dao;
    @Resource
    protected DoctorMapper docDao;

    public DocArrangement getDocArrByDocId(String docid) {
        DocArrangement arrangement = dao.getArrangeByDocId(docid);
        Doctor doctor = docDao.getDrInfo(docid);
        arrangement.setDoctor(doctor);
        return arrangement;
    }

    public DocArrangement getArrById(String arrid) {
        return dao.selectByPrimaryKey(arrid);
    }
}
