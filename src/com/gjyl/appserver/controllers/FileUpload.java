package com.gjyl.appserver.controllers;

import com.alibaba.fastjson.JSON;
import com.gjyl.appserver.pojo.AppUser;
import com.gjyl.appserver.pojo.Cyclopedia;
import com.gjyl.appserver.service.CyclopediaService;
import com.gjyl.appserver.service.UserService;
import com.gjyl.appserver.utils.DateUtils;
import com.gjyl.appserver.utils.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 图片上传
 * @author LiD
 *
 */
@Controller
@RequestMapping("/upload")
public class FileUpload {

	@Resource
	private CyclopediaService cyclopediaService;
	@Resource
	private UserService userService;

	/**
	 * 图片上传
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/ImgUpload",method=RequestMethod.POST)
	public void imgUpload(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		String prePath = getPrePath(request);
		//封装数据
		Cyclopedia cyclopedia = new Cyclopedia();
		cyclopedia.setContent(request.getParameter("content"));
		cyclopedia.setTitle(request.getParameter("title"));
		List<String> list = uploadImage(request,prePath);
		if (list.size()==2) {
			cyclopedia.setIcon(list.get(0));
			cyclopedia.setCover(list.get(1));
		}
		cyclopedia.setCtime(DateUtils.getNowDateStr());

		if (cyclopedia.getIcon()!=null&&cyclopedia.getCover()!=null) {
			//图片已保存,才存储数据
			Boolean result = cyclopediaService.addCycl(cyclopedia);
//			return (JSON) JSON.toJSON(result);
			response.getWriter().write(JSON.toJSONString(result));
		}else {
//			return (JSON) JSON.toJSON(Boolean.FALSE);
			response.getWriter().write(JSON.toJSONString(Boolean.FALSE));
		}


	}

	/**
	 * 上传头像
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadIcon")
	public void uploadIcon(HttpServletRequest request,HttpServletResponse response) throws Exception {

		String userid = request.getParameter("userid");
		AppUser user = userService.GetUserById(userid);

		String prePath = getPrePath(request);
		List<String> list = uploadImage(request, prePath);
		if (list.size()==1) {
			user.setIcon(list.get(0));
		}
		System.out.println(user.toString());
		Boolean result = userService.updateUser(user);
		if (result) {//成功,返回新的用户信息
			response.getWriter().write(JSON.toJSONString(user));
		}else {
			response.getWriter().write(JSON.toJSONString(result));
		}
	}

	/**
	 * 图片路径前缀
	 * @param request
	 * @return
	 */
	private String getPrePath(HttpServletRequest request) {
		// 拼接可供网络访问的图片地址
		String preName = request.getContextPath();
		StringBuffer sb = new StringBuffer();
		sb.append(request.getScheme() + "://");
		sb.append(request.getServerName() + ":");
		sb.append(request.getServerPort());
		sb.append(preName + "/images");
		System.out.println("prePath============================"+sb.toString());
		return sb.toString();
	}


	//图片上传,保存到本地
	private List<String> uploadImage(HttpServletRequest request,String prePath) {
		List<String> filePath=new ArrayList<String>();
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
		if (resolver.isMultipart(request)) {
			//将request变成多部分request  
			MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			//获取multiRequest 中所有的文件名
			Iterator<String> iter=multiRequest.getFileNames();
			while(iter.hasNext()) {
				//一次遍历所有文件
				MultipartFile file=multiRequest.getFile(iter.next().toString());
				if(!file.isEmpty()) {
					String name = file.getOriginalFilename();
					String filename = FileUploadUtils.getRealName(name);
					// 得到随机名称
					String uuidname = FileUploadUtils.getUUIDFileName(filename);
					// 得到随机目录
					String randomDirectory = FileUploadUtils.getRandomDirectory(filename);
					//父目录
					String parentPath = request.getServletContext().getRealPath("/images");
					File rd = new File(parentPath, randomDirectory);
					// 注意:随机目录可能不存在，需要创建.
					if (!rd.exists()) {
						rd.mkdirs();
					}
					//上传
					try {
						file.transferTo(new File(rd,uuidname));
						if (file.getName().equals("imgIcon")) {
							filePath.add(0,prePath+randomDirectory+"/"+uuidname);
						}else if (file.getName().equals("imgCover")) {
							filePath.add(1,prePath+randomDirectory+"/"+uuidname);
						}else {
							filePath.add(prePath+randomDirectory+"/"+uuidname);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return filePath;
	}

}