package ai.advance.funding.bean.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Institution1 {
    private Long id;

    private String partnerCode;

    private String institutionName;

    private String institutionCode;

    private String settlementType;

    private String institutionType;

    private BigDecimal creditLimit;

    private String currency;

    private Boolean enable;

    private Integer priority;

    private Long accountSign;

    private BigDecimal interestRate;

    private Boolean includeHoliday;

    private String startTime;

    private String endTime;

    private Integer dailyMaxLimit;

    private BigDecimal dailyMaxAmountLimit;

    private String buybackEntity;

    private String lender;

    private Boolean groupLegalGntity;

    private String disbursementAccount;

    private String disbursementAccountBankName;

    private String repaymentAccount;

    private String repaymentAccountBankName;

    private String sourceOfFund;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode == null ? null : partnerCode.trim();
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName == null ? null : institutionName.trim();
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode == null ? null : institutionCode.trim();
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType == null ? null : settlementType.trim();
    }

    public String getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(String institutionType) {
        this.institutionType = institutionType == null ? null : institutionType.trim();
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getAccountSign() {
        return accountSign;
    }

    public void setAccountSign(Long accountSign) {
        this.accountSign = accountSign;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Boolean getIncludeHoliday() {
        return includeHoliday;
    }

    public void setIncludeHoliday(Boolean includeHoliday) {
        this.includeHoliday = includeHoliday;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getDailyMaxLimit() {
        return dailyMaxLimit;
    }

    public void setDailyMaxLimit(Integer dailyMaxLimit) {
        this.dailyMaxLimit = dailyMaxLimit;
    }

    public BigDecimal getDailyMaxAmountLimit() {
        return dailyMaxAmountLimit;
    }

    public void setDailyMaxAmountLimit(BigDecimal dailyMaxAmountLimit) {
        this.dailyMaxAmountLimit = dailyMaxAmountLimit;
    }

    public String getBuybackEntity() {
        return buybackEntity;
    }

    public void setBuybackEntity(String buybackEntity) {
        this.buybackEntity = buybackEntity == null ? null : buybackEntity.trim();
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender == null ? null : lender.trim();
    }

    public Boolean getGroupLegalGntity() {
        return groupLegalGntity;
    }

    public void setGroupLegalGntity(Boolean groupLegalGntity) {
        this.groupLegalGntity = groupLegalGntity;
    }

    public String getDisbursementAccount() {
        return disbursementAccount;
    }

    public void setDisbursementAccount(String disbursementAccount) {
        this.disbursementAccount = disbursementAccount == null ? null : disbursementAccount.trim();
    }

    public String getDisbursementAccountBankName() {
        return disbursementAccountBankName;
    }

    public void setDisbursementAccountBankName(String disbursementAccountBankName) {
        this.disbursementAccountBankName = disbursementAccountBankName == null ? null : disbursementAccountBankName.trim();
    }

    public String getRepaymentAccount() {
        return repaymentAccount;
    }

    public void setRepaymentAccount(String repaymentAccount) {
        this.repaymentAccount = repaymentAccount == null ? null : repaymentAccount.trim();
    }

    public String getRepaymentAccountBankName() {
        return repaymentAccountBankName;
    }

    public void setRepaymentAccountBankName(String repaymentAccountBankName) {
        this.repaymentAccountBankName = repaymentAccountBankName == null ? null : repaymentAccountBankName.trim();
    }

    public String getSourceOfFund() {
        return sourceOfFund;
    }

    public void setSourceOfFund(String sourceOfFund) {
        this.sourceOfFund = sourceOfFund == null ? null : sourceOfFund.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}