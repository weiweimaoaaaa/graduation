package com.commity.backmethod.dao;

import com.commity.backmethod.pojo.HomeAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeAddressDao extends JpaRepository<HomeAddress,String> {
    HomeAddress getByCommunityAndUnitAndHomeNumber(String community,String unit,String homeNumber );
}
