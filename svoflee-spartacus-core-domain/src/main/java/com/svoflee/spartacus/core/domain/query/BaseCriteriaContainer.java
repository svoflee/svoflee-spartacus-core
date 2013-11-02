/*
 * @(#)BaseCriteriaContainer.java  
 *       
 * 系统名称：  
 * 版本号：      1.0.0
 *  
 * Copyright (c)  Victor Li
 * All rights reserved.
 * 
 * 作者: 	    Victor Li
 * 创建日期:    2012-3-12 下午05:53:24
 * 
 */

package com.svoflee.spartacus.core.domain.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseCriteriaContainer 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public abstract class BaseCriteriaContainer implements CriteriaContainer {

    private static final Pageable DEFAULT_PAGE = new Page();

    private Map<String, Criteria> criterias = new HashMap<String, Criteria>();

    private Pageable page = DEFAULT_PAGE;

    private String tableName;

    public BaseCriteriaContainer() {
        super();

    }

    public BaseCriteriaContainer(String tableName) {
        super();
        this.tableName = tableName;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public Pageable getPage() {
        return page;
    }

    @Override
    public void setPage(Pageable page) {
        this.page = page;
    }

    @Override
    public CriteriaContainer add(CriteriaJoin criteriaJoin, Criteria... criterias) {
        for (Criteria aCriteria : criterias) {
            aCriteria.setCriteriaJoin(criteriaJoin);
            String key = aCriteria.getColumnName();
            // XXX:是否要检查之前已有的查询条件？目前采取的操作是替换掉以前的查询条件
            getCriterias().put(key, aCriteria);
        }
        return this;
    }

    @Override
    public CriteriaContainer and(Criteria... criterias) {
        return add(CriteriaJoin.AND, criterias);
    }

    @Override
    public CriteriaContainer or(Criteria... criterias) {
        return add(CriteriaJoin.OR, criterias);
    }

    public void setCriterias(Map<String, Criteria> criterias) {
        this.criterias = criterias;
    }

    @Override
    public Map<String, Criteria> getCriterias() {
        return criterias;
    }

    @Override
    public long getTotalPages() {
        return getPage().getTotalPages();
    }

    @Override
    public long getTotalCount() {
        return getPage().getTotalCount();
    }

    @Override
    public int getPageSize() {
        return getPage().getPageSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPrePage() {
        return getPage().getPrePage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isHasPre() {
        return getPage().isHasPre();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNextPage() {
        return getPage().getNextPage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isHasNext() {
        return getPage().isHasNext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTotalCount(long totalCount) {
        getPage().setTotalCount(totalCount);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setContent(List result) {
        getPage().setContent(result);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List getContent() {
        return getPage().getContent();
    }

    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public Iterable getContent() {
    // return getPage().getContent();
    //
    // // return null;
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAutoCount() {
        return getPage().isAutoCount();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFirst() {
        return getPage().getFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pageable pageSize(int thePageSize) {
        return getPage().pageSize(thePageSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPageSize(int pageSize) {
        getPage().setPageSize(pageSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pageable pageNo(int thePageNo) {
        return getPage().pageNo(thePageNo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPageNo(int pageNo) {
        getPage().setPageNo(pageNo);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPageNo() {
        return getPage().getPageNo();
    }

}
