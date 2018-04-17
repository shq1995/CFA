package com.shq.cfa.service;

import com.shq.cfa.entity.FilesType;
import org.springframework.data.domain.Page;

import java.util.List;


public interface FilesTypeService {

	FilesType saveFilesType(FilesType filesType);

	void removeFilesTppe(Integer id);

	FilesType updateFilesType(FilesType filesType);
	FilesType getFilesTypeByName(String name);
	List<FilesType> getFilesTypeByBasics(Integer basics);

	FilesType getFilesTypeById(Integer id);
	List<FilesType> findAll();
	Page<FilesType> findFilesTypeNoCriteria(Integer page, Integer size);

	Page<FilesType> findFilesTypeCriteria(Integer page, Integer size, String name);
}