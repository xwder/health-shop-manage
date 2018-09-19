package com.cqust.nutritionist.service;

import org.springframework.web.multipart.MultipartFile;

import com.cqust.commom.pojo.FileUploadResult;

public interface FileUploadService {

	/** 
	 * @Title: uploadHeadPicture 
	 * @Description: 上传头像
	 * @param uploadFile
	 * @return      
	 * @throws 
	 */
	FileUploadResult uploadHeadPicture(MultipartFile uploadFile);
	/** 
	 * @Title: uploadShopPicture 
	 * @Description: 上传商品图片
	 * @param uploadFile
	 * @return      
	 * @throws 
	 */
	FileUploadResult uploadShopPicture(MultipartFile uploadFile);
	/** 
	 * @Title: uploadCarousePicture 
	 * @Description: 上传轮播图片
	 * @param uploadFile
	 * @return      
	 * @throws 
	 */
	FileUploadResult uploadCarousePicture(MultipartFile uploadFile);
	/** 
	 * @Title: uploadUserInfoPicture 
	 * @Description: 上传其他图片 
	 * @param uploadFile
	 * @return      
	 * @throws 
	 */
	FileUploadResult uploadUserInfoPicture(MultipartFile uploadFile);
}