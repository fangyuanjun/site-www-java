/**
 * DataConnStr.java
 * 2010-5-30
 */
package com.kecq.data;

/**
 * 
 * @author ·½Ô¶¾ù
 * @version 1.0
 */
public class DataInfo {
	private String conName;
	private String dirverName;
	private String conStr;
	private String username;
	private String password;
	private int maxCon;

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getDirverName() {
		return dirverName;
	}

	public void setDirverName(String dirverName) {
		this.dirverName = dirverName;
	}

	public String getConStr() {
		return conStr;
	}

	public void setConStr(String conStr) {
		this.conStr = conStr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMaxCon() {
		return maxCon;
	}

	public void setMaxCon(int maxCon) {
		this.maxCon = maxCon;
	}

}
