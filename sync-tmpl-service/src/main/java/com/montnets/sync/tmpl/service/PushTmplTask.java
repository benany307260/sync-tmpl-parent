package com.montnets.sync.tmpl.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montnets.sync.tmpl.dao.mapper.TmplMapper;

@Service
public class PushTmplTask {
	
	private static Logger log = LoggerFactory.getLogger(PushTmplTask.class);
	
	//private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private TmplMapper tmplMapper;
	
	private IPushTmplService pushTmplService;
	
	/*public PushTmplTask(IPushTmplService pushTmplService) {
		this.pushTmplService = pushTmplService;
	}*/
	
	public void run() {
		List<Long> tmplIdList = tmplMapper.getByCondition();
		if(tmplIdList == null || tmplIdList.size() < 1) {
			return;
		}
		for(Long tmplId : tmplIdList) {
			log.info("上报模板，tmplId="+tmplId);
			String result = pushTmplService.pushTmpl(tmplId);
			// 结果存库
			log.info(result);
		}
	}

	public IPushTmplService getPushTmplService() {
		return pushTmplService;
	}

	public void setPushTmplService(IPushTmplService pushTmplService) {
		this.pushTmplService = pushTmplService;
	}
	
	
	
}
