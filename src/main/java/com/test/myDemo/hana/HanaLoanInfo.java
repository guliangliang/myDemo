package com.test.myDemo.hana;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liangliang.gu
 * @date 2021/6/24
 */
@Data
public class HanaLoanInfo {
    // Alphanumeric (20)
    String loanId;
    // Alphanumeric(100)
    String borrowerName;
    // Alphabet(1)
    String gender;
    // Numeric(16)
    String idNumber;
    // Alphanumeric(50)
    String birthPlace;
    // Date (10)
    String birthDate;
    // Date (10)
    String disbursementDate;
    // Numeric(16, 2)
    BigDecimal loanAmount;
    // Date (10)
    String dueDate;
    // Alphanumeric(20)
    String npwp;
    // Alphanumeric(100)
    String ocrAddress;
    // INTEGER(3)
    String ocrRt;
    // INTEGER(3)
    String ocrRw;
    // VARCHAR(2)
    String ocrProvince;
    // VARCHAR(4)
    String ocrDatiII;
    // VARCHAR(25)
    String ocrVillage;
    // VARCHAR(25)
    String ocrDistrict;
    // VARCHAR(25)
    String ocrCity;
    // INTEGER(6)
    String residentialZipCode;
    // VARCHAR(50)
    String mobileNumber;
    // VARCHAR(50)
    String mothersMaidenName;
    // VARCHAR(3)
    String jobType;
    // VARCHAR(50)
    String employerName;
    // VARCHAR(3)
    String jobIndustry;
    // VARCHAR(3)
    String creditScoring;
    // INTEGER(2)
    String recurringStatus;
    // VARCHAR(1)
    String maritalStatus;
    // VARCHAR(4)
    String religion;
    // VARCHAR(1)
    String monthlyIncome;
    // VARCHAR(2)
    String education;
    // VARCHAR(1)
    String residentialStatus;
    // VARCHAR(50)
    String residentialAddress;
    // INTEGER(3)
    String rt;
    // INTEGER(3)
    String rw;
    // VARCHAR(6)
    String province;
    // VARCHAR(6)
    String datiII;
    // VARCHAR(25)
    String city;
    // VARCHAR(6)
    String country;
    // VARCHAR(25)
    String residentialVillage;
    // VARCHAR(25)
    String residentialDistrict;
    // VARCHAR(25)
    String residentialCity;
    // INTEGER(6)
    String residentialZipCode2;
    // VARCHAR(100)
    String businessAddress;
    // VARCHAR(10)
    String loanPurpose;
    // VARCHAR(10)
    String businessPhone;
    // VARCHAR(50)
    String email;
    // VARCHAR(1)
    String incomeSource;
    // VARCHAR(10)
    String mobileNumber2;
    // VARCHAR(5)
    String nationality;
    // VARCHAR(1)
    String repeatCustomerKebHana;
    // VARCHAR(10)
    String videoCallResult;
    // NUMBER(16, 2)
    String interestRate;
    // NUMBER(16, 2)
    String lateFeePercentage;
    // NUMBER(16, 2)
    String provisionAmount;
    // JPEG
    String photoSelfieWithKtp;
    // MP4
    String videoCall;
    // VARCHAR(25)
    String kebhanaBankAccount;

    @Override
    public String toString() {
        return "" + loanId + "," + borrowerName + "," + gender + "," + idNumber + "," + birthPlace + "," + birthDate + "," + disbursementDate + "," +
                "" + loanAmount + "," + dueDate + "," + npwp + "," + ocrAddress + "," + ocrRt + "," + ocrRw + "," + ocrProvince + "," + ocrDatiII + "," +
                "" + ocrVillage + "," + ocrDistrict + "," + ocrCity + "," + residentialZipCode + "," + mobileNumber + "," + mothersMaidenName + "," +
                "" + jobType + "," + employerName + "," + jobIndustry + "," + creditScoring + "," + recurringStatus + "," + maritalStatus + "," +
                "" + religion + "," + monthlyIncome + "," + education + "," + residentialStatus + "," + residentialAddress + "," + rt + "," + rw + "," +
                "" + province + "," + datiII + "," + city + "," + country + "," + residentialVillage + "," + residentialDistrict + "," + residentialCity + "," +
                "" + residentialZipCode2 + "," + businessAddress + "," + loanPurpose + "," + businessPhone + "," + email + "," + incomeSource + "," +
                "" + mobileNumber2 + "," + nationality + "," + repeatCustomerKebHana + "," + videoCallResult + "," + interestRate + "," +
                "" + lateFeePercentage + "," + provisionAmount + "," + photoSelfieWithKtp + "," + videoCall + "," + kebhanaBankAccount + "";
    }
}
