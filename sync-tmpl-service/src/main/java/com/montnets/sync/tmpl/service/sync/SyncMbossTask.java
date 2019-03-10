package com.montnets.sync.tmpl.service.sync;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.montnets.sync.tmpl.dao.mapper.TmplMapper;

@Service
public class SyncMbossTask {
	
	private static Logger log = LoggerFactory.getLogger(SyncMbossTask.class);
	
	//private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	TmplMapper tmplMapper;
	
	public void run() {
		List<Long> tmplIdList = tmplMapper.getByCondition();
		if(tmplIdList != null && tmplIdList.size() > 0) {
			log.info("第一条记录："+tmplIdList.get(0).toString());
		}else {
			log.info("没记录");
		}
		log.info("执行完");
	}
}
