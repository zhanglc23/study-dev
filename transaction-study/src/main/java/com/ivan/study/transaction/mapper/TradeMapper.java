package com.ivan.study.transaction.mapper;

import com.ivan.study.transaction.domain.Trade;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface TradeMapper {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade
     *
     * @mbggenerated Tue Nov 28 10:35:54 CST 2017
     */
    int deleteByPrimaryKey(String tradeNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade
     *
     * @mbggenerated Tue Nov 28 10:35:54 CST 2017
     */
    int insert(Trade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade
     *
     * @mbggenerated Tue Nov 28 10:35:54 CST 2017
     */
    int insertSelective(Trade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade
     *
     * @mbggenerated Tue Nov 28 10:35:54 CST 2017
     */
    Trade selectByPrimaryKey(String tradeNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade
     *
     * @mbggenerated Tue Nov 28 10:35:54 CST 2017
     */
    int updateByPrimaryKeySelective(Trade record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade
     *
     * @mbggenerated Tue Nov 28 10:35:54 CST 2017
     */
    int updateByPrimaryKey(Trade record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}