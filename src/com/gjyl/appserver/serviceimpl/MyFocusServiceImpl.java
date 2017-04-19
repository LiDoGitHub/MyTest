package com.gjyl.appserver.serviceimpl;

import com.gjyl.appserver.dao.MyFocusesMapper;
import com.gjyl.appserver.service.MyFocusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LiD on 2017/4/18.
 */

@Service("myfocueService")
public class MyFocusServiceImpl implements MyFocusService {

    @Resource
    private MyFocusesMapper dao;
}
