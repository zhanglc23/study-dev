package com.ivan.study.transaction.service;

import com.ivan.study.transaction.domain.Trade;
import com.ivan.study.transaction.domain.User;

/**
 * Description:
 * author zhanglc
 * Created on 2017/11/28.
 */

public interface TradeService {

    void save(Trade trade) ;

    void delByKey(String trderNo) ;

    void update(Trade trade ) ;

    void queryByKey(String trderNo) ;

    void transfer(String userNo1 , String userNo2 , long amount) ;

}
