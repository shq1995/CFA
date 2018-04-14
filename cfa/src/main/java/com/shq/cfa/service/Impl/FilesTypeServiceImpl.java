package com.shq.cfa.service.Impl;
import com.shq.cfa.entity.FilesType;
import com.shq.cfa.repository.FilesTypeRepository;
import com.shq.cfa.service.FilesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilesTypeServiceImpl implements FilesTypeService {

	@Autowired
	private FilesTypeRepository filesTypeRepository;

	@Transactional
	@Override
	public FilesType saveFilesType(FilesType filesType) {
		return filesTypeRepository.save(filesType);
	}

	@Transactional
	@Override
	public void removeFilesTppe(Integer id) {
		filesTypeRepository.delete(id);
	}

	@Transactional
	@Override
	public FilesType updateFilesType(FilesType filesType) {
		return filesTypeRepository.save(filesType);
	}

	@Override
	public FilesType getFilesTypeById(Integer id) {
		return filesTypeRepository.findOne(id);
	}

	@Override
	public List<FilesType> findAll() {
		return filesTypeRepository.findAll();
	}

	@Override
	public Page<FilesType> findFilesTypeNoCriteria(Integer page, Integer size) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		return filesTypeRepository.findAll(pageable);
	}

	@Override
	public Page<FilesType> findFilesTypeCriteria(Integer page, Integer size, String name) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
		Page<FilesType> userPage = filesTypeRepository.findAll(new Specification<FilesType>(){
			@Override
			public Predicate toPredicate(Root<FilesType> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				list.add(criteriaBuilder.like(root.get("name").as(String.class), "%"+name+"%"));
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
		return userPage;

	}

}



