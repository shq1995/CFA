package com.shq.cfa.service;

import com.shq.cfa.entity.Files;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * @author shuihuaqi
 * @create 2018-03-27 10:32
 * @desc 案件 服务接口
 **/
public interface FilesService {
	/**
	 * 保存Files
	 * @param file
	 * @return
	 */
	Files saveFile(Files file);
	
	/**
	 * 删除Files
	 * @param id
	 * @return
	 */
	void removeFile(Integer id);
	
	/**
	 * 更新Files
	 * @param file
	 * @return
	 */
	Files updateFile(Files file);
	
	/**
	 * 根据id获取Files
	 * @param id
	 * @return
	 */
	Files getFileById(Integer id);

	 List<Files> listFiles();

	List<Files> findByType(Integer type);
	//按照标题模糊查询
	List<Files> findByTitle(String title);
	//按照来源模糊查询
	List<Files> findBySourceLike(String source);
	//按照原告模糊查询
	List<Files> findByAccuserLike(String accuser);
	Page<Files> findFilesNoCriteria(Integer page, Integer size);

	Page<Files> findFileCriteria(Integer page,Integer size,String title,String number);
	Page<Files> findFilesCriteria(Integer page,Integer size,String title,String number,Integer type);
	Page<Files> findFilesTypeCriteria(Integer page,Integer size,Integer type);
	Page<Files> findBasicsCriteria(Integer page,Integer size,Integer basics);
}
