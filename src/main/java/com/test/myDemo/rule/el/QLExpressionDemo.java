package com.test.myDemo.rule.el;

import com.google.common.collect.Maps;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import com.ql.util.express.Operator;
import com.test.myDemo.rule.FuncUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ali ql demo
 * @author liangliang.gu
 * @date 2021/4/22
 */
public class QLExpressionDemo {

    public static void main(String[] args) throws Exception{
        ExpressRunner runner = new ExpressRunner();


        getStarted(runner);

//        basicStatement(runner);

//        collectionStatement(runner);

//        objectStatement(runner);

//        functionStatement(runner);

//        macronStatement(runner);

//        workWithJavaStatement(runner);

//        extendOperatorStatement(runner);

//        customOperatorStatement(runner);

    }

    /**
     * 自定义操作符的使用
     * @param runner
     */
    private static void customOperatorStatement(ExpressRunner runner) throws Exception {
        class JoinOperator extends Operator {
            @Override
            public Object executeInner(Object[] list) throws Exception {
                Object opdata1 = list[0];
                Object opdata2 = list[1];
                if(opdata1 instanceof java.util.List){
                    ((List)opdata1).add(opdata2);
                    return opdata1;
                }else{
                    List result = new ArrayList();
                    result.add(opdata1);
                    result.add(opdata2);
                    return result;
                }
            }
        }

        // 返回结果  [1, 2, 3]
        //(1)addOperator
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        runner.addOperator("join",new JoinOperator());
        Object r = runner.execute("1 join 2 join 3", context, null, false, false);
        System.out.println(r);

        // (2) addFunction
        // 返回结果：[1 , 2 ]
        runner.addFunction("joinfunc",new JoinOperator());
        r = runner.execute("joinfunc(1,2,3)", context, null, false, false);
        System.out.println(r);

        //(3)replaceOperator
        // 返回结果  [1, 2, 3]
        runner.replaceOperator("+",new JoinOperator());
        r = runner.execute("1 + 2 + 3", context, null, false, false);
        System.out.println(r);


    }

    /**
     * 操作符处理，一般不太常用，但可以自定义一些操作符
     * @param runner
     */
    private static void extendOperatorStatement(ExpressRunner runner) throws Exception {
        runner.addOperatorWithAlias("如果", "if",null);
        runner.addOperatorWithAlias("则", "then",null);
        runner.addOperatorWithAlias("否则", "else",null);

        IExpressContext<String, Object> context =new DefaultContext<String, Object>();
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);

