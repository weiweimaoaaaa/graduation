package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface VisitorDao  extends JpaRepository<Visitor,Integer> {
    List<Visitor> findVisitorByIdIsNotNull();
    List<Visitor> findVisitorByDate(Date date);
}
