package com.test.myDemo.artos;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @author liangliang.gu
 * @date 2021/4/14
 */
public class ArtosTest {
    public static void main(String[] args) {
        String csvFile = "/Users/guliang/Downloads/jago0407.csv";
        String resultCsvFile = "/Users/guliang/Downloads/result_jago0407.csv";
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
                i ++ ;
                if(i == 1){
                    continue;
                }
                // use comma as separator
                String[] content = line.split(cvsSplitBy);

                ArtosRepaymentInfo info = JSON.parseObject(content[6],ArtosRepaymentInfo.class);
                if(info != null){
                    bw.write(info.toString());
                }

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
