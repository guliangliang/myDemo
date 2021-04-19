package com.test.myDemo.util;

import org.apache.poi.ss.formula.functions.Finance;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author liang.gu
 * @date 2021/2/4
 */
public class DigitalTest {

    public static void main(String[] args) {
//        System.out.println(1%21);
//        //向上100取整数
//        BigDecimal principal = new BigDecimal(2300000);
//        double perInstallmentRate = 0.18 / 12;
//        BigDecimal installmentAmount = ceil100(pmt(principal, perInstallmentRate, 3));
//        System.out.println(new BigDecimal());

        double t1 = 10164019130d;double t3 = 185632238;double t4 = 3343421;
        double t2 =  214317696;



        System.out.println(new BigDecimal(t1 + t2 + t3 + t4).toString());

    }


    /**
     * PMT（）函数  [每期应还总金额]
     * @param principal
     * @param perInstallmentRate
     * @param installments
     * @return
     */
    private static BigDecimal pmt(BigDecimal principal, double perInstallmentRate, int installments) {
        BigDecimal pmt = perInstallmentRate > 0
                ? new BigDecimal(-Finance.pmt(perInstallmentRate, installments, principal.doubleValue()))
                : (principal.divide(new BigDecimal(installments))) ;
        return installments == 1 ? pmt.setScale(0, RoundingMode.UP) : pmt.setScale(0, RoundingMode.HALF_EVEN);
    }

    /**
     * 向上100取整
     * @param principal
     * @return
     */
    private static BigDecimal ceil100(BigDecimal principal){
        BigDecimal num100 = new BigDecimal(100);
        return principal.divide(num100).setScale(0, RoundingMode.CEILING).multiply(num100);
    }
}
