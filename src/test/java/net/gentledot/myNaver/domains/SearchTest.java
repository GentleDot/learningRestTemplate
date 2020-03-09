package net.gentledot.myNaver.domains;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

//    y   = year   (yy or yyyy)
//    M   = month  (MM)
//    d   = day in month (dd)
//    h   = hour (0-12)  (hh)
//    H   = hour (0-23)  (HH)
//    m   = minute in hour (mm)
//    s   = seconds (ss)
//    S   = milliseconds (SSS)
//    z   = time zone  text        (e.g. Pacific Standard Time...)
//    Z   = time zone, time offset (e.g. -0800)
//   "Thu, 23 Jan 2020 15:25:36 +0900
    @Test
    void getDateTest() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "Thu, 23 Jan 2020 15:25:36 +0900";
        Date date = sdf.parse(dateInString);
        System.out.println(date); //Prints Tue Oct 15 10:20:56 SGT 2015
    }

}