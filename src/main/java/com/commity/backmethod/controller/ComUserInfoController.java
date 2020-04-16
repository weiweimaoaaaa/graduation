package com.commity.backmethod.controller;


import com.commity.backmethod.pojo.ComUserInfo;
import com.commity.backmethod.pojo.HomeAddress;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.ComUserInfoService;
import com.commity.backmethod.service.HomeAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ComUserInfoController {
    @Autowired
    ComUserInfoService comUserInfoService;
    @Autowired
    HomeAddressService homeAddressService;
    /**
     * 功能：注册用户人信息
     * @param comUserInfo   用户的基本信息。参考用户实体（地址由系统生成），一次性获取所有家人的信息
     * @param homeAddress   用户的地址信息 ，地址信息只需要一个即可。
     * @return 用户基本信息和地址信息
     */
    @PostMapping(value="/api/userInfoRegister")
    @ResponseBody
    public Result register(@RequestBody List<ComUserInfo> comUserInfo, @RequestBody HomeAddress  homeAddress)
    {
        for(int i=0;i<comUserInfo.size();i++)//设置对象的地址属性
        {
            comUserInfo.get(i).setAddress(homeAddress.getId());
        }
            if(comUserInfoService.register(comUserInfo)!=null&&homeAddressService.register(homeAddress)!=null)
            {
                Object[] object={comUserInfo,homeAddress};
                return ResultFactory.buildSuccessResult(object);
            }
            else return ResultFactory.buildFailResult("添加用户信息失败");
    }

    /**
     * 功能：删除指定的人的基本信息
     * @param comUserInfo
     * @return 该人的基本信息
     */
    @PostMapping(value="/api/deleteUserInfo")//前端接口与传递方式
    @ResponseBody
    public Result delete(@RequestBody ComUserInfo comUserInfo)
    {
        String address=comUserInfo.getAddress();
        comUserInfoService.delete(comUserInfo);
        if(comUserInfoService.count(comUserInfo)==0)
            homeAddressService.delete(homeAddressService.getAddress(address));//删除地址信息
        return ResultFactory.buildSuccessResult(comUserInfo);
    }
    /**
     *功能：修改个人信息
     * @param comUserInfo
     * @return 返回该人修改后的信息
     */
    @PostMapping(value="/api/updateUserInfo")
    @ResponseBody
    public Result update(@RequestBody ComUserInfo comUserInfo)
    {
        String id=comUserInfo.getId();
        if(null==comUserInfoService.update(comUserInfo))
            return ResultFactory.buildFailResult("更新失败");
        else return ResultFactory.buildSuccessResult(comUserInfoService.getInfo(id));
    }
    /**
     * 登录之后获取人员的用户信息进行自动填报
     * @param id  用户的ID。
     * @return data:user同住人的基本信息数组
     */
    @ResponseBody
    @PostMapping(value="/api/getFamilyInfo")
    public Result getUserInfo( @RequestBody  String id){
        ComUserInfo comUserInfo=comUserInfoService.getInfo(id);
        String address=comUserInfo.getAddress();//获取用户的地址信息，便于找出同住人的所有信息
        List<ComUserInfo> user=comUserInfoService.getFamilyInfo(address);
        if(null==user)
        {
            return ResultFactory.buildFailResult("获取失败");
        }
        else return ResultFactory.buildSuccessResult(user);
    }
}
