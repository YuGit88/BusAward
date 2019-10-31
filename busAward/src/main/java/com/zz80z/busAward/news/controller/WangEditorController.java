package com.zz80z.busAward.news.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zz80z.busAward.common.utils.Result;
import com.zz80z.busAward.common.utils.ResultUtil;

@Controller
public class WangEditorController {

	// 转到wangEditor3的界面
	@RequestMapping(value = "/wangEditor3")
	public ModelAndView wangEditor() {
		return new ModelAndView("index");// index.html
	}

	// 上传图片并返回图片路径(json格式)，接收的图片名和wangEditor定义的图片名保持一致
	@RequestMapping("upload")
	public Result uploadImg(MultipartFile myFileName, HttpSession session, HttpServletRequest request)
			throws IllegalStateException, IOException {
		String realName = "";
		if (myFileName != null) {
			String fileName = myFileName.getOriginalFilename();
			String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length() - 1);
			// 生成实际存储的真实文件名

			realName = UUID.randomUUID().toString() + fileNameExtension;

			// "/upload"是你自己定义的上传目录

			String realPath = session.getServletContext().getRealPath("/upload");
			File uploadFile = new File(realPath, realName);
			myFileName.transferTo(uploadFile);
		}
		String[] str = { request.getContextPath() + "/upload/" + realName };
		return ResultUtil.success(str);
	}
}
