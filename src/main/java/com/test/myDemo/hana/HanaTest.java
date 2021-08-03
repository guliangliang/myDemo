package com.test.myDemo.hana;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.test.myDemo.artos.ArtosRepaymentInfo;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liangliang.gu
 * @date 2021/4/14
 */
public class HanaTest {

    static Map<String, Integer> repeatMaps = Maps.newHashMap();

    private static final DateTimeFormatter GENERAL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter DUE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private static final String NEW_LINE = "\n";
    private static final String COL_SEPARATOR = "|";
    private static final String SPLIT_COL_SEPARATOR = "\\|";
    private static final String KPI = "KPI";
    private static final String DISBURSE_CODE = "01";
    private static final String REPAYMENT_CODE = "03";
    private static final String PKS = "30/626/PN/LM";

    public static void main(String[] args) {
        String csvFile = "/Users/guliang/Downloads/hana-repay.csv";
        String resultCsvFile = "/Users/guliang/Downloads/kp_03_b_20210726.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\t";
        BufferedWriter bw = null;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            File writeFile = new File(resultCsvFile);
            if (!writeFile.exists()) {
                writeFile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(writeFile));
            HashMap<String, ArtosRepaymentInfo> hashMap = Maps.newHashMap();

            double amount2 = 0;
            // use comma as separator
            StringBuffer fileStr = new StringBuffer();
            String fileDate = GENERAL_DATE_FORMATTER.format(LocalDate.of(2021, 4, 29));
            // example: KPI|01|20181231|30/626/PN/LM
            fileStr.append(String.join(COL_SEPARATOR, KPI, REPAYMENT_CODE, fileDate, PKS));
            fileStr.append(NEW_LINE);
            int i = 0;
            BigDecimal totalAmount = BigDecimal.ZERO;

            BigDecimal totalInterest = BigDecimal.ZERO;
            while ((line = br.readLine()) != null) {
                HanaRepaymentInfo info = JSON.parseObject(line, HanaRepaymentInfo.class);
                fileStr.append(info.toString().replaceAll(",", COL_SEPARATOR));
                fileStr.append(NEW_LINE);
                totalAmount = totalAmount.add(info.getPrincipalAmount());
                totalInterest = totalInterest.add(info.interestAmount);
                i ++ ;
            }
            System.out.println("principal == " + totalAmount.toString());
            System.out.println("interest  == " + totalInterest.toString());
            // example: KPI|16|127000
            fileStr.append(String.join(COL_SEPARATOR, KPI, i+"", totalAmount.toString()));
            bw.write(fileStr.toString());
            bw.newLine();
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
