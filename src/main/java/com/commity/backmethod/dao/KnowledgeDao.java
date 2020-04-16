package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;
public interface KnowledgeDao  extends JpaRepository<Knowledge,Long> {
    //
}
