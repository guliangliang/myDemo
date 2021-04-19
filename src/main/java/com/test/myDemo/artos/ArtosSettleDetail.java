package com.test.myDemo.artos;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.test.myDemo.util.ObjectId;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author liangliang.gu
 * @date 2021/4/14
 */
public class ArtosSettleDetail {
    public static void main(String[] args) {
        String csvFile = "/Users/guliang/Downloads/b.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\t";
        BufferedWriter bw = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            HashMap<String,ArtosRepaymentInfo> hashMap = Maps.newHashMap();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] content = line.split(cvsSplitBy);

                ArtosRepaymentInfo info = JSON.parseObject(content[1],ArtosRepaymentInfo.class);
                System.out.println(info.getOrderId() + "  " +info.getInstallmentNo());
                if(hashMap.containsKey(info.getOrderId())){
                    ArtosRepaymentInfo info2 = hashMap.get(info.getOrderId());
                    Double a = Double.parseDouble(info.getRepaidPrincipalAmount()) + Double.parseDouble(info2.getRepaidPrincipalAmount()) ;
                    info2.setRepaidPrincipalAmount(a.toString());
                }else{
                    hashMap.put(info.getOrderId(),info);
                }

            }
            double amount = 0;
            for (ArtosRepaymentInfo info : hashMap.values()) {
                System.out.println("insert into `t_institution_settlement_detail` (`id`, `summary_id`, `settle_date`, `order_id`, " +
                        "`delta_settlement_reimburse`, `delta_settlement_rebuy`, `delta_settlement_repaid`, `status`, `create_timestamp`) " +
                        "values('"+ ObjectId.get()+"','606a4bb212aef605141a1dec','2021-04-05','"+info.getOrderId()+"',0.0000,0.0000,"+info.getRepaidPrincipalAmount()+",'CREATED',1617580505000);");

                amount += Double.parseDouble(info.getRepaidPrincipalAmount());
            }
            System.out.println(new BigDecimal(amount).toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
