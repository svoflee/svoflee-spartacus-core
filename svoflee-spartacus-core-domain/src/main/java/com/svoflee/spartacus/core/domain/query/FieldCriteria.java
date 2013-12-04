/*
 * Copyright (c) http://www.svoflee.com All rights reserved.
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************      
 */

package com.svoflee.spartacus.core.domain.query;

import java.util.HashSet;
import java.util.Set;

/**
 * FieldCriteria 是字段型的查询条件
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class FieldCriteria extends BaseCriteria {

    private static final long serialVersionUID = -7078873793974559611L;

    /**
     * 第一个Criteria
     */
    private Criteria rootCriteria = null;

    /**
     * 字段名
     */
    private String fieldName;

    /**
     * 该查询条件的查询操作符
     */
    private CriteriaOperator criteriaOperator;

    /**
     * 该查询条件的值，根据不同的查询条件运算符，类型不同，e.g.如果是Between类型的，则为Collection类型
     */
    private Object value;

    /**
     * 这个相同字段名的查询的所有查询条件
     */
    private Set<Criteria> criteriaCollection;

    public FieldCriteria(String fieldName) {
        this(fieldName, CriteriaJoin.AND);
    }

    public FieldCriteria(String fieldName, CriteriaJoin criteriaJoin) {
        this(null, fieldName, criteriaJoin, null, null);
    }

    /**
     * @param rootCriteria
     * @param fieldName
     * @param criteriaJoin
     * @param criteriaOperator
     * @param value
     */
    public FieldCriteria(Criteria rootCriteria, String fieldName, CriteriaJoin criteriaJoin,
            CriteriaOperator criteriaOperator, Object value) {
        if (rootCriteria == null) {
            // 如果当前是Root Criteria，则创建
            setCriteriaCollection(new HashSet<Criteria>());
            getCriteriaCollection().add(this);
        }
        setCriteriaJoin(criteriaJoin);

        setRootCriteria(rootCriteria);
        setFieldName(fieldName);
        setCriteriaOperator(criteriaOperator);
        setValue(value);
    }

    @Override
    public String getColumnName() {
        return fieldName;
    }

    @Override
    public Criteria or(CriteriaOperator criteriaOperator, Object value) {
        throw new UnsupportedOperationException();
        // EUtils.throwNotSupportedException(Version.V1_0_0);
        // return null;

        // FieldCriteria aNewFieldCriteria = new FieldCriteria(this, this.getFieldName(), CriteriaJoin.OR,
        // criteriaOperator, value);
        // return this.add(aNewFieldCriteria);
    }

    @Override
    public Criteria and(CriteriaOperator criteriaOperator, Object value) {
        FieldCriteria aNewFieldCriteria = new FieldCriteria(this, getColumnName(), CriteriaJoin.AND, criteriaOperator,
                value);
        return add(aNewFieldCriteria);
    }

    @Override
    public Criteria add(Criteria... criterias) {
        for (Criteria aCriteria : criterias) {
            if (aCriteria instanceof FieldCriteria) {
                FieldCriteria aFieldCriteria = (FieldCriteria) aCriteria;
                if (aFieldCriteria.getColumnName().equals(getColumnName())) {
                    // 类型一致并且字段一致才进行添加
                    aFieldCriteria.setRootCriteria(this);// 将对方的root设置成自己
                    getCriteriaCollection().add(aFieldCriteria);
                    aFieldCriteria.setCriteriaCollection(getCriteriaCollection());
                }
                else {
                    // V1.0.0,支持同名field相互添加
                    throw new UnsupportedOperationException("1.0.0");
                }
            }
            else {
                // V1.0.0,支持FieldCriteria一种类型
                // XXX:是否是只有FieldCriteria才能被添加?

                throw new UnsupportedOperationException("1.0.0");
            }
        }
        return this;
    }

    public boolean isRootCriteria() {
        return getRootCriteria() == null;
    }

    public void setRootCriteria(Criteria rootCriteria) {
        this.rootCriteria = rootCriteria;
    }

    public Criteria getRootCriteria() {
        return rootCriteria;
    }

    public void setCriteriaOperator(CriteriaOperator criteriaOperator) {
        this.criteriaOperator = criteriaOperator;
    }

    public CriteriaOperator getCriteriaOperator() {
        return criteriaOperator;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setCriteriaCollection(Set<Criteria> criteriaCollection) {
        this.criteriaCollection = criteriaCollection;
    }

    public Set<Criteria> getCriteriaCollection() {
        return criteriaCollection;
    }

    @Override
    public Criteria same(Object value) {
        return and(CriteriaOperator.EQUAL, value);
    }

    @Override
    public Criteria notSame(Object value) {
        return and(CriteriaOperator.NOT_EQUAL, value);
    }

    @Override
    public Criteria greaterThan(Object value) {
        return and(CriteriaOperator.GREATER_THAN, value);

    }

    @Override
    public Criteria greaterThanEquals(Object value) {
        return and(CriteriaOperator.GREATER_THAN_OR_EQUAL, value);
    }

    @Override
    public Criteria lessThan(Object value) {
        return and(CriteriaOperator.LESS_THAN, value);
    }

    @Override
    public Criteria lessThanEquals(Object value) {
        return and(CriteriaOperator.LESS_THAN_OR_EQUAL, value);
    }

    @Override
    public Criteria in(Iterable value) {
        return and(CriteriaOperator.IN, value);
    }

    @Override
    public Criteria notIn(Iterable values) {
        return and(CriteriaOperator.NOT_IN, value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(fieldName).append("-").append(criteriaOperator).append("-").append(value);
        return builder.toString();
    }

}
