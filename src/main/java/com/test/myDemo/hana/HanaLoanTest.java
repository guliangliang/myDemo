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
public class HanaLoanTest {

    static Map<String, Integer> repeatMaps = Maps.newHashMap();

    private static final DateTimeFormatter GENERAL_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final String COL_SEPARATOR = "|";
    private static final String SPLIT_COL_SEPARATOR = "\\";
    private static final String DISBURSE_CODE = "01";
    private static final String REPAYMENT_CODE = "03";
    private static final String PKS = "30/626/PN/LM";


    private static final String NEW_LINE = "\n";
    private static final String KPI = "KPI";


    public static void main(String[] args) {
        String csvFile = "/Users/guliang/Downloads/hana-23-loanL.csv";
        String resultCsvFile = "/Users/guliang/Downloads/kp_01_b_20210623.txt";
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

            // use comma as separator
            StringBuffer fileStr = new StringBuffer();
            String fileDate = GENERAL_DATE_FORMATTER.format(LocalDate.of(2021, 6, 23));
            // example: KPI|01|20181231|30/626/PN/LM
            fileStr.append(String.join(COL_SEPARATOR, KPI, DISBURSE_CODE, fileDate, PKS));
            fileStr.append(NEW_LINE);
            int i = 0;
            BigDecimal totalAmount = BigDecimal.ZERO;
            while ((line = br.readLine()) != null) {
                HanaLoanInfo info = JSON.parseObject(line, HanaLoanInfo.class);
                fileStr.append(info.toString().replaceAll(",", COL_SEPARATOR));
                fileStr.append(COL_SEPARATOR);
                fileStr.append(NEW_LINE);
                i ++ ;
                totalAmount = totalAmount.add(info.loanAmount);
            }
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
