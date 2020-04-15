package com.commity.backmethod.controller;
import com.commity.backmethod.pojo.ComUserHealthInfo;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.ComUserHealthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ComUserHealthInfoController {
    @Autowired
    ComUserHealthInfoService comUserHealthInfoService;

    /**
     * 功能：用户的健康信息登记。
     * @param comUserHealthInfo 用户健康信息表的属性值构成的实体数组。一次性提交所有人的健康信息。
     * @return 用户的健康信息登记成功后的信息
     * 接口："api/registerHealthInfo"
     */
    @ResponseBody
    @PostMapping(value="/api/registerHealthInfo")
    public Result addTodayInfo(@RequestBody List<ComUserHealthInfo> comUserHealthInfo)
    {
         List<ComUserHealthInfo> info;
        info=comUserHealthInfoService.addTodayInfoAll(comUserHealthInfo);
        if(null==info)
            return ResultFactory.buildFailResult("添加用户信息失败");
        return ResultFactory.buildSuccessResult(info);
    }
}
