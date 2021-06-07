package com.test.myDemo.thread;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangliang.gu
 * @date 2021/5/22
 */
public class GuardedObjectModel {

    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();

        new Thread(()->{
            System.out.println("等待结果");
            List<String> list = (List<String>)guardedObject.getObject(2000l);
            System.out.println("结果="+list.size());
        },"work").start();

        new Thread(()->{
            System.out.println("执行任务");
            List<String> list = Lists.newArrayList();
            list.add("222");
            guardedObject.setObject(list);
        },"work").start();
    }


    static class GuardedObject {

        private Object guardedObject;

        public Object getObject(long timeout) {
            synchronized (this) {
                long begin = System.currentTimeMillis();
                long passedTime = 0L;
                while (guardedObject == null) {
                    // timeout - passedTime 防止虚假唤醒,记录这一轮需要等待时间
                    long waitTime = timeout - passedTime;
                    if (waitTime <= 0) {
                        break;
                    }
                    try {
                        this.wait(waitTime);
                    } catch (InterruptedException e) {
                        break;
                    }
                    passedTime = System.currentTimeMillis() - begin;
                }
                return guardedObject;
            }
        }

        public void setObject(Object value) {
            synchronized (this) {
                guardedObject = value;
                this.notifyAll();
            }
        }
    }

}
