package com.commity.backmethod.controller;


import com.commity.backmethod.Utils.GapDate;
import com.commity.backmethod.pojo.ComUserHealthInfo;
import com.commity.backmethod.pojo.ConvenienceCard;
import com.commity.backmethod.result.Result;
import com.commity.backmethod.result.ResultFactory;
import com.commity.backmethod.service.ComUserHealthInfoService;
import com.commity.backmethod.service.ConvenienceCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ConvenienceCardController {

    @Autowired
    ConvenienceCardService convenienceCardService;
    @Autowired
    ComUserHealthInfoService comUserHealthInfoServiceConvenience;//用于获取用户的健康信息
    /**
     * 功能：便民卡申请
     * 说明：用户的ID是身份证
     *      申请时间直接获取当天事件按
     *      使用时间是第二天
     *      申请时的完成度应该为1.表示为申请状态。
     *       -------------------
     *      | 申请 | 使用 |结束 |
     *      -------------------
     *     |   1 |  2   |  3 |
     *     ------------------
     *      用户可以第二天打开便民卡进行查看
     *
     * @param convenienceCard 用户便民卡实体
     * @return  Result便民卡基本信息和返回状态码
     */
    @PostMapping(value="/api/convenienceCardApply")
    @ResponseBody
    public Result apply(@RequestBody List<ConvenienceCard> convenienceCard){
        for (ConvenienceCard card : convenienceCard) {card.setFinished(1);}
        for(int i=0;i<convenienceCard.size();i++) {
            if (convenienceCardService.getCard(convenienceCard.get(i).getUser(), convenienceCard.get(i).getApplyDate()) != null) {
                convenienceCard.remove(i);
                i --;
            }
        }
       // System.out.println("数组长度"+convenienceCard.size());
        if(convenienceCard.size()==0){
            System.out.println("不能重复提交");
            return ResultFactory.buildFailResult("不能重复提交");
        }
       if(convenienceCardService.apply(convenienceCard)==null)
       {
           return ResultFactory.buildFailResult("申请失败");
       }
       else
           return  new Result(200,"申请有待批示",convenienceCard);
    }

    /**
     * 功能：便民卡的状态获取
     * 便民卡的状态返回。第二天查看便面卡的申请成功与否
     * @param convenienceCard :发送申请状态请求数据
     * @return 返回申请状态码
     * --------------------------------------------
     * 首先获取申请用户的当日的健康信息表。
     * 如果没有填写健康信息表没提示用户填写填写健康信息表。
     * 根据用户的健康信息来确定申请是否成功。
     */
    @ResponseBody
    @PostMapping(value="/api/getApplyStatus")//获取申请信息状态
    public Result use(@RequestBody  ConvenienceCard convenienceCard){
        String userId=convenienceCard.getUser();//用户ID。
        java.util.Date date1=new Date();//获取当前时间
        java.sql.Date date=new java.sql.Date(date1.getTime());

        if(Math.abs(GapDate.gapDistanceDay(date,convenienceCard.getUserDate()))>1){//处理时间已经过去了。
            ConvenienceCard convenienceCard1;
            convenienceCard1 = convenienceCard;
            convenienceCard1.setFinished(3);//申请状态改变
            convenienceCardService.apply(convenienceCard1);
            return new Result(400,"申请过期",400);
        }
        ComUserHealthInfo comUserHealthInfo=comUserHealthInfoServiceConvenience.getTodayInfo(userId,date);
        if(comUserHealthInfo==null)//用户还未登记健康信息
        {
            return new Result(400,"未登记当日健康信息表",404);
            //代表用户未登记健康信息表。
        }
        else {
            if(comUserHealthInfo.getCough().equals("是")//用户健康信息无法满足条件。
                    |comUserHealthInfo.getDiagnosis().equals("是")
                    |comUserHealthInfo.getGoDoctor().equals("是")
                    |comUserHealthInfo.getQuarantine().equals("是")
                    |comUserHealthInfo.getShortBreath().equals("是")
                    |comUserHealthInfo.getSuspected().equals("是"))
                return new Result(400,"身体状况不符合申请条件",400);
            else if((comUserHealthInfo.getCough().equals("是"))//成功申请
                    &&(comUserHealthInfo.getDiagnosis().equals("是"))
                    &&(comUserHealthInfo.getGoDoctor().equals("是"))
                    &&(comUserHealthInfo.getQuarantine().equals("是"))
                    &&(comUserHealthInfo.getShortBreath().equals("是"))
                    &&(comUserHealthInfo.getSuspected().equals("是"))){
                //修改用户申请状态
                ConvenienceCard convenienceCard1;
                convenienceCard1 = convenienceCard;
                convenienceCard1.setFinished(2);//申请状态改变
                convenienceCardService.apply(convenienceCard1);
                return new Result(200,"成功申请",convenienceCard1);
            }
        else  return new Result(400,"申请失败",500);//未知原因导致申请失败
        }
    }
}
