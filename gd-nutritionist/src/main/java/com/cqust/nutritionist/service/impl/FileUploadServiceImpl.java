package com.cqust.nutritionist.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cqust.commom.pojo.FileUploadResult;
import com.cqust.commom.utils.FtpUtil;
import com.cqust.commom.utils.IDUtils;
import com.cqust.nutritionist.service.FileUploadService;
@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Value("${FTP_ADDRESS}")
	String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	String FTP_BASE_PATH;

	@Value("${IMAGE_BASE_URL}")
	String IMAGE_BASE_URL;

	@Value("${HEADIMAGE_PATH}")
	String HEADIMAGE_PATH;

	@Value("${SHOPIMAGE_PATH}")
	String SHOPIMAGE_PATH;

	@Value("${CAROUSE_PATH}")
	String CAROUSE_PATH;
	
	@Value("${USERINFO_PATH}")
	String USERINFO_PATH;

	@Override
	public FileUploadResult uploadHeadPicture(MultipartFile uploadFile) {
		FileUploadResult fileUploadResult = new FileUploadResult();
		try {
			// 生成一个新的文件名
			// 取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			// 生成新文件名
			// UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			// 图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
					FTP_BASE_PATH + HEADIMAGE_PATH, imagePath, newName, uploadFile.getInputStream());
			// 返回结果
			if (!result) {
				fileUploadResult.setStatus(500);
				fileUploadResult.setMsg("文件上传失败！");
				return fileUploadResult;
			}
			String url = IMAGE_BASE_URL + HEADIMAGE_PATH + imagePath + "/" + newName;
			fileUploadResult.setStatus(200);
			fileUploadResult.setMsg("文件上传成功！");
			fileUploadResult.setFileName(newName);
			fileUploadResult.setFileUrl(url);
			return fileUploadResult;

		} catch (Exception e) {
			fileUploadResult.setStatus(500);
			fileUploadResult.setMsg("文件上传失败！");
			return fileUploadResult;
		}
	}

	@Override
	public FileUploadResult uploadShopPicture(MultipartFile uploadFile) {
		FileUploadResult fileUploadResult = new FileUploadResult();
		try {
			// 生成一个新的文件名
			// 取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			// 生成新文件名
			// UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			// 图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
					FTP_BASE_PATH + SHOPIMAGE_PATH, imagePath, newName, uploadFile.getInputStream());
			// 返回结果
			if (!result) {
				fileUploadResult.setStatus(500);
				fileUploadResult.setMsg("文件上传失败！");
				return fileUploadResult;
			}
			String url = IMAGE_BASE_URL + SHOPIMAGE_PATH + imagePath + "/" + newName;
			fileUploadResult.setStatus(200);
			fileUploadResult.setMsg("文件上传成功！");
			fileUploadResult.setFileName(newName);
			fileUploadResult.setFileUrl(url);
			return fileUploadResult;

		} catch (Exception e) {
			fileUploadResult.setStatus(500);
			fileUploadResult.setMsg("文件上传失败！");
			return fileUploadResult;
		}
	}

	@Override
	public FileUploadResult uploadCarousePicture(MultipartFile uploadFile) {
		FileUploadResult fileUploadResult = new FileUploadResult();
		try {
			// 生成一个新的文件名
			// 取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			// 生成新文件名
			// UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			// 图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
					FTP_BASE_PATH + CAROUSE_PATH, imagePath, newName, uploadFile.getInputStream());
			// 返回结果
			if (!result) {
				fileUploadResult.setStatus(500);
				fileUploadResult.setMsg("文件上传失败！");
				return fileUploadResult;
			}
			String url = IMAGE_BASE_URL + CAROUSE_PATH + imagePath + "/" + newName;
			fileUploadResult.setStatus(200);
			fileUploadResult.setMsg("文件上传成功！");
			fileUploadResult.setFileName(newName);
			fileUploadResult.setFileUrl(url);
			return fileUploadResult;
		} catch (Exception e) {
			fileUploadResult.setStatus(500);
			fileUploadResult.setMsg("文件上传失败！");
			return fileUploadResult;
		}
	}

	@Override
	public FileUploadResult uploadUserInfoPicture(MultipartFile uploadFile) {
		FileUploadResult fileUploadResult = new FileUploadResult();
		try {
			// 生成一个新的文件名
			// 取原始文件名
			String oldName = uploadFile.getOriginalFilename();
			// 生成新文件名
			// UUID.randomUUID();
			String newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			// 图片上传
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
					FTP_BASE_PATH + USERINFO_PATH, imagePath, newName, uploadFile.getInputStream());
			// 返回结果
			if (!result) {
				fileUploadResult.setStatus(500);
				fileUploadResult.setMsg("文件上传失败！");
				return fileUploadResult;
			}
			String url = IMAGE_BASE_URL + USERINFO_PATH + imagePath + "/" + newName;
			fileUploadResult.setStatus(200);
			fileUploadResult.setMsg("文件上传成功！");
			fileUploadResult.setFileName(newName);
			fileUploadResult.setFileUrl(url);
			return fileUploadResult;
		} catch (Exception e) {
			fileUploadResult.setStatus(500);
			fileUploadResult.setMsg("文件上传失败！");
			return fileUploadResult;
		}
	}

}
