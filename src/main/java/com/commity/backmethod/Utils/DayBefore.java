package com.commity.backmethod.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
            Date date1=calendar.getTime();
            dates.add(date1);
            calendar.add(Calendar.DATE,-1);
        }
        return dates;
    }
    public static void main(String []ags){
        DayBefore dayBefore=new DayBefore(new Date());
       List<Date> list=dayBefore.beforeDays();
        for (Date value : list) {
            System.out.println(value.toString());
        }
    }

}
