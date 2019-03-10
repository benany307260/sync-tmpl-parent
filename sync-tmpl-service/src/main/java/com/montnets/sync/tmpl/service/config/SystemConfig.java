package com.montnets.sync.tmpl.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="system")
public class SystemConfig {
	
	/**
	 * 数据同步的Cron表达式，默认每5s一次
	 */
	private String dataSyncCron = "0/5 * * * * ?";
	
	/**
	 * 同步mboss的Cron表达式，默认每5s一次
	 */
	private String syncMbossCron = "0/5 * * * * ?";
	
	/**
	 * rsc系统管理员账号
	 */
	private String rscAdminName;
	
	/**
	 * rsc系统管理员密码
	 */
	private String rscAdminPwd;

	public String getDataSyncCron() {
		return dataSyncCron;
	}

	public void setDataSyncCron(String dataSyncCron) {
		this.dataSyncCron = dataSyncCron;
	}

	public String getSyncMbossCron() {
		return syncMbossCron;
	}

	public void setSyncMbossCron(String syncMbossCron) {
		this.syncMbossCron = syncMbossCron;
	}

	public String getRscAdminName() {
		return rscAdminName;
	}

	public void setRscAdminName(String rscAdminName) {
		this.rscAdminName = rscAdminName;
	}

	public String getRscAdminPwd() {
		return rscAdminPwd;
	}

	public void setRscAdminPwd(String rscAdminPwd) {
		this.rscAdminPwd = rscAdminPwd;
	}

}
