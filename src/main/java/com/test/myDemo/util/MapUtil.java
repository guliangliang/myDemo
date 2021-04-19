package com.test.myDemo.util;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.test.myDemo.generic.Student;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liangliang.gu
 * @date 2021/3/23
 */
public class MapUtil {

    public static void main(String[] args) {
        Student student1 = new Student("123",12);
        Student student2 = new Student("1233",15);
        List<Student> studentList = Lists.newArrayList();
        studentList.add(student1);
        studentList.add(student2);

        Map<String,Student> stuMap = Maps.uniqueIndex(studentList,Student::getName);

        ;
        List<Student> studentList1 = new ArrayList<>(stuMap.values());
        System.out.println(studentList1.size());

    }
}


