package com.montnets.sync.tmpl.dao.provider;

public class TmplProvider {

	/**
	 * 生成查询记录SQL
	 * @param paramBean
	 * @param pageParam
	 * @return
	 */
	public String findByCondition() {
		StringBuffer sql = new StringBuffer("SELECT tmplid FROM template");
		return sql.toString();
	}
	
	
}
