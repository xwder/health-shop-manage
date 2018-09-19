package com.cqust.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqust.commom.utils.GdResult;
import com.cqust.pojo.TUserinfo;

public interface UserService {

	/**
	 * 校验数据合法性 用户名 电话 邮箱是否已存在
	 */
	GdResult checkData(String content, Integer type);

	/**
	 * 创建用户
	 */
	GdResult createUser(TUserinfo user);

	/**
	 * 用户登录
	 */
	GdResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 用户登录
	 */
	GdResult userManagerLogin(String username, String password, Integer identity, HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 根据用户token获取用户信息
	 */
	GdResult getUserByToken(String token);

	/**
	 * logout 根据用户token退出登录
	 */
	GdResult logout(String token);

	/**
	 * @Title: changepw @Description: 修改密码 @param id 用户id @param oldpw
	 * 原密码 @param newpw 新密码 @return @throws
	 */
	GdResult changepw(Integer id, String oldpw, String newpw);
}
