package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.ConvenienceCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvenienceCardDao extends JpaRepository<ConvenienceCard,Long> {
    ConvenienceCard getConvenienceCardByUser(String user);

    //便民卡实现的东西由啥

}
