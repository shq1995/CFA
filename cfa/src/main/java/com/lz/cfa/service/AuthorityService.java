package com.lz.cfa.service;


import com.lz.cfa.entity.Authority;

import java.util.List;


/**
 * @author
 * @create 2018-03-27 10:32
 * @desc Authority 服务接口.
 **/
public interface AuthorityService {
	 
	
	/**
	 * 根据id获取 Authority
	 * @param id
	 * @return
	 */
	Authority getAuthorityById(Integer id);

	List<Authority> listAuthoritys();
	Authority saveAuth(Authority auth);
	void removeAuth(Integer id);
}
