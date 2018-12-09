package com.cxjg.mes.query;

/**
 * 要分页类继承基类
 *
 */
public abstract class AbstractQueryParameter {
	
	 /**
     * 页码，从1开始
     */
	private int pageNum = 1;
	
	/**
     * 页面大小
     */
	private int pageSize = 10;
	public AbstractQueryParameter() {
		
	}

	public AbstractQueryParameter(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if(pageNum==0){
			pageNum=1;
		}
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize==0){
			pageSize=10;
		}
		this.pageSize = pageSize;
	}
}
