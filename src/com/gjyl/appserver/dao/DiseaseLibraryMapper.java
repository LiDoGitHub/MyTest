package com.gjyl.appserver.dao;

import java.util.List;

import com.gjyl.appserver.pojo.DiseaseLibraryWithBLOBs;

public interface DiseaseLibraryMapper {
    int deleteByPrimaryKey(String disid);

    int insertSelective(DiseaseLibraryWithBLOBs record);

    DiseaseLibraryWithBLOBs selectByPrimaryKey(String disid);

    int updateDisease(DiseaseLibraryWithBLOBs record);

	List<DiseaseLibraryWithBLOBs> getDiseaseList(String sectionId);

	DiseaseLibraryWithBLOBs getDiseaseById(String disId);

	List<DiseaseLibraryWithBLOBs> getAllDiseases();

	List<DiseaseLibraryWithBLOBs> getCommonDis();

	//联想搜索
	List<String> getDisInfoByContent(String content);
	//搜索结果
	List<DiseaseLibraryWithBLOBs> getDisByContent(String content);
}