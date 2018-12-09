package com.cxjg.mes.mapper.user;

import com.cxjg.mes.domain.user.User;
import com.cxjg.mes.query.ReqParameter;

import java.util.List;
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findUser(ReqParameter parameter);
}