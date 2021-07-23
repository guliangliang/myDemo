package com.test.myDemo.util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liangliang.gu
 * @date 2021/7/4
 */
public class StreanNullTest {
    public static void main(String[] args) {
        List<String> a = null;
        a.stream().collect(Collectors.toList());
    }
}
