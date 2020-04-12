package com.commity.backmethod.service;

import com.commity.backmethod.dao.HomeAddressDao;
import com.commity.backmethod.pojo.HomeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeAddressService {

    @Autowired
    HomeAddressDao homeAddressDao;
    public  HomeAddress getAddress(String community,String unit,String homeNumber)
    {
        return homeAddressDao.getByCommunityAndUnitAndHomeNumber(community,unit,homeNumber);
    }
}
