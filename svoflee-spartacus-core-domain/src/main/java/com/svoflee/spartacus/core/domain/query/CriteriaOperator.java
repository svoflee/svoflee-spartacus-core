/*
 * @(#)CriteriaOperator.java  
 *       
 * 系统名称：  
 * 版本号：      1.0.0
 *  
 * Copyright (c)  Victor Li
 * All rights reserved.
 * 
 * 作者: 	    Victor Li
 * 创建日期:    2012-3-12 下午01:50:07
 * 
 */

package com.svoflee.spartacus.core.domain.query;

/**
 * 查询条件的运算符号
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public enum CriteriaOperator {
    NEAR, WITHIN, WITHIN_CIRCLE, WITHIN_BOX, EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, EXISTS, TYPE, NOT, MOD, SIZE, IN, NOT_IN, ALL, ELEMENT_MATCH, NOT_EQUAL, WHERE;
}
