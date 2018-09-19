package com.cqust.nutritionist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cqust.commom.pojo.FileUploadResult;
import com.cqust.nutritionist.pojo.ImageUploadResult;
import com.cqust.nutritionist.service.FileUploadService;

@Controller
@RequestMapping("/manager")
public class FileUploadController {

	@Autowired
    FileUploadService fileUploadService;

	@RequestMapping("/uploaditemimage")
	@ResponseBody
	public Object uploadItemImage(HttpServletRequest request) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("upfile");
		ImageUploadResult result = new ImageUploadResult();
		if (!file.isEmpty()) {
			FileUploadResult r = fileUploadService.uploadCarousePicture(file);
			if (r.getStatus() == 200) {
				result.setState("SUCCESS");
				result.setUrl(r.getFileUrl());
				result.setOriginal(r.getFileName());
				result.setTitle(r.getFileName());
			}
		}
		return result;
	}
}
