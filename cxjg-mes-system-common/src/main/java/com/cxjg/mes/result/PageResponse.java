package com.cxjg.mes.result;

import java.io.Serializable;
import java.util.List;

public class PageResponse<T> extends AbstractResponse implements Serializable {

    private static final long serialVersionUID = -2166385218121378638L;
    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 总数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;

    /**
     * 查询列表
     */

    private List<T> result;

    public PageResponse(int pageNum, int pageSize, long total, List<T> result) {
	super();
	this.pageNum = pageNum;
	this.pageSize = pageSize;
	this.total = total;
	if (pageSize == 0) {
	    this.pages = 0;
	} else {
	    if (total % pageSize == 0) {
		this.pages = (int) (total / pageSize);
	    } else {
		this.pages = (int) (total / pageSize + 1);
	    }
	}

	this.result = result;
    }

    public PageResponse(String errorInfo) {
        super.setErrorNo(PageMsg.FAILED);
        super.setErrorInfo(errorInfo);
    }

    public int getPageNum() {
	return pageNum;
    }

    public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
    }

    public int getPageSize() {
	return pageSize;
    }

    public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
    }

    public long getTotal() {
	return total;
    }

    public void setTotal(long total) {
	this.total = total;
    }

    public int getPages() {
	return pages;
    }

    public void setPages(int pages) {
	this.pages = pages;
    }

    public List<T> getResult() {
	return result;
    }

    public void setResult(List<T> result) {
	this.result = result;
    }
}
