package ai.advance.funding.bean.dto;

import java.math.BigDecimal;
import java.util.Date;

public class InstitutionLoan {
    private Long id;

    private String institutionCode;

    private String platformLoanId;

    private String referenceId;

    private String contractId;

    private String channel;

    private String status;

    private BigDecimal institutionPrincipal;

    private BigDecimal institutionInterestRate;

    private BigDecimal institutionUpfrontFee;

    private BigDecimal institutionReceivableInterest;

    private BigDecimal institutionRepaidPrincipal;

    private BigDecimal institutionRepaidInterest;

    private Date institutionStartTime;

    private Date institutionEndTime;

    private Date institutionActualEndTime;

    private Date platformStartTime;

    private Date platformEndTime;

    private Date platformActualEndTime;

    private Boolean active;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode == null ? null : institutionCode.trim();
    }

    public String getPlatformLoanId() {
        return platformLoanId;
    }

    public void setPlatformLoanId(String platformLoanId) {
        this.platformLoanId = platformLoanId == null ? null : platformLoanId.trim();
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId == null ? null : referenceId.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getInstitutionPrincipal() {
        return institutionPrincipal;
    }

    public void setInstitutionPrincipal(BigDecimal institutionPrincipal) {
        this.institutionPrincipal = institutionPrincipal;
    }

    public BigDecimal getInstitutionInterestRate() {
        return institutionInterestRate;
    }

    public void setInstitutionInterestRate(BigDecimal institutionInterestRate) {
        this.institutionInterestRate = institutionInterestRate;
    }

    public BigDecimal getInstitutionUpfrontFee() {
        return institutionUpfrontFee;
    }

    public void setInstitutionUpfrontFee(BigDecimal institutionUpfrontFee) {
        this.institutionUpfrontFee = institutionUpfrontFee;
    }

    public BigDecimal getInstitutionReceivableInterest() {
        return institutionReceivableInterest;
    }

    public void setInstitutionReceivableInterest(BigDecimal institutionReceivableInterest) {
        this.institutionReceivableInterest = institutionReceivableInterest;
    }

    public BigDecimal getInstitutionRepaidPrincipal() {
        return institutionRepaidPrincipal;
    }

    public void setInstitutionRepaidPrincipal(BigDecimal institutionRepaidPrincipal) {
        this.institutionRepaidPrincipal = institutionRepaidPrincipal;
    }

    public BigDecimal getInstitutionRepaidInterest() {
        return institutionRepaidInterest;
    }

    public void setInstitutionRepaidInterest(BigDecimal institutionRepaidInterest) {
        this.institutionRepaidInterest = institutionRepaidInterest;
    }

    public Date getInstitutionStartTime() {
        return institutionStartTime;
    }

    public void setInstitutionStartTime(Date institutionStartTime) {
        this.institutionStartTime = institutionStartTime;
    }

    public Date getInstitutionEndTime() {
        return institutionEndTime;
    }

    public void setInstitutionEndTime(Date institutionEndTime) {
        this.institutionEndTime = institutionEndTime;
    }

    public Date getInstitutionActualEndTime() {
        return institutionActualEndTime;
    }

    public void setInstitutionActualEndTime(Date institutionActualEndTime) {
        this.institutionActualEndTime = institutionActualEndTime;
    }

    public Date getPlatformStartTime() {
        return platformStartTime;
    }

    public void setPlatformStartTime(Date platformStartTime) {
        this.platformStartTime = platformStartTime;
    }

    public Date getPlatformEndTime() {
        return platformEndTime;
    }

    public void setPlatformEndTime(Date platformEndTime) {
        this.platformEndTime = platformEndTime;
    }

    public Date getPlatformActualEndTime() {
        return platformActualEndTime;
    }

    public void setPlatformActualEndTime(Date platformActualEndTime) {
        this.platformActualEndTime = platformActualEndTime;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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