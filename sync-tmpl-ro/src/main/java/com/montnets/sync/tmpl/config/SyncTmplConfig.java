package com.montnets.sync.tmpl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="sync.tmpl")
public class SyncTmplConfig {
	
	/**
	 * 上报模板的Cron表达式，默认每5s一次
	 */
	private String pushTpmlCron = "0/5 * * * * ?";
	
	/**
	 * 运营商接口url
	 */
	private String url;
	
	/**
	 * 运营商接口鉴权用户名
	 */
	private String userName;
	
	/**
	 * 运营商接口鉴权密码
	 */
	private String userPwd;

	public String getPushTpmlCron() {
		return pushTpmlCron;
	}

	public void setPushTpmlCron(String pushTpmlCron) {
		this.pushTpmlCron = pushTpmlCron;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
}
