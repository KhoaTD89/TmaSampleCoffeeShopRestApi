package com.tma.sample.coffeeshop.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String formatTimetohhmm(LocalTime localTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return localTime.format(dateTimeFormatter);
    }

    public static LocalTime formatStringToLocalTime(String time){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time,dateTimeFormatter);
    }
}
