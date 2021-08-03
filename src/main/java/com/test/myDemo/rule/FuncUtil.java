package com.test.myDemo.rule;

import org.springframework.util.StringUtils;

/**
 * @author liangliang.gu
 * @date 2021/7/23
 */
public class FuncUtil {
    /**
     * 当前时间是否在此时间区间,EL引擎中会调用使用
     * @param startTime
     * @param endTime
     * @return
     */
    public boolean betweenTime(String startTime,String endTime){
        boolean result = true;
        if(StringUtils.hasLength(startTime)){
            result = DateUtils.isNowAfterTime(startTime);
        }
        if(result && StringUtils.hasLength(endTime)){
            result = DateUtils.isNowBeforeTime(endTime);
        }
        return result;
    }
}
