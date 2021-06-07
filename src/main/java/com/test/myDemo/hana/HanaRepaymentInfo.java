package com.test.myDemo.hana;

import lombok.Data;

import java.math.BigDecimal;

/**
 * HanaRepaymentInfo
 *
 * @author: Xugang Song
 * @create: 2020/9/1
 */
@Data
class HanaRepaymentInfo  {

    // Alphanumeric (20)
    String loanId;
    // yyyyMMdd
    String paymentDate;
    // Numeric(16)
    BigDecimal installmentAmount;
    // NUMBER(16, 2)
    BigDecimal principalAmount;
    // NUMBER(16, 2)
    BigDecimal interestAmount;
    // NUMBER(16, 2)
    BigDecimal principalLateFee;
    // NUMBER(16, 2)
    BigDecimal interestLateFee;
    // Numeric(2)
    int installmentNo;
    // yyyyMMdd
    String schedulePaymentDate;
    // outstanding principal, not used in repayment file
    BigDecimal remainingPrincipal;

    @Override
    public String toString() {
        return loanId+","+paymentDate+","+installmentAmount+","+principalAmount+","+interestAmount+","+principalLateFee+"," +
                ""+interestLateFee+","+installmentNo+","+schedulePaymentDate;
    }
}
