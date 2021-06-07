package com.test.myDemo.artos;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.test.myDemo.util.ObjectId;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liangliang.gu
 * @date 2021/4/14
 */
public class ArtosTest2 {

    static Map<String,Integer> repeatMaps= Maps.newHashMap();

    public static void main(String[] args) {
        String csvFile = "/Users/guliang/Downloads/b14.csv";
        String resultCsvFile = "/Users/guliang/Downloads/b14-result.sql";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\t";
        BufferedWriter bw = null;
        initMap();
        try {

            br = new BufferedReader(new FileReader(csvFile));
            File writeFile = new File(resultCsvFile);
            if(!writeFile.exists()){
                writeFile.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(writeFile));
            HashMap<String,ArtosRepaymentInfo> hashMap = Maps.newHashMap();

            double amount2 = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] content = line.split(cvsSplitBy);

                ArtosRepaymentInfo info = JSON.parseObject(content[6],ArtosRepaymentInfo.class);
                //去重
                if(repeatMaps.containsKey(info.getOrderId()+info.installmentNo)){
                    amount2 +=  Double.parseDouble(info.getRepaidPrincipalAmount());
                    continue;
                }
                if(hashMap.containsKey(info.getOrderId())){
                    ArtosRepaymentInfo info2 = hashMap.get(info.getOrderId());
                    Double a = Double.parseDouble(info.getRepaidPrincipalAmount()) + Double.parseDouble(info2.getRepaidPrincipalAmount()) ;
                    info2.setRepaidPrincipalAmount(a.toString());
                }else{
                    hashMap.put(info.getOrderId(),info);
                }

            }
            System.out.println("去重的本金："+ new BigDecimal(amount2).toString());
            double amount = 0;
            for (ArtosRepaymentInfo info : hashMap.values()) {
//                System.out.println("insert into `t_institution_settlement_detail` (`id`, `summary_id`, `settle_date`, `order_id`, " +
//                        "`delta_settlement_reimburse`, `delta_settlement_rebuy`, `delta_settlement_repaid`, `status`, `create_timestamp`) " +
//                        "values('"+ ObjectId.get()+"','606a4bb212aef605141a1dec','2021-04-05','"+info.getOrderId()+"',0.0000,0.0000,"+info.getRepaidPrincipalAmount()+",'CREATED',1617580505000);");
                bw.write("insert into `t_institution_settlement_detail` (`id`, `summary_id`, `settle_date`, `order_id`, " +
                        "`delta_settlement_reimburse`, `delta_settlement_rebuy`, `delta_settlement_repaid`, `status`, `create_timestamp`) " +
                        "values('"+ ObjectId.get()+"','6076295212aef646f4888afc','2021-04-14','"+info.getOrderId()+"',0.0000,0.0000,"+info.getRepaidPrincipalAmount()+",'CREATED',1617580505000);");
                bw.newLine();
                bw.flush();
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


    public static  void initMap(){
        repeatMaps.put("A161128834249775232",2);
        repeatMaps.put("A161213130559455932",2);
        repeatMaps.put("A161213470676859062",2);
        repeatMaps.put("A161213778414381662",2);
        repeatMaps.put("A161214860890245802",2);
        repeatMaps.put("A161215001080033402",2);
        repeatMaps.put("A161215265844925012",2);
        repeatMaps.put("A161215343517653072",2);
        repeatMaps.put("A161215411979683822",2);
        repeatMaps.put("A161215950175781602",2);
        repeatMaps.put("A161216543873195252",2);
        repeatMaps.put("A161216586362669702",2);
        repeatMaps.put("A161216942587024552",2);
        repeatMaps.put("A161217000351395422",2);
        repeatMaps.put("A161217448138006262",2);
        repeatMaps.put("A161217542490276462",2);
        repeatMaps.put("A161217977136393392",2);
        repeatMaps.put("A161218061590950212",2);
        repeatMaps.put("A161218407138110682",2);
        repeatMaps.put("A161218472813639062",2);
        repeatMaps.put("A161218956960335142",2);
        repeatMaps.put("A161219454980855772",2);
        repeatMaps.put("A161219658139014222",2);
        repeatMaps.put("A161220027262653112",2);
        repeatMaps.put("A161222143699387632",2);
        repeatMaps.put("A161222419308640612",2);
        repeatMaps.put("A161222534003874882",2);
        repeatMaps.put("A161222692576099832",2);
        repeatMaps.put("A161222787219867832",2);
        repeatMaps.put("A161222832252964142",2);
        repeatMaps.put("A161223056734052512",2);
        repeatMaps.put("A161223088979264312",2);
        repeatMaps.put("A161223270795691132",2);
        repeatMaps.put("A161223392890004222",2);
        repeatMaps.put("A161223459979809882",2);
        repeatMaps.put("A161223501391234612",2);
        repeatMaps.put("A161223554933525272",2);
        repeatMaps.put("A161223621767623532",2);
        repeatMaps.put("A161223658641562382",2);
        repeatMaps.put("A161223865770073822",2);
        repeatMaps.put("A161223868955404972",2);
        repeatMaps.put("A161224111696634052",2);
        repeatMaps.put("A161224201082271042",2);
        repeatMaps.put("A161224203384822922",2);
        repeatMaps.put("A161224492064163422",2);
        repeatMaps.put("A161224707896433522",2);
        repeatMaps.put("A161224810804918572",2);
        repeatMaps.put("A161224820293457942",2);
        repeatMaps.put("A161225860646409202",2);
        repeatMaps.put("A161225872673690392",2);
        repeatMaps.put("A161226441980518522",2);
        repeatMaps.put("A161226462068827242",2);
        repeatMaps.put("A161228028775347462",2);
        repeatMaps.put("A161228111989754722",2);
        repeatMaps.put("A161228298337445822",2);
        repeatMaps.put("A161229234235059402",2);
        repeatMaps.put("A161230881589378272",2);
        repeatMaps.put("A161231077907418132",2);
        repeatMaps.put("A161231165103059692",2);
        repeatMaps.put("A161231316565027142",2);
        repeatMaps.put("A161231340628953542",2);
        repeatMaps.put("A161231393747249452",2);
        repeatMaps.put("A161231421749543102",2);
        repeatMaps.put("A161231487867339942",2);
        repeatMaps.put("A161231587913827392",2);
        repeatMaps.put("A161231732347858242",2);
        repeatMaps.put("A161231774658722122",2);
        repeatMaps.put("A161231859222002842",2);
        repeatMaps.put("A161232224114996822",2);
        repeatMaps.put("A161232309392409392",2);
        repeatMaps.put("A161232489569574472",2);
        repeatMaps.put("A161232508243010722",2);
        repeatMaps.put("A161232642897758792",2);
        repeatMaps.put("A161232664737599112",2);
        repeatMaps.put("A161232782307155482",2);
        repeatMaps.put("A161233026350410792",2);
        repeatMaps.put("A161233092739556672",2);
        repeatMaps.put("A161233151726101932",2);
        repeatMaps.put("A161233365360911082",2);
        repeatMaps.put("A161233557620763942",2);
        repeatMaps.put("A161233794814191622",2);
        repeatMaps.put("A161233797573149952",2);
        repeatMaps.put("A161233813327826802",2);
        repeatMaps.put("A161233820538749542",2);
        repeatMaps.put("A161233828567892902",2);
        repeatMaps.put("A161233931414012422",2);
        repeatMaps.put("A161234126518099312",2);
        repeatMaps.put("A161234210342380722",2);
        repeatMaps.put("A161234293965627802",2);
        repeatMaps.put("A161234343473798622",2);
        repeatMaps.put("A161234358617696022",2);
        repeatMaps.put("A161235061794522072",2);
        repeatMaps.put("A161235373113001192",2);
        repeatMaps.put("A161235414182838392",2);
        repeatMaps.put("A161235466470502152",2);
        repeatMaps.put("A161235489916682912",2);
        repeatMaps.put("A161235953376209672",2);
        repeatMaps.put("A161239418059137982",2);
        repeatMaps.put("A161239660873015432",2);
        repeatMaps.put("A161240121167400242",2);
        repeatMaps.put("A161240224248859832",2);
        repeatMaps.put("A161240244250945052",2);
        repeatMaps.put("A161240310371099162",2);
        repeatMaps.put("A161240568853934222",2);
        repeatMaps.put("A161240628584705922",2);
        repeatMaps.put("A161241007666261822",2);
        repeatMaps.put("A161241174843696462",2);
        repeatMaps.put("A161241812430329852",2);
        repeatMaps.put("A161242080732591402",2);
        repeatMaps.put("A161242781045128422",2);
        repeatMaps.put("A161242794398713702",2);
        repeatMaps.put("A161242820136391262",2);
        repeatMaps.put("A161242948520790462",2);
        repeatMaps.put("A161243032692115742",2);
        repeatMaps.put("A161243743512671422",2);
        repeatMaps.put("A161243771313195302",2);
        repeatMaps.put("A161244148944009922",2);
        repeatMaps.put("A161247229522296232",2);
        repeatMaps.put("A161248681482818962",2);
        repeatMaps.put("A161249343584977942",2);
        repeatMaps.put("A161249402470913712",2);
        repeatMaps.put("A161249432289565862",2);
        repeatMaps.put("A161249582796669312",2);
        repeatMaps.put("A161250381472642192",2);
        repeatMaps.put("A161250539108977102",2);
        repeatMaps.put("A161252536087462442",2);
        repeatMaps.put("A161252661556912802",2);
        repeatMaps.put("A161252766460309562",2);
        repeatMaps.put("A161253613849955442",2);
        repeatMaps.put("A161254151936681482",2);
        repeatMaps.put("A161257725748120202",2);
        repeatMaps.put("A161258400942851042",2);
        repeatMaps.put("A161260529471012402",2);
        repeatMaps.put("A161260668032767702",2);
        repeatMaps.put("A161263938133430562",2);
        repeatMaps.put("A161266988546532562",2);
        repeatMaps.put("A161267557257913692",2);
        repeatMaps.put("A161267832381149852",2);
        repeatMaps.put("A161268017950284802",2);
        repeatMaps.put("A161277962941539082",2);
        repeatMaps.put("A161278178623441472",2);
        repeatMaps.put("A161284663174909892",2);
        repeatMaps.put("A161287552316399412",2);
        repeatMaps.put("A161287805598897002",2);
        repeatMaps.put("A161311067711841582",2);
        repeatMaps.put("A161311494778619672",2);
        repeatMaps.put("A161312503295670562",2);
        repeatMaps.put("A161319533598112882",2);
        repeatMaps.put("A161346016552733772",2);
        repeatMaps.put("A161362382168041902",2);
        repeatMaps.put("A161455738915636031",1);
        repeatMaps.put("A161456702099387611",1);
        repeatMaps.put("A161458304114378011",1);
        repeatMaps.put("A161459414927235051",1);
        repeatMaps.put("A161465455755652701",1);
        repeatMaps.put("A161466179767506141",1);
        repeatMaps.put("A161472866007698991",1);
        repeatMaps.put("A161473909588926711",1);
        repeatMaps.put("A161477762775285731",1);
        repeatMaps.put("A161483219385843721",1);
        repeatMaps.put("A161491001042269441",1);
        repeatMaps.put("A161493909325050861",1);
        repeatMaps.put("A161501805643901051",1);
        repeatMaps.put("A161501805643901052",2);
        repeatMaps.put("A161501857538556061",1);
        repeatMaps.put("A161528867522104871",1);
        repeatMaps.put("A161534119222993181",1);
        repeatMaps.put("A161534119222993182",2);
        repeatMaps.put("A161650856439771191",1);
        repeatMaps.put("A161362197040740061",1);
        repeatMaps.put("A161457332974570791",1);
        repeatMaps.put("A161465127434521931",1);
        repeatMaps.put("A161468210306110801",1);
        repeatMaps.put("A161477245666785141",1);
        repeatMaps.put("A161483028587165331",1);
        repeatMaps.put("A161494908299061901",1);
        repeatMaps.put("A161499836630203331",1);
    }

}
