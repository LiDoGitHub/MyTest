package com.gjyl.appserver.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ecomment")
public class EssayCommentController {

	/**
	 * 评论列表
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getEComments")
	public void getEComments(HttpServletRequest request,HttpServletResponse response) {
		
	}
}