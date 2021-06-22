package com.test.myDemo.artos;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author liangliang.gu
 * @date 2021/4/14
 */
public class ArtosBillTest {

    private static final DateTimeFormatter PAYMENT_SCHEDULE_FILE_FORMATTER = DateTimeFormatter.ofPattern("'RS_KP_'yyyyMMdd'.csv'");

    public static void main(String[] args) {
        String loanFile = PAYMENT_SCHEDULE_FILE_FORMATTER.format(LocalDate.now());
        String csvFile = "/Users/guliang/Downloads/b12.csv";
        String resultCsvFile = "/Users/guliang/Downloads/"+loanFile;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\t";
        BufferedWriter bw = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            File writeFile = new File(resultCsvFile);
            if(!writeFile.exists()){
                writeFile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(writeFile));
            int  i = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] content = line.split(cvsSplitBy);

                ArtosBillInfo info = JSON.parseObject(content[0],ArtosBillInfo.class);
                if(info != null){
                    bw.write(info.toString());
                }
                i++;
            }
            System.out.println(i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
