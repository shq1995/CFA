package com.shq.cfa.service.Impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.shq.cfa.entity.Files;
import com.shq.cfa.repository.FilesRepository;
import com.shq.cfa.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author shuihuaqi
 * @create 2018-03-27 10:32
 * @desc 案卷 服务.
 **/
@Service
public class FilesServiceImpl implements FilesService {

	@Autowired
	private FilesRepository filesRepository;

	@Transactional
	@Override
	public Files saveFile(Files file) {
		return filesRepository.save(file);
	}

	@Transactional
	@Override
	public void removeFile(Integer id) {
		filesRepository.delete(id);
	}

	@Transactional
	@Override
	public Files updateFile(Files file) {
		return filesRepository.save(file);
	}

	@Override
	public Files getFileById(Integer id) {
		return filesRepository.findOne(id);
	}

	@Override
	public List<Files> listFiles() {
		return filesRepository.findAll();
	}

	@Override
	public List<Files> findByType(Integer type) {
		return filesRepository.findByType(type);
	}

	@Override
	public List<Files> findByTitle(String title) {
		return filesRepository.findByTitle(title);
	}

	@Override
	public List<Files> findBySourceLike(String source) {
		return filesRepository.findBySourceLike(source);
	}

	@Override
	public List<Files> findByAccuserLike(String accuser) {
		return filesRepository.findByAccuserLike(accuser);
	}

	@Override
	public Page<Files> findFilesNoCriteria(Integer page, Integer size) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		return filesRepository.findAll(pageable);
	}

	@Override
	public Page<Files> findFileCriteria(Integer page, Integer size, String title, String number) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		Page<Files> userPage = filesRepository.findAll(new Specification<Files>(){
			@Override
			public Predicate toPredicate(Root<Files> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(null!=title&&!"".equals(title)){
					list.add(criteriaBuilder.like(root.get("title").as(String.class),  "%"+title+"%"));
				}
				if(null!=number&&!"".equals(number)){
					list.add(criteriaBuilder.equal(root.get("number").as(String.class), number));
				}
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
		return userPage;
	}

	@Override
	public Page<Files> findFilesCriteria(Integer page, Integer size, String title, String number, Integer type) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		Page<Files> userPage = filesRepository.findAll(new Specification<Files>(){
			@Override
			public Predicate toPredicate(Root<Files> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(null!=title&&!"".equals(title)){
					list.add(criteriaBuilder.like(root.get("title").as(String.class),  "%"+title+"%"));
				}
				if(null!=number&&!"".equals(number)){
					list.add(criteriaBuilder.like(root.get("number").as(String.class), "%"+number+"%"));
				}
				if(null!=type&&!"".equals(type)){
					list.add(criteriaBuilder.equal(root.get("type").as(String.class), type));
				}
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
		return userPage;
	}

	@Override
	public Page<Files> findFilesTypeCriteria(Integer page, Integer size, Integer type) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		Page<Files> userPage = filesRepository.findAll(new Specification<Files>(){
			@Override
			public Predicate toPredicate(Root<Files> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(null!=type&&!"".equals(type)){
					list.add(criteriaBuilder.equal(root.get("type").as(String.class), type));
				}
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
		return userPage;
	}

	@Override
	public Page<Files> findBasicsCriteria(Integer page, Integer size, Integer basics) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		Page<Files> userPage = filesRepository.findAll(new Specification<Files>(){
			@Override
			public Predicate toPredicate(Root<Files> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(null!=basics&&!"".equals(basics)){
					list.add(criteriaBuilder.equal(root.get("basics").as(String.class), basics));
				}
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
		return userPage;
	}
}



