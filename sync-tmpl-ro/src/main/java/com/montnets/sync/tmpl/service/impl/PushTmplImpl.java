package com.montnets.sync.tmpl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.montnets.sync.tmpl.service.IPushTmplService;

@Service
public class PushTmplImpl implements IPushTmplService {

	private static Logger log = LoggerFactory.getLogger(PushTmplImpl.class);
	
	@Override
	public String pushTmpl(Long tmplId) {
		log.info("模板上报");
		// 下载模板
		// 解析模板
		// 构造格式
		// 上报
		// 处理结果
		// 返回结果
		return "true3333";
	}

}
