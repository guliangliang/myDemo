package com.test.myDemo.util;

import com.alibaba.fastjson.JSON;

/**
 * @author liangliang.gu
 * @date 2021/4/28
 */
public class HashTest {

    public static void main(String[] args) {
        JSON.parse("123");
        System.out.println(Math.abs("A16143907591772030".hashCode()) % 8);
    }

}
