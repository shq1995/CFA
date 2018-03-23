package com.shq.cfa.dao;

import com.shq.cfa.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDao extends JpaRepository<EmpEntity,Integer> {
}
