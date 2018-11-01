package com.ivan.study.dao;

import com.ivan.study.domain.User;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}