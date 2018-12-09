package com.cxjg.mes.service.user;

import com.cxjg.mes.domain.user.User;
import com.cxjg.mes.query.ReqParameter;
import com.cxjg.mes.result.PageResponse;

import java.util.List;

/**
 * @dateTIME 2018/11/24 21:33
 * @Author zhang.wt
 * @company 杭州泽达鑫药盟技术有限公司
 * @department 医疗组
 * @project 药联体
 * @doc
 */
public interface UserService {
    PageResponse<User> findUser(ReqParameter query);
}
