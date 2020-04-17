package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnowledgeDao  extends JpaRepository<Knowledge,String> {
    List<Knowledge> findKnowledgeByDateAfter(String date);
}
