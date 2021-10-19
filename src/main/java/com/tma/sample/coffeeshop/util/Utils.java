package com.tma.sample.coffeeshop.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String formatTimetohhmm(LocalTime localTime){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm");
        return localTime.format(dateTimeFormatter);
    }
}
