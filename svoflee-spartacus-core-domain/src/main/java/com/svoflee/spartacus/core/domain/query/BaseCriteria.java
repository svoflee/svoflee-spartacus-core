/*
 * @(#)BaseCriteria.java  
 *       
 * 系统名称：  
 * 版本号：      1.0.0
 *  
 * Copyright (c)  Victor Li
 * All rights reserved.
 * 
 * 作者: 	    Victor Li
 * 创建日期:    2012-3-12 下午01:36:40
 * 
 */

package com.svoflee.spartacus.core.domain.query;

/**
 * @author V.L.
 * @since 1.0.0
 */
public abstract class BaseCriteria implements Criteria {

    private static final long serialVersionUID = 6743262009518909729L;
    /**
     * 该条件与相同字段的查询条件之间的Join关系，And或者 Or
     */
    private CriteriaJoin criteriaJoin = CriteriaJoin.AND;

    @Override
    public void setCriteriaJoin(CriteriaJoin criteriaJoin) {
        this.criteriaJoin = criteriaJoin;
    }

    public CriteriaJoin getCriteriaJoin() {
        return this.criteriaJoin;
    }

}
