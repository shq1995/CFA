package com.shq.cfa.repository;

import com.shq.cfa.entity.FilesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface FilesTypeRepository extends JpaRepository<FilesType, Integer>,JpaSpecificationExecutor<FilesType> {

}
