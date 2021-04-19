package com.test.myDemo.artos;

import lombok.Data;

/**
 * @author liangliang.gu
 * @date 2021/4/14
 */
@Data
public class ArtosRepaymentInfo {
    String orderId;

    String borrowerName;

    String installmentNo;

    String totalRepaidAmount;

    String repaidPrincipalAmount;

    String repaymentDate;

    String daysInRow;

    String repaymentType;


    @Override
    public String toString() {
        return "" + orderId + "," + borrowerName + "," + installmentNo + "," +
                "\"" + totalRepaidAmount + "\",\"" + repaidPrincipalAmount + "\"," + repaymentDate + "," + daysInRow + "," +
                "" + repaymentType + "\r\n";
    }


}
