package ai.advance.funding.mapper.funding;

import ai.advance.funding.bean.dto.Institution1;

public interface Institution1Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(Institution1 record);

    int insertSelective(Institution1 record);

    Institution1 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Institution1 record);

    int updateByPrimaryKey(Institution1 record);
}