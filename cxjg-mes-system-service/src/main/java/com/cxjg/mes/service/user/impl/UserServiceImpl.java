package com.cxjg.mes.service.user.impl;

import com.cxjg.mes.domain.user.User;
import com.cxjg.mes.mapper.user.UserMapper;
import com.cxjg.mes.query.ReqParameter;
import com.cxjg.mes.result.PageResponse;
import com.cxjg.mes.result.ResultResponse;
import com.cxjg.mes.service.user.UserService;
import com.cxjg.mes.service.util.RedisCacheUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.cxjg.mes.result.PageMsg.SUCCEED;

/**
 * @dateTIME 2018/11/24 21:32
 * @Author zhang.wt
 * @company 杭州泽达鑫药盟技术有限公司
 * @department 医疗组
 * @project 药联体
 * @doc
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisCacheUtil<String> redisCacheUtil;

    @Override
    public PageResponse<User> findUser(ReqParameter query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        PageInfo<User> pager = new PageInfo<>(
                userMapper.findUser(query));
        PageResponse<User> result = new PageResponse<>(query.getPageNum(),
                query.getPageSize(), pager.getTotal(), pager.getList());
        result.setErrorNo(SUCCEED);
        result.setErrorInfo("成功");
        return result;
    }
}
