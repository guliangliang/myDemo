package ai.advance.funding.mapper.funding;

import ai.advance.funding.bean.dto.FundingPartner;

public interface FundingPartnerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FundingPartner record);

    int insertSelective(FundingPartner record);

    FundingPartner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FundingPartner record);

    int updateByPrimaryKey(FundingPartner record);
}