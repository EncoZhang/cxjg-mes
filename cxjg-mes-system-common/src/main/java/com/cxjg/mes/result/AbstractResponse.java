package com.cxjg.mes.result;

import static com.cxjg.mes.result.PageMsg.SUCCEED;

/**
 * @dateTIME 2018/11/21 13:36
 * @Author zhang.wt
 * @company 杭州泽达鑫药盟技术有限公司
 * @department 医疗组
 * @project 药联体
 * @doc
 */
public abstract class AbstractResponse {
    public AbstractResponse() {
        this.errorInfo = "";
        errorNo = 0;
    }

    /**
     * 客户端不接受null 默认""
     */
    String errorInfo;

    /**
     * 1 成功，0失败，    9 未登陆
     */
    int errorNo = SUCCEED;

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        if (errorInfo == null) {
            this.errorInfo = "";
        } else {
            this.errorInfo = errorInfo;
        }

    }
}
