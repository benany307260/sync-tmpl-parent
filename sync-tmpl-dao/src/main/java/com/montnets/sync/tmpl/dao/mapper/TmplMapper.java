package com.montnets.sync.tmpl.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.montnets.sync.tmpl.dao.provider.TmplProvider;

@Mapper
public interface TmplMapper {

	/**
	 * 带条件查询
	 * @param paramBean
	 * @param pageParam
	 * @return
	 */
	@SelectProvider(type = TmplProvider.class, method = "findByCondition")
	/*@Results({ 
		
		@Result(property = "createUserid", column = "CREATE_USERID"),
		@Result(property = "updateUserid", column = "UPDATE_USERID"),
		@Result(property = "createTime", column = "CREATE_TIME"),
		@Result(property = "updateTime", column = "UPDATE_TIME")
			})*/
	public List<Long> getByCondition();
	

	
}