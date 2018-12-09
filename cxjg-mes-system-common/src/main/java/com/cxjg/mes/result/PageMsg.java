package com.cxjg.mes.result;

/**
 * @dateTIME 2018/11/21 13:39
 * @Author zhang.wt
 * @company 杭州泽达鑫药盟技术有限公司
 * @department 医疗组
 * @project 药联体
 * @doc
 */
public class PageMsg {
    /**请求成功*/
    public static final int SUCCEED = 1;
    /**请求失败*/
    public static final int FAILED = 0;
    /**token失效**/
    public static final int TOKEN_EXPIRE = 3;
    /**未登陆登录*/
    public static final int UNLOGIN = 9;
    /**
     * 未绑定省份
     */
    public static final int NO_PROVINCE = 2;
    /**
     * 登录超时请重新登录
     */
    public static final String LOGIN_TIME_OUT = "登录超时请重新登录";

}
