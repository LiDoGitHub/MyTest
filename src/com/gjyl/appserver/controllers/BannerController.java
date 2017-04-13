package com.gjyl.appserver.controllers;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.Banner;
import com.gjyl.appserver.pojo.Hot;
import com.gjyl.appserver.service.BannerService;
import com.gjyl.appserver.service.HotService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {

	@Resource
	private BannerService bannerService;
	@Resource
	private HotService hotService;

	/**
	 * 获取主页的轮播图
	 * @throws Exception
	 */
	@RequestMapping(value="/getHomeBanners")
	public void getHomeBanners(HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<Banner> list = bannerService.getHomeBanners();
//		return (JSON) JSON.toJSON(banners);
		response.getWriter().write(JSON.toJSONString(list));
//		return banners;
	}

	/**
	 * 疾病库轮播图
	 * @throws Exception
	 */
	@RequestMapping(value="/getDisBanners")
	public void getDisBanners(HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<Banner> banners = bannerService.getDisBanners();
		response.getWriter().write(JSON.toJSONString(banners));
//		return (JSON) JSON.toJSON(banners);
	}

	/**
	 * 获取所有热点文章
	 * @throws Exception
	 */
	@RequestMapping(value="/getAllHots",method=RequestMethod.GET)
	public void getHotArticles(HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		List<Hot> articles = hotService.getHotArticles();
		response.getWriter().write(JSON.toJSONString(articles));
//		return (JSON) JSON.toJSON(articles);

	}
}
