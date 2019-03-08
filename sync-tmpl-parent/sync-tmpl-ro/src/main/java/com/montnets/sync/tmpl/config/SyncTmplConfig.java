package com.montnets.sync.tmpl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="sync.tmpl")
public class SyncTmplConfig {
	
	/**
	 * 上报模板Cron表达式，默认每20s一次
	 */
	private String pushTpmlCron = "0/20 * * * * ?";

	public String getPushTpmlCron() {
		return pushTpmlCron;
	}

	public void setPushTpmlCron(String pushTpmlCron) {
		this.pushTpmlCron = pushTpmlCron;
	}

	
}
