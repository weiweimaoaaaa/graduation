package com.commity.backmethod.Utils;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DayBefore {


    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public DayBefore(Date date){
        this.date=date;
    }
    public List<Date> beforeDays(){
        List<Date> dates=new ArrayList<>();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        for(int i=0;i<7;i++){
            java.util.Date date1=calendar.getTime();
            java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
            dates.add(sqlDate);
            calendar.add(Calendar.DATE,-1);
        }
        return dates;
    }
//    public static void main(String []ags){
//        DayBefore dayBefore=new DayBefore(new Date());
//       List<Date> list=dayBefore.beforeDays();
//        for (Date value : list) {
//            System.out.println(value.toString());
//        }
//    }

}
