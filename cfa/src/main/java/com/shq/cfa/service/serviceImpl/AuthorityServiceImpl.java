
package com.shq.cfa.service.serviceImpl;
import com.shq.cfa.entity.Authority;
import com.shq.cfa.repository.AuthorityRepository;
import com.shq.cfa.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuihuaqi
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
