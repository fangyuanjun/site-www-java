package com.blog.model;

import java.text.DecimalFormat;

public class AttachmentModel {
	private String fileName;

	private String fileUrl;

	public void setFileUrl(String value) {
		this.fileUrl = value;
	}

	public String getFileUrl() {

		if (fileUrl.startsWith("http://images3.kecq.com")) {
			return "http://upload3.kecq.com/FileUpload?action=download&key="
					+ downloadKey;
		}

		return fileUrl;
	}

	public String getFileName() {

		if (fileName == null || fileName.equals("")) {
			if (fileUrl != null) {
				String temp = fileUrl.replace("\\", "/");
				return temp.substring(temp.lastIndexOf('/') + 1);
			}
		}

		return fileName;

	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSizeString() {

		if (fileSize > 0 && fileSize < 1024) {
			return fileSize + "B";
		}

		DecimalFormat df = new DecimalFormat("#.##");

		if (fileSize >= 1024 && fileSize < 1048576) {
			return df.format(fileSize / 1024.0) + "KB";
		}

		if (fileSize >= 1048576 && fileSize < 1048576 * 1024) {
			return df.format(fileSize / 1048576.0) + "MB";
		}

		return "";
	}

	public int fileSize;

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getDownloadKey() {
		return downloadKey;
	}

	public void setDownloadKey(String downloadKey) {
		this.downloadKey = downloadKey;
	}

	/**
	 * 下载次数
	 */
	public int downloadCount;

	public String downloadKey;

}
