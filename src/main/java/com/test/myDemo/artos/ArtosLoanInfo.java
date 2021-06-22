package com.test.myDemo.artos;

import lombok.Data;

/**
 * @author liangliang.gu
 * @date 2021/6/21
 */
@Data
public class ArtosLoanInfo {
    /**
     * orderId
     */
    String loanId;

    /**
     * Tenor Unit 为month填写"KPMON"
     * Tenor Unit 为day填写"KPDAY"
     */
    String productCode;

    /*
     * loan amount
     */
    String loanAmount;

    /**
     * 固定值 00012779999
     */
    String disbursementAccount;

    /**
     * 放款时间，格式 YYYYMMDD
     */
    String disburseDate;

    /**
     * 身份证号类型
     * Id Code
     */
    String idType;

    /*
     * 身份证号
     */
    String idNumber;

    /**
     * borrower name
     */
    String borrowerName;

    /**
     * 教育类型
     */
    String educationType;

    /**
     * 性别
     * ‘male’=‘L’、‘female’=‘P’
     */
    String gender;

    /**
     * 出生地
     */
    String birthPlace;

    /**
     * 出生日期
     */
    String birthDate;

    /**
     * 地址
     */
    String address;

    String village;

    String subDistrict;

    String district;

    String zipCode;

    String phone;

    String mobile;

    String country;

    String jobType;

    String companyName;

    String jobIndustry;

    String companyBusiness;

    String yearlyIncome;

    String incomeSource;

    String bankCode;

    String debtorCode;

    String motherName;

    String aliasName;

    String religion;

    String marriageStatus;

    String province;

    String customerType;

    String npwp;

    String tenorUnit;

    int tenor;

    /**
     * "20,00"
     */
    String interestRate;

    /**
     * 固定值3
     */
    String loanPurpose;


    @Override
    public String toString() {
        return "" + loanId + "," + productCode + "," + loanAmount + "," + disbursementAccount + "," + disburseDate + "," + idType + "," + idNumber + "," + borrowerName + "," + educationType + "," + gender + "," + birthPlace + "," + birthDate + "," + address + "," +
                "" + village + "," + subDistrict + "," + district + "," + zipCode + "," + phone + "," + mobile + "," + country + "," + jobType + "," + companyName + "," + jobIndustry + "," + companyBusiness + "," + yearlyIncome + "," + incomeSource + "," + bankCode + "," +
                "" + debtorCode + "," + motherName + "," + aliasName + "," + religion + "," + marriageStatus + "," + province + "," + customerType + "," + npwp + "," + tenorUnit + "," + tenor + "," + interestRate + "," + loanPurpose + "\r\n";
    }
}
