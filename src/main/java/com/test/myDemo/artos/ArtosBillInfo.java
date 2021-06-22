package com.test.myDemo.artos;

import lombok.Data;

/**
 * @author liangliang.gu
 * @date 2021/6/21
 */
@Data
public class ArtosBillInfo {
    String loanId;

    Integer installmentNo;

    String dueDate;

    String principalAmount;

    String interestAmount;

    String feeAmount1;

    String feeAmount2;

    String feeAmount3;

    @Override
    public String toString() {
        return "" + loanId + "," + installmentNo + "," + dueDate + "," + principalAmount + "," + interestAmount + "," + feeAmount1 + "," + feeAmount2 + "," + feeAmount3 + "\r\n";
    }
}
