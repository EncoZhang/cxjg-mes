package com.cxjg.mes.service.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.cxjg.mes.domain.user.User;
import com.cxjg.mes.query.ReqParameter;
import com.cxjg.mes.result.PageResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @dateTIME 2018/11/29 22:17
 * @Author zhang.wt
 * @company 杭州泽达鑫药盟技术有限公司
 * @department 医疗组
 * @project 药联体
 * @doc
 */
@Service
@Component
public class IUserServiceImpl implements IUserService{
    @Resource
    private UserService userService;

    @Override
    public PageResponse<User> findUser(ReqParameter query) {
        return userService.findUser(query);
    }
}
