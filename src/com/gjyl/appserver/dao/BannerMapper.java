package com.gjyl.appserver.dao;

import java.util.List;

import com.gjyl.appserver.pojo.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
    
    List<Banner> getBannersByCate(Integer categoryCode);
}