        String exp = "如果  (语文+数学+英语>270) 则 {return 1;} 否则 {return 0;}";
//        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        Object result = runner.execute(exp, context, null, false, false, null);
        System.out.println(result);
    }

    /**
     * 将Java中已经写好的一些方法，绑定到我们自定义的变量上，在业务中最常用的部分。
     * @param runner
     */
    private static void workWithJavaStatement(ExpressRunner runner) throws Exception {
        // 在使用的时候会创建对象
        runner.addFunctionOfClassMethod("取绝对值", Math.class.getName(), "abs",
                new String[] { "double" }, null);

        // 对象已经存在，直接调用对象中的方法
        runner.addFunctionOfServiceMethod("打印", System.out, "println",new String[] { "String" }, null);

        String exp = "a=取绝对值(-100);打印(\"Hello World\");打印(a.toString())";
        DefaultContext<String, Object> context = new DefaultContext<>();
        runner.execute(exp, context,null,false,false);
        System.out.println(context);
    }

    /**
     * Macro定义, 即预先定义一些内容，在使用的时候直接替换Macro中的变量为上下文的内容
     * @param runner
     */
    private static void macronStatement(ExpressRunner runner) throws Exception {
        runner.addMacro("计算平均成绩", "(语文+数学+英语)/3.0");
        runner.addMacro("是否优秀", "计算平均成绩>90");

        IExpressContext<String, Object> context =new DefaultContext<String, Object>();
        context.put("语文", 88);
        context.put("数学", 99);
        context.put("英语", 95);
        Object result = runner.execute("是否优秀", context, null, false, false);
        System.out.println(result);
    }

    /**
     * 自定义在QLexpress中的函数
     * 一般语句的最后一句话是返回结果
     * @param runner
     */
    private static void functionStatement(ExpressRunner runner) throws Exception {
        String functionStatement = "function add(int a,int b){\n" +
                "  return a+b;\n" +
                "};\n" +
                "\n" +
                "function sub(int a,int b){\n" +
                "  return a - b;\n" +
                "};\n" +
                "\n" +
                "a=10;\n" +
                "add(a,4) + sub(a,9);";

        Object result = runner.execute(functionStatement, new DefaultContext<>(), null, false, false);
//        runner.execute(functionStatement, new DefaultContext<>(), null, true, false, 1000);
        System.out.println(result);
    }

    /**
     * 对Java对象的操作
     * 系统自动会import java.lang.*,import java.util.*;
     * @param runner
     */
    private static void objectStatement(ExpressRunner runner) throws Exception {
//        TradeEvent tradeEvent = new TradeEvent();
//        tradeEvent.setPrice(20.0);
//        tradeEvent.setName("购物");
//        tradeEvent.setId(UUID.randomUUID().toString());//
//
        String objectStatement = "import me.aihe.demo.trade.TradeEvent;\n" +
                "        tradeEvent = new TradeEvent();\n" +
                "        tradeEvent.setPrice(20.0);\n" +
                "        tradeEvent.id=UUID.randomUUID().toString();\n" +
                "        System.out.println(tradeEvent.getId());\n" +
                "        System.out.println(tradeEvent.price);";
        runner.execute(objectStatement, new DefaultContext<>(), null, false, false);

    }

    /**
     * 在定义集合，数组相关的操作，ql有自己的语法，不能简单的使用Java语法
     * //java语法：使用泛型来提醒开发者检查类型
     * keys = new ArrayList<String>();
     * deviceName2Value = new HashMap<String,String>(7);
     * String[] deviceNames = {"ng","si","umid","ut","mac","imsi","imei"};
     * int[] mins = {5,30};
     *
     * //ql写法：
     * keys = new ArrayList();
     * deviceName2Value = new HashMap();
     * deviceNames = ["ng","si","umid","ut","mac","imsi","imei"];
     * mins = [5,30];
     *
     *
     * //java语法：对象类型声明
     * FocFulfillDecisionReqDTO reqDTO = param.getReqDTO();
     * //ql写法：
     * reqDTO = param.getReqDTO();
     *
     * //java语法：数组遍历
     * for(GRCRouteLineResultDTO item : list) {
     * }
     * //ql写法：
     * for(i=0;i<list.size();i++){
     * item = list.get(i);
     * }
     *
     * //java语法：map遍历
     * for(String key : map.keySet()) {
     *   System.out.println(map.get(key));
     * }
     * //ql写法：
     *   keySet = map.keySet();
     *   objArr = keySet.toArray();
     *   for (i=0;i<objArr.length;i++) {
     *   key = objArr[i];
     *    System.out.println(map.get(key));
     *   }
     * @param runner
     */
    private static void collectionStatement(ExpressRunner runner) throws Exception {
        DefaultContext<String, Object> defaultContext = new DefaultContext<>();
        HashMap<String, String> mapData = new HashMap(){{
            put("a","hello");
            put("b","world");
            put("c","!@#$");
        }};
        defaultContext.put("map",mapData);
        //ql不支持for(obj:list){}的语法，只能通过下标访问。
        String mapTraverseStatement = " keySet = map.keySet();\n" +
                "  objArr = keySet.toArray();\n" +
                "  for (i=0;i<objArr.length;i++) {\n" +
                "  key = objArr[i];\n" +
                "   System.out.println(map.get(key));\n" +
                "  }";
        runner.execute(mapTraverseStatement,defaultContext,null,false,false);
        System.out.println(defaultContext);

        // 集合的快捷写法
        /**
         *       ExpressRunner runner = new ExpressRunner(false,false);
         *         DefaultContext<String, Object> context = new DefaultContext<String, Object>();
         *         String express = "abc = NewMap(1:1,2:2); return abc.get(1) + abc.get(2);";
         *         Object r = runner.execute(express, context, null, false, false);
         *         System.out.println(r);
         *         express = "abc = NewList(1,2,3); return abc.get(1)+abc.get(2)";
         *         r = runner.execute(express, context, null, false, false);
         *         System.out.println(r);
         *         express = "abc = [1,2,3]; return abc[1]+abc[2];";
         *         r = runner.execute(express, context, null, false, false);
         *         System.out.println(r);
         */

    }

    /**
     * 语法基本说明：
     * 不支持try{}catch{}
     * 不支持java8的lambda表达式
     * 不支持for循环集合操作for (GRCRouteLineResultDTO item : list)
     * 弱类型语言，请不要定义类型声明
     * 不要用Templete（Map<String,List>之类的）
     * array的声明不一样
     * min,max,round,print,println,like,in 都是系统默认函数的关键字，请不要作为变量名
     * @param runner
     */
    private static void basicStatement(ExpressRunner runner) throws Exception {
        DefaultContext<String, Object> defaultContext = new DefaultContext<>();

//        defaultContext.put("n",10);  //直接从Java中传递上下文等于在表达式中传递上下文
        String loopStatement = "sum=0;n=10;" +
                "for(i=0;i<n;i++){\n" +
                "sum=sum+i;\n" +
                "}\n" +
                "return sum;";
        Object result = runner.execute(loopStatement, defaultContext, null, false, false);
        System.out.println(result);


        // 注意使用同一个defaultContext，上一步语句执行的中间变量会被传递到下一个语句中
        String maxmiumStatement = "a=1;\n" +
                "b=2;\n" +
                "maxnum = a>b?a:b;";
        result = runner.execute(maxmiumStatement, defaultContext, null, false, false);
        System.out.println(result);

    }

    // 入门展示express使用部分
    private static void getStarted(ExpressRunner runner) throws Exception {
        runner.addFunctionOfClassMethod("betweenTime", FuncUtil.class.getName(), "betweenTime",new String[] { "String","String" },null);

        runner.addFunctionOfClassMethod("contains", QLExpressionDemo.class.getName(), "contains",
                new String[] { "String","String" }, null);

//        String express = "(stu_a == 1 && person_b==\"2\" && c>3 && name ==\"zhangsan\") || contains(address,\"999\") == true";
//        String express ="borrowerInfo_name == \"zhangsan\" && borrowerInfo_age >= 15 && borrowerInfo_isDead == false";

        long start = System.currentTimeMillis();

        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
//        context.put("borrowerInfo_age",20);
//        context.put("person_b",2);
//        context.put("c",4);
//        context.put("borrowerInfo_isDead",false);
//        context.put("borrowerInfo_name","zhangsan");
//        context.put("address","this is an adrress name strict beijing");

//        String express="borrowerInfo_name in ('zhangsan','lisi')";
//        String express = "1==1 && (newLoan == true  || (transferLoan == true  && partialLoan == true )) && betweenTime('01:01','02:02') == true";
        String express = "Borrower_age >= 18 && Borrower_age <= 65 ";
        context.put("transferLoan",false);
        context.put("newLoan",true);
        context.put("partialLoan",false);

        Object r = runner.execute(express, context, null, true, true);
        System.out.println(r);

//        for(int i=0;i<1000;i++) {
//
//            DefaultContext<String, Object> context = new DefaultContext<String, Object>();
//            context.put("stu.a",1);
//            context.put("person.b",2);
//            context.put("c",4);
//            context.put("name","zhangsan");
//            context.put("address","this is an adrress name strict beijing" + i);
//
//            Object r = runner.execute(express, context, null, true, true);
//            System.out.println(i + "====" +r);
//        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public boolean contains(String a,String b){
        return a.contains(b);
    }
}
