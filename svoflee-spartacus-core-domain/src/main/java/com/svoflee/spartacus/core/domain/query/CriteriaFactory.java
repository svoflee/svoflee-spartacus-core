/*
 * @(#)CriteriaFactory.java  
 *       
 * 系统名称：  
 * 版本号：      1.0.0
 *  
 * Copyright (c)  Victor Li
 * All rights reserved.
 * 
 * 作者: 	    Victor Li
 * 创建日期:    2012-3-17 下午02:33:20
 * 
 */

package com.svoflee.spartacus.core.domain.query;

/**
 * @author V.L.
 * @since 1.0.0
 */
public class CriteriaFactory {

    public static CriteriaContainer buildCriteriaContainer() {
        CriteriaContainer aCriteriaContainer = new DefaultCriteriaContainer();
        return aCriteriaContainer;
    }
}
