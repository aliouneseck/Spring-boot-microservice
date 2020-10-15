package com.example.microservice.utills;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {

    public static String currentDateMinusThirtyDays() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_MONTH, -30  );
        String thirteenLastDays = sdf.format(c1.getTime()) ;
        return thirteenLastDays ;
    }

}
