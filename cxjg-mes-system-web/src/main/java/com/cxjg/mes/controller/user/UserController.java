package com.cxjg.mes.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cxjg.mes.controller.webutil.RedisCacheUtil;
import com.cxjg.mes.domain.user.User;
import com.cxjg.mes.query.ReqParameter;
import com.cxjg.mes.result.PageResponse;
import com.cxjg.mes.service.user.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @dateTIME 2018/11/24 21:30
 * @Author zhang.wt
 * @company 杭州泽达鑫药盟技术有限公司
 * @department 医疗组
 * @project 药联体
 * @doc
 */
@RestController
public class UserController extends RedisCacheUtil<String> {
    @Reference
    private IUserService iUserService;

    @RequestMapping("/findUser")
    public PageResponse<User> findUser(ReqParameter query){
        getCacheObject(query.getSearchKey());
        return iUserService.findUser(query);
    }


}
