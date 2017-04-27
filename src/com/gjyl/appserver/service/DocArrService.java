package com.gjyl.appserver.service;

import com.gjyl.appserver.pojo.DocArrangement;

import java.util.List;

/**
 * Created by LiD on 2017/4/27.
 */
public interface DocArrService {

    Boolean addDocArrangement(DocArrangement arrangement);

    DocArrangement getArrangeById(String arrid);

    Boolean delDocArrangeById(String arrid);

    List<DocArrangement> getArrangeList();
}
