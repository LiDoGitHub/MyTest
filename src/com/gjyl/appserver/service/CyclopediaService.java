package com.gjyl.appserver.service;

import java.util.List;

import com.gjyl.appserver.pojo.Cyclopedia;

public interface CyclopediaService {

	List<Cyclopedia> getRandomArt();

	List<Cyclopedia> getCyclByPage(Integer pageNum);

	Cyclopedia getCyclInfo(String cyclId);

	List<Cyclopedia> getAllCyclopedias();

	Boolean addCycl(Cyclopedia cyclopedia);

	Boolean delCyclopedia(String cycId);

	List<Cyclopedia> getCyclByType(String typeId, String page);

	List<Cyclopedia> getHotCycl();

}
