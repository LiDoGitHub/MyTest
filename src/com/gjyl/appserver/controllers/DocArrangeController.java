package com.gjyl.appserver.controllers;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.DocArrangement;
import com.gjyl.appserver.service.DocArrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LiD on 2017/4/17.
 */
@Controller
@RequestMapping("/docArrangement")
public class DocArrangeController {

    @Resource
    private DocArrService docArrService;

    /**
     * 新增医生排班
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/addDocArrange")
    public void addDocArrange(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Method", "*");
        response.addHeader("Access-Control-Max-Age", "10000");
        DocArrangement arrangement = new DocArrangement();
        if (arrangement.getDocid()!=null&&!arrangement.getDocid().equals("")){
            Boolean rst= docArrService.addDocArrangement(arrangement);
            response.getWriter().write(JSON.toJSONString(rst));
        }else {
            response.getWriter().write(JSON.toJSONString("error"));
        }
    }

    /**
     * 编辑医生排班
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/editDocArrange")
    public void editDocArrange(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Method", "*");
        response.addHeader("Access-Control-Max-Age", "10000");
        String arrid = request.getParameter("arrid");
        DocArrangement arrangement = docArrService.getArrangeById(arrid);
        response.getWriter().write(JSON.toJSONString(arrangement));
    }

    /**
     * 删除排班信息
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/delDocArrange")
    public void delDocArrange(HttpServletRequest request,HttpServletResponse response) throws  Exception{
        response.setContentType("text/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Method", "*");
        response.addHeader("Access-Control-Max-Age", "10000");
        String arrid = request.getParameter("arrid");
        Boolean rst= docArrService.delDocArrangeById(arrid);
        response.getWriter().write(JSON.toJSONString(rst));
    }

    /**
     * 排班列表
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/getArrangeList")
    public void getArrangeList(HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Method", "*");
        response.addHeader("Access-Control-Max-Age", "10000");
        List<DocArrangement> list = docArrService.getArrangeList();
    }
}
