package com.test.myDemo;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.test.myDemo.artos.ArtosRepaymentInfo;
import com.test.myDemo.util.ObjectId;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liangliang.gu
 * @date 2021/8/3
 */
public class file {

    public static void main(String[] args) {
        String csvFile = "/Users/guliang/Downloads/jago_loanId.csv";
        String resultCsvFile = "/Users/guliang/Downloads/c.txt";
        BufferedReader br = null;
        String line = "";
        BufferedWriter bw = null;
        try {
            HashMap<String,String> keysMap = Maps.newHashMap();
            br = new BufferedReader(new FileReader(csvFile));
            File writeFile = new File(resultCsvFile);
            if (!writeFile.exists()) {
                writeFile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(writeFile));
            HashMap<String, ArtosRepaymentInfo> hashMap = Maps.newHashMap();
            int i = 0;
            while ((line = br.readLine()) != null) {
                if(keysMap.containsKey(line)){
                    i++;
                }
                keysMap.putIfAbsent(line,line);
            }
            System.out.println(i);
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
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
