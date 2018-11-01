package com.ivan.study.transaction.service;

import com.ivan.study.transaction.domain.User;

/**
 * Description:
 * author zhanglc
 * Created on 2017/11/28.
 */

public interface UserService {

    void save(User user) ;

    void delByKey(String userNo) ;

    void update(User user ) ;

    void queryByKey(String userNo) ;

}
