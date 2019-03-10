package com.montnets.sync.tmpl.service;

import java.util.Map;

public interface IPushTmplService {
	public String pushTmpl(Long tmplId, Map<String,String> paramMap);
}
