package ai.advance.funding.bean.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderLoanChannel {
    private Long id;

    private String channel;

    private String platformLoanId;

    private String status;

    private BigDecimal loanAmount;

    private BigDecimal upfrontServiceFee;

    private BigDecimal annualInterestRate;

    private String platformId;

    private String projectId;

    private String projectName;

    private String productId;

    private String productName;

    private String productType;

    private String productItemId;

    private Byte numInstallments;

    private Integer intervals;

    private Integer tenor;

    private String tenorUnit;

    private String disburseDate;

    private String institutionCode;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getPlatformLoanId() {
        return platformLoanId;
    }

    public void setPlatformLoanId(String platformLoanId) {
        this.platformLoanId = platformLoanId == null ? null : platformLoanId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getUpfrontServiceFee() {
        return upfrontServiceFee;
    }

    public void setUpfrontServiceFee(BigDecimal upfrontServiceFee) {
        this.upfrontServiceFee = upfrontServiceFee;
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(String productItemId) {
        this.productItemId = productItemId == null ? null : productItemId.trim();
    }

    public Byte getNumInstallments() {
        return numInstallments;
    }

    public void setNumInstallments(Byte numInstallments) {
        this.numInstallments = numInstallments;
    }

    public Integer getIntervals() {
        return intervals;
    }

    public void setIntervals(Integer intervals) {
        this.intervals = intervals;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public String getTenorUnit() {
        return tenorUnit;
    }

    public void setTenorUnit(String tenorUnit) {
        this.tenorUnit = tenorUnit == null ? null : tenorUnit.trim();
    }

    public String getDisburseDate() {
        return disburseDate;
    }

    public void setDisburseDate(String disburseDate) {
        this.disburseDate = disburseDate == null ? null : disburseDate.trim();
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode == null ? null : institutionCode.trim();
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
}