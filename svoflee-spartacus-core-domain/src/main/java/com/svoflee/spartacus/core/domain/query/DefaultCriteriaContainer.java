/*
 * @(#)DefaultCriteriaContainer.java  
 *       
 * 系统名称：  
 * 版本号：      1.0.0
 *  
 * Copyright (c)  Victor Li
 * All rights reserved.
 * 
 * 作者: 	    Victor Li
 * 创建日期:    2012-3-12 下午06:00:25
 * 
 */

package com.svoflee.spartacus.core.domain.query;

/**
 * DefaultCriteriaContainer 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class DefaultCriteriaContainer extends BaseCriteriaContainer {

    public DefaultCriteriaContainer(String tableName) {
        super(tableName);
    }

    public DefaultCriteriaContainer() {
        super();
    }

    @Override
    public Criteria and(String columnName) {
        // XXX:目前默认实现FieldCriteria
        Criteria aCriteria = new FieldCriteria(columnName);
        super.and(aCriteria);
        return aCriteria;
    }

    @Override
    public Criteria or(String columnName) {
        Criteria aCriteria = new FieldCriteria(columnName);
        super.or(aCriteria);
        return aCriteria;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getTableName()).append("-").append(getCriterias()).append("-").append(getPage());
        return builder.toString();
    }

}
