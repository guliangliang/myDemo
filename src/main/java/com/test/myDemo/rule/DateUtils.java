package com.test.myDemo.rule;

import org.springframework.util.StringUtils;

import java.time.LocalTime;

/**
 * 时间操作相关
 * @author liangliang.gu
 * @date 2021/5/25
 */
public class DateUtils {

    /**
     * 当前时间是否在time之前
     * @param time 如2:00
     */
    public static Boolean isNowBeforeTime(String time) {
        if(!StringUtils.hasLength(time)){
            return false;
        }
        try {
            String[] tmp = time.split(":");
            return LocalTime.now().isBefore(LocalTime.of(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        } catch (Exception ignored) {
            return false;
        }
    }

    /**
     * 当前时间是否在time之后
     * @param time 如9:00
     */
    public static Boolean isNowAfterTime(String time) {
        if(!StringUtils.hasLength(time)){
            return false;
        }
        try {
            String[] tmp = time.split(":");
            return LocalTime.now().isAfter(LocalTime.of(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])));
        } catch (Exception ignored) {
            return false;
        }
    }

}
