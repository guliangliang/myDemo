package com.test.myDemo.artos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author liangliang.gu
 * @date 2021/6/8
 */
public class SaveDetailTest {
    public static int BULK_INSERT_SIZE  = 10;
    public static void bulkInsertDetails(List<Integer> details) {
        if (details.size() > 0) {
            int total = details.size();
            int from;
            int to = 0;
            while (to < total) {
                from = to == 0 ? 0 : to;
                to = (to + BULK_INSERT_SIZE) <= total ? to + BULK_INSERT_SIZE : total;
                for (Integer integer : details.subList(from, to)) {
                    System.out.print(integer+" ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
//        List<Integer> details = new ArrayList<>();
//        for(int i=0;i<735;i++){
//            details.add(i);
//        }
//        SaveDetailTest.bulkInsertDetails(details);
        Thread b = null;
        Thread finalB = b;
        Thread a = new Thread(()->{
            for (int i = 1; i<=10 ;i++){
                if(i % 2 ==1) {
                    System.out.println(i);
                    LockSupport.park();
                }
            }
        });

        b = new Thread(()->{
            LockSupport.park();
            for (int i = 1; i<=10 ;i++){
                if(i % 2 ==0) {
                    System.out.println(i);
                    LockSupport.park();
                }
            }
        });
        b.start();
        a.start();
    }
}
