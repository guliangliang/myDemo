package ai.advance.funding.mapper.funding;

import ai.advance.funding.bean.dto.InstitutionLoan;

public interface InstitutionLoanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InstitutionLoan record);

    int insertSelective(InstitutionLoan record);

    InstitutionLoan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InstitutionLoan record);

    int updateByPrimaryKey(InstitutionLoan record);
}