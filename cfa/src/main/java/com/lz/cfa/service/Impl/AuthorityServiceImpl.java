
package com.lz.cfa.service.Impl;
import com.lz.cfa.entity.Authority;
import com.lz.cfa.repository.AuthorityRepository;
import com.lz.cfa.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @create 2018-03-27 10:32
 * @desc Authority 服务.
 **/
@Service
public class AuthorityServiceImpl  implements AuthorityService {
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public Authority getAuthorityById(Integer id) {
		return authorityRepository.findOne(id);
	}

	@Override
	public List<Authority> listAuthoritys() {
		return authorityRepository.findAll();
	}

	@Override
	public Authority saveAuth(Authority auth) {
		return authorityRepository.save(auth);
	}

	@Override
	public void removeAuth(Integer id) {
		authorityRepository.delete(id);
	}

}
