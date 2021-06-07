package ai.advance.funding.bean.dto;

import java.util.Date;

public class FundingPartner {
    private Long id;

    private String partnerCode;

    private String legalEntityName;

    private String legalEntityCountry;

    private String legalEntityProvince;

    private String legalEntityDistrict;

    private String legalEntityVillage;

    private String legalEntityAddress;

    private String legalEntity;

    private String platformEntity;

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

    public String getLegalEntityName() {
        return legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) {
        this.legalEntityName = legalEntityName == null ? null : legalEntityName.trim();
    }

    public String getLegalEntityCountry() {
        return legalEntityCountry;
    }

    public void setLegalEntityCountry(String legalEntityCountry) {
        this.legalEntityCountry = legalEntityCountry == null ? null : legalEntityCountry.trim();
    }

    public String getLegalEntityProvince() {
        return legalEntityProvince;
    }

    public void setLegalEntityProvince(String legalEntityProvince) {
        this.legalEntityProvince = legalEntityProvince == null ? null : legalEntityProvince.trim();
    }

    public String getLegalEntityDistrict() {
        return legalEntityDistrict;
    }

    public void setLegalEntityDistrict(String legalEntityDistrict) {
        this.legalEntityDistrict = legalEntityDistrict == null ? null : legalEntityDistrict.trim();
    }

    public String getLegalEntityVillage() {
        return legalEntityVillage;
    }

    public void setLegalEntityVillage(String legalEntityVillage) {
        this.legalEntityVillage = legalEntityVillage == null ? null : legalEntityVillage.trim();
    }

    public String getLegalEntityAddress() {
        return legalEntityAddress;
    }

    public void setLegalEntityAddress(String legalEntityAddress) {
        this.legalEntityAddress = legalEntityAddress == null ? null : legalEntityAddress.trim();
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        this.legalEntity = legalEntity == null ? null : legalEntity.trim();
    }

    public String getPlatformEntity() {
        return platformEntity;
    }

    public void setPlatformEntity(String platformEntity) {
        this.platformEntity = platformEntity == null ? null : platformEntity.trim();
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