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
	 * 同步mboss的Cron表达式，默认每5s一次
	 */
	private String syncMbossCron = "0/5 * * * * ?";

	public String getPushTpmlCron() {
		return pushTpmlCron;
	}

	public void setPushTpmlCron(String pushTpmlCron) {
		this.pushTpmlCron = pushTpmlCron;
	}

	public String getSyncMbossCron() {
		return syncMbossCron;
	}

	public void setSyncMbossCron(String syncMbossCron) {
		this.syncMbossCron = syncMbossCron;
	}
	
}
