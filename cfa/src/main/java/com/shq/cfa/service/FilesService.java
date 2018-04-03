package com.shq.cfa.service;

import com.shq.cfa.entity.Files;

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

}
