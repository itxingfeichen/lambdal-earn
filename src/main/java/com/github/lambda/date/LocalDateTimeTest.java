package com.github.lambda.date;

import javafx.util.converter.LocalDateTimeStringConverter;
import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 * @author : chenxingfei
 * @date: 2019-03-28  23:09
 * @description: java8日期测试
 */
public class LocalDateTimeTest {


    /**
     * 日期测试
     */
    @Test
    public void testLocalDate(){
        LocalDate start = LocalDate.now();
        System.out.println(start);
        System.out.println(start.getDayOfWeek());
        int i = start.get(ChronoField.ALIGNED_WEEK_OF_MONTH);
        System.out.println(i);
        LocalDateTime localDateTime = start.atStartOfDay();
        System.out.println(localDateTime);
        System.out.println(start.atStartOfDay(ZoneOffset.UTC));
//        LocalDate parse = LocalDate.parse("yyyy-MM-dd");
//        System.out.println(parse.toString());
    }

    @Test
    public void testLocalDateTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Instant now1 = Instant.now();
        System.out.println(now1);
        Instant now2 = Instant.now();

        System.out.println(now2.toEpochMilli());
    }
}
