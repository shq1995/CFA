package com.shq.cfa.service.serviceImpl;

import javax.transaction.Transactional;
import com.shq.cfa.entity.User;
import com.shq.cfa.entity.Files;
import com.shq.cfa.repository.FilesRepository;
import com.shq.cfa.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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


}
