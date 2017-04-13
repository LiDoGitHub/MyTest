package com.gjyl.appserver.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gjyl.appserver.dao.BannerMapper;
import com.gjyl.appserver.pojo.Banner;
import com.gjyl.appserver.service.BannerService;

@Service("bannerService")
public class BannerServiceImpl implements BannerService {

	@Resource
	private BannerMapper mapper;
	
	public List<Banner> getHomeBanners() {
		return mapper.getBannersByCate(1);
	}

	public List<Banner> getDisBanners() {
		return mapper.getBannersByCate(2);
	}

}
