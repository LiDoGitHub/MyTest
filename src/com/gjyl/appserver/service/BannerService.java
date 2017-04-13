package com.gjyl.appserver.service;

import java.util.List;

import com.gjyl.appserver.pojo.Banner;

public interface BannerService {

	public List<Banner> getHomeBanners();

	public List<Banner> getDisBanners();
}
