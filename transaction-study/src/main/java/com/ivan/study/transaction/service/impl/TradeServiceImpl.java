package com.ivan.study.transaction.service.impl;

import com.ivan.study.transaction.domain.Trade;
import com.ivan.study.transaction.domain.User;
import com.ivan.study.transaction.mapper.TradeMapper;
import com.ivan.study.transaction.mapper.UserMapper;
import com.ivan.study.transaction.service.TradeService;
import com.ivan.study.transaction.service.UserService;
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
@Service("tradeService")
public class TradeServiceImpl implements TradeService {

    @Resource
    private TradeMapper tradeMapper ;

    @Resource
    private UserMapper userMapper ;

    @Resource
    private UserService userService ;


    @Override
    public void save(Trade trade) {
        tradeMapper.insertSelective(trade) ;
    }

    @Override
    public void delByKey(String trderNo) {
        tradeMapper.deleteByPrimaryKey(trderNo) ;
    }

    @Override
    public void update(Trade trade) {
        tradeMapper.updateByPrimaryKeySelective(trade) ;
    }

    @Override
    public void queryByKey(String trderNo) {
        tradeMapper.selectByPrimaryKey(trderNo) ;
    }

    @Override
    @Transactional
    public void transfer(String userNo1, String userNo2, long amount) {
        User user1 = userMapper.selectByPrimaryKey(userNo1);
        User user2 = userMapper.selectByPrimaryKey(userNo2);


        user1.setAmount(user1.getAmount() - amount);
        userMapper.updateByPrimaryKeySelective(user1) ;

        user2.setAmount(user2.getAmount() + amount);
        userMapper.updateByPrimaryKeySelective(user2) ;
        if(false)
            throw  new RuntimeException() ;

        Trade trade = new Trade();
        trade.setAmount(amount);
        trade.setCreateTime(new Date());
        trade.setTradeGather(userNo2);
        trade.setTradeNo(System.currentTimeMillis()+"");
        trade.setTradePayer(userNo1);
        tradeMapper.insertSelective(trade) ;
    }

}
