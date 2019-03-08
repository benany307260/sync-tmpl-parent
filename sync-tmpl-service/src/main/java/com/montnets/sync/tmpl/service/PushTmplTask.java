package com.montnets.sync.tmpl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PushTmplTask {
	
	private static Logger log = LoggerFactory.getLogger(PushTmplTask.class);
	
	//private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	public void run() {
		log.info("执行了333");
	}
}
