package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.EssayCommentMapper;
import com.gjyl.appserver.pojo.EssayComment;
import com.gjyl.appserver.service.ECommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ecommentService")
public class ECommentServiceImpl implements ECommentService {

    @Resource
    private EssayCommentMapper dao;

    @Override
    public List<EssayComment> getCommentByEid(String eid) {

         return dao.getCommentByEid(eid);
    }

    @Override
    public Boolean addEComment(EssayComment comment) {
        int rst=dao.insertSelective(comment);
        if (rst>0){
            return true;
        }
        return false;
    }
}
