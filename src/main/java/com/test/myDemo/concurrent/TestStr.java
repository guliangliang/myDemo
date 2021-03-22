package com.test.myDemo.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author liangliang.gu
 * @date 2021/3/22
 */
public class TestStr {

    int i = 0;

    /**
     * 各循环10000次，结果19994
     * @param ab
     */
//    public void testSync(String ab){
//        synchronized (ab){
//            i ++ ;
//        }
//    }

    /**
     * 加final 没什么用
     * @param ab
     */
    public void testSync(String ab){
        final String c = ab;
        synchronized (c){
            i ++ ;
        }
    }

    /**
     * 加final 没什么用
     * @param ab
     */
//    public void testSync(String ab){
//        synchronized (ab.intern()){
//            i ++ ;
//        }
//    }

    public static void main(String[] args) {
        TestStr testStr = new TestStr();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(()->{
            StringBuilder sb = new StringBuilder();
            sb.append("a").append("b");
            String ab = sb.toString();
            for(int i=0;i<10000;i++){
                testStr.testSync(ab);
            }
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            StringBuilder sb = new StringBuilder();
            sb.append("a").append("b");
            String ab = sb.toString();
            for(int i=0;i<10000;i++){
                testStr.testSync(ab);
            }
            countDownLatch.countDown();
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(testStr.i);
    }
}
