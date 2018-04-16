package com.shq.cfa.repository;

import com.shq.cfa.entity.FilesType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface FilesTypeRepository extends JpaRepository<FilesType, Integer>,JpaSpecificationExecutor<FilesType> {
  FilesType findByName(String name);
  List<FilesType> findByBasics(Integer basics);
}
