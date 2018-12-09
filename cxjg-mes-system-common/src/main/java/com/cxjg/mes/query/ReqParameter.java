package com.cxjg.mes.query;

import java.io.Serializable;

/**
 * @dateTIME 2018/7/119:35
 * @Author zhang.wt
 * @company 杭州泽达鑫药盟技术有限公司
 * @department 进销存组
 * @project 药联体
 * @doc 查询参数
 */
public class ReqParameter extends AbstractQueryParameter implements Serializable {
    private static final long serialVersionUID = 2325795017288165856L;
    /**
     * 查询条件
     */
    private String searchKey;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
