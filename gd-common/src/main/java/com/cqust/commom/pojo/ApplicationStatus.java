package com.cqust.commom.pojo;

/**
 * 申请状态
 * 
 * @ClassName: ApplicationStatus
 * @Description: 申请表审核状态值
 * @author Joe
 * @date 2017年3月24日 上午10:06:23
 *
 */
public class ApplicationStatus {

	/**
	 * @Fields WAITEXAMINE : 待审核
	 */
	public static String WAITEXAMINE = "待审核";

	/**
	 * @Fields EXAMINEFAIL : 审核失败
	 */
	public static String EXAMINEFAIL = "审核失败";
	/**
	 * @Fields EXAMINESUCCESS : 审核成功
	 */
	public static String EXAMINESUCCESS = "审核成功";
}
