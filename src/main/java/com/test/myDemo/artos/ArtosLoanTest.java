package com.test.myDemo.artos;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author liangliang.gu
 * @date 2021/4/14
 */
public class ArtosLoanTest {

    private static final DateTimeFormatter DISBURSEMENT_FILE_FORMATTER = DateTimeFormatter.ofPattern("'JF_KP_'yyyyMMdd'.csv'");

    public static void main(String[] args) {
        String loanFile = DISBURSEMENT_FILE_FORMATTER.format(LocalDate.now());
        String csvFile = "/Users/guliang/Downloads/b11.csv";
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

                ArtosLoanInfo info = JSON.parseObject(content[0],ArtosLoanInfo.class);
                if(info != null){
                    if(info.getInterestRate().contains(",")){
                        info.setInterestRate(info.getInterestRate().substring(0,info.getInterestRate().indexOf(",")));
                    }
                    bw.write(info.toString());
                }
                i ++ ;
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
