package com.test.myDemo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author liangliang.gu
 * @date 2021/3/12
 */
public class TestList {

    public static void main(String[] args) {
//        List<Student> students = new CopyOnWriteArrayList<>();
        long start = System.currentTimeMillis();
//        List<Student> students = new ArrayList<>();
//        for(int i = 0; i<100000;i++){
//            Student student = new Student("z"+i,i,"sex"+i);
//            students.add(student);
//        }
        List<Student> students = IntStream.range(0,10).parallel().mapToObj(i->{
            return new Student("z"+i,i,"sex"+i);
        }).collect(Collectors.toList());

        students.parallelStream().map( loan ->{
        return 1;
        }).collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    static class Student{
        public Student(String name,int age,String gender){
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        String name;
        int age;
        String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
