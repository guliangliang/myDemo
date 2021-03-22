package com.test.myDemo.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangliang.gu
 * @date 2021/3/4
 */
public class ClientTest {

    public static <T extends People>  void testGeneric(List<T> list) {
        for (T t : list) {
            System.out.println(t.getName());
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student x1 = new Student("x1",13);
        Student x2 = new Student("x2",14);
        Student x3 = new Student("x3",15);
        students.add(x1);
        students.add(x2);
        students.add(x3);

        students.forEach(a->{
            System.out.println(a.getName());
            return ;
        });

//        ClientTest.testGeneric(students);
    }
}
