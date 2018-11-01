package com.ivan.study.transaction.service.impl;

import com.ivan.study.transaction.domain.Trade;
import com.ivan.study.transaction.domain.User;
import com.ivan.study.transaction.mapper.TradeMapper;
import com.ivan.study.transaction.mapper.UserMapper;
import com.ivan.study.transaction.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Description:
 * author zhanglc
 * Created on 2017/11/28.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper ;

    @Resource
    private TradeMapper tradeMapper ;


    @Override
    public void save(User user) {
        userMapper.insertSelective(user) ;
    }

    @Override
    public void delByKey(String userNo) {
        userMapper.deleteByPrimaryKey(userNo) ;
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user) ;
    }

    @Override
    public void queryByKey(String userNo) {
        userMapper.selectByPrimaryKey(userNo) ;
    }


}
