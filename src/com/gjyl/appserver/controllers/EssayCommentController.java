package com.gjyl.appserver.controllers;

import com.gjyl.appserver.service.MyFocusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/ecomment")
public class EssayCommentController {

	@Resource
	private MyFocusService myFocusService;

	/**
	 * 评论列表
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getEComments")
	public void getEComments(HttpServletRequest request,HttpServletResponse response) {

	}
}
