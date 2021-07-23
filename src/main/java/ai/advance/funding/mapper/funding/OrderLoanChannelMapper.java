package ai.advance.funding.mapper.funding;

import ai.advance.funding.bean.dto.OrderLoanChannel;

public interface OrderLoanChannelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderLoanChannel record);

    int insertSelective(OrderLoanChannel record);

    OrderLoanChannel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderLoanChannel record);

    int updateByPrimaryKey(OrderLoanChannel record);
}