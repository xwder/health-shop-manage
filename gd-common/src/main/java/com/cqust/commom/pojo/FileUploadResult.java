package com.cqust.commom.pojo;

public class FileUploadResult {
	
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    //上传后的文件名
    private String fileName;
    
    //文件上传后的路径
    private String fileUrl;
    
    public String getFileUrl() {
		return fileUrl;
	}
    public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
    

}
