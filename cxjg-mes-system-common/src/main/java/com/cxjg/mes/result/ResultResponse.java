package com.cxjg.mes.result;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @param <T>
 * @author yjx
 * @Description: TODO    客户端交互返回的实体类
 * @date 2018年5月28日 下午8:41:18
 */
public class ResultResponse<T> extends AbstractResponse implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 8234142324386865088L;
    private T result;

    public ResultResponse(int errorNo) {
        super();
        this.setErrorNo(errorNo);
    }

    public ResultResponse(int errorNo, String errorInfo) {
        super();
        this.setErrorNo(errorNo);
        if (StringUtils.isEmpty(errorInfo)) {
            super.errorInfo = "";
        } else {
            super.errorInfo = errorInfo;
        }
    }

    public ResultResponse(int errorNo, String errorInfo, T t) {
        super();
        this.setErrorNo(errorNo);
        if (StringUtils.isEmpty(errorInfo)) {
            super.errorInfo = "";
        } else {
            super.errorInfo = errorInfo;
        }
        this.result = t;
    }

    public String getErrorInfo() {
        return super.errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        if (StringUtils.isEmpty(errorInfo)) {
            super.errorInfo = "";
        } else {
            super.errorInfo = errorInfo;
        }

    }

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
