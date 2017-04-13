package com.gjyl.appserver.dao;

import java.util.List;

import com.gjyl.appserver.pojo.Section;

public interface SectionMapper {
    int deleteByPrimaryKey(String sectionid);

    int insert(Section record);

    int insertSelective(Section record);

    Section selectByPrimaryKey(String sectionid);

    int updateByPrimaryKeySelective(Section record);

    int updateByPrimaryKey(Section record);

	List<Section> getSecList();

	//联想搜索
	List<String> getSectionByContent(String content);
	//搜索结果相关
	List<Section> getSecByContent(String content);
}