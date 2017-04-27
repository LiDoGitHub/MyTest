package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.DocArrangementMapper;
import com.gjyl.appserver.dao.DoctorMapper;
import com.gjyl.appserver.pojo.DocArrangement;
import com.gjyl.appserver.pojo.Doctor;
import com.gjyl.appserver.service.DocArrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiD on 2017/4/27.
 */
@Service("docArrService")
public class DocArrServiceImpl implements DocArrService {

    @Resource
    private DocArrangementMapper dao;
    protected DoctorMapper docDao;

    public Boolean addDocArrangement(DocArrangement arrangement) {

        int rst = dao.insertSelective(arrangement);
        if (rst>0)
            return true;
        return false;
    }

    public DocArrangement getArrangeById(String arrid) {

        return dao.selectByPrimaryKey(arrid);
    }

    public Boolean delDocArrangeById(String arrid) {
        int rst = dao.deleteByPrimaryKey(arrid);
        if (rst > 0)
            return true;
        return false;
    }

    public List<DocArrangement> getArrangeList() {
        List<DocArrangement> list= dao.getArrangeList();
        for (DocArrangement arr : list) {
            Doctor doctor = docDao.getDrInfo(arr.getDocid());
            arr.setDoctor(doctor);
        }
        return list;
    }
}
