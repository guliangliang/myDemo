package com.test.myDemo.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 一、括号是否匹配
 * 1、写一个函数，判断括号是不是匹配，括号有三种 可以嵌套， [](()){}
 * 2、给定一个只包括 ‘(’，’)’，’{’，’}’，’[’，’]’ 的字符串，判断字符串是否有效。
 *      有效字符串需满足：
 *         左括号必须用相同类型的右括号闭合。
 *         左括号必须以正确的顺序闭合。
 *         注意空字符串可被认为是有效字符串。
 *
 *         示例 1:
 *         输入: “{[]}”
 *         输出: true
 *
 *         示例 2:
 *         输入: “([)]”
 *         输出: false
 *
 * 二、顺序输出数字
 * 1 到 10 共10个数字，使用两个线程A、B打印顺序输出，A只打印奇数，B只打印偶数，最终打印结果如下；1、2、3...10
 * @author liangliang.gu
 * @date 2021/6/30
 */
@Slf4j
public class Test2 {
    public static void main(String[] args) {
//        System.out.println(Test2.test1());
        Test2.testLog();
    }

    public static void testLog(){
        try {
            throw new RuntimeException("12312");
        }catch (Exception e){
            log.error("{} is null,{}",1,3,e);
        }

    }

/*    一、括号是否匹配
1、写一个函数，判断括号是不是匹配，括号有三种 可以嵌套， [](()){}
2、给定一个只包括 ‘(’，’)’，’{’，’}’，’[’，’]’ 的字符串，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:
    输入: “{[]}[]()”
    输出: true

    示例 2:
    输入: “([)]”
    输出: false
*/

    public static boolean test1(){
              String str = "{[()]}{}[{[(())]}]()[][]";
              char[] array = str.toCharArray();
              List list = new ArrayList();
              for(int i = 0;i<str.length();i++){
                  if(i==0){
                      list.add(array[i]);
                  }else {
                      if(Test2.check(array[i],array[i-1])){
                          list.remove(list.size()-1);
                          continue;
                      }else {
                          list.add(array[i]);
                      }
                  }
              }
              if(list.size()==0){
                  return true;
              }
        return false;

    }

    public static boolean check(char a,char b){
        if(b=='{' && a=='}' || b=='[' && a==']' || b=='('&& a==')'){
            return true;
        }else {
            return false;
        }

    }
}
