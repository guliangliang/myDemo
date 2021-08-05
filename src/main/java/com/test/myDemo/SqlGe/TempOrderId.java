package com.test.myDemo.SqlGe;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.test.myDemo.artos.ArtosRepaymentInfo;
import com.test.myDemo.util.ObjectId;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author liangliang.gu
 * @date 2021/8/4
 */
public class TempOrderId {
    public static void main(String[] args) {
        String csvFile = "/Users/guliang/Downloads/jago_loanId.csv";
        String resultCsvFile = "/Users/guliang/Downloads/jago.sql";
        BufferedReader br = null;
        String line = "";
        BufferedWriter bw = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            File writeFile = new File(resultCsvFile);
            if(!writeFile.exists()){
                writeFile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(writeFile));

            while ((line = br.readLine()) != null) {
                bw.write("insert into `temp_institution_order_id` ( `order_id`) " +
                        "values('"+ line.trim()+"');");
                bw.newLine();
                bw.flush();
            }
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
