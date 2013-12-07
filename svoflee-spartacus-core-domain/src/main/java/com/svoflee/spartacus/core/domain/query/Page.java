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

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 与具体ORM实现无关的分页参数及查询结果封装.
 * 注意所有序号从1开始.
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 * @param <T> Page中记录的类型.
 */
public class Page<T> implements Pageable, Serializable {

    public static final long serialVersionUID = -8062398267244803380L;

    public static final int DEFAULT_PAGE_SIZE = 50;

    public static final int DEFAULT_FIRST_PAGE_NO = 1;

    /**
     * 当前页码
     */
    protected int pageNo = DEFAULT_FIRST_PAGE_NO;

    /**
     * 每一页的数量
     */
    protected int pageSize = DEFAULT_PAGE_SIZE;

    protected boolean autoCount = true;

    protected List result = Lists.newArrayList();

    protected long totalCount = -1;

    // -- 构造函数 --//
    public Page() {
        this(DEFAULT_PAGE_SIZE);
    }

    public Page(int size) {
        this.pageSize = size;
    }

    public Page(int pageNo, int size) {
        this.pageSize = size;
        this.pageNo = pageNo;
    }

    // public Page(VPage<T> aVPage) {
    // this.pageNo = aVPage.getPageNo();
    // this.pageSize = aVPage.getPageSize();
    // this.totalCount = aVPage.getTotalCount();
    // // TODO:@@@这里需要copy出来
    // }

    // -- 分页参数访问函数 --//
    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    @Override
    public int getPageNo() {
        return this.pageNo;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    @Override
    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;

        if (pageNo < 1) {
            this.pageNo = 1;
        }
    }

    /**
     * 返回Page对象自身的setPageNo函数,可用于连续设置。
     */
    @Override
    public Pageable pageNo(final int thePageNo) {
        this.setPageNo(thePageNo);
        return this;
    }

    /**
     * 获得每页的记录数量, 默认为-1.
     */
    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * 设置每页的记录数量.
     */
    @Override
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 返回Page对象自身的setPageSize函数,可用于连续设置。
     */
    @Override
    public Pageable pageSize(final int thePageSize) {
        this.setPageSize(thePageSize);
        return this;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    @Override
    public int getFirst() {
        return ((this.pageNo - 1) * this.pageSize) + 1;
    }

    // /**
    // * 获得排序字段,无默认值. 多个排序字段时用','分隔.
    // */
    // public String getOrderBy() {
    // return orderBy;
    // }
    // /**
    // * 设置排序字段,多个排序字段时用','分隔.
    // */
    // public void setOrderBy(final String orderBy) {
    // this.orderBy = orderBy;
    // }

    // /**
    // * 返回Page对象自身的setOrderBy函数,可用于连续设置。
    // */
    // public Pageable orderBy(final String theOrderBy) {
    // this.setOrderBy(theOrderBy);
    // return this;
    // }

    // /**
    // * 获得排序方向, 无默认值.
    // */
    // public String getOrder() {
    // return order;
    // }

    // /**
    // * 设置排序方式向.
    // *
    // * @param order
    // * 可选值为desc或asc,多个排序字段时用','分隔.
    // */
    // public void setOrder(final String order) {
    // String lowcaseOrder = StringUtils.lowerCase(order);
    //
    // // 检查order字符串的合法值
    // String[] orders = StringUtils.split(lowcaseOrder, ',');
    // for (String orderStr : orders) {
    // if (!StringUtils.equals(DESC, orderStr) && !StringUtils.equals(ASC, orderStr)) {
    // throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
    // }
    // }
    //
    // this.order = lowcaseOrder;
    // }

    // /**
    // * 返回Page对象自身的setOrder函数,可用于连续设置。
    // */
    // public Page<T> order(final String theOrder) {
    // this.setOrder(theOrder);
    // return this;
    // }
    // /**
    // * 是否已设置排序字段,无默认值.
    // */
    // public boolean isOrderBySetted() {
    // return (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order));
    // }

    /**
     * 获得查询对象时是否先自动执行count查询获取总记录数, 默认为false.
     */
    @Override
    public boolean isAutoCount() {
        return this.autoCount;
    }

    /**
     * 设置查询对象时是否自动先执行count查询获取总记录数.
     */
    public void setAutoCount(final boolean autoCount) {
        this.autoCount = autoCount;
    }

    /**
     * 返回Page对象自身的setAutoCount函数,可用于连续设置。
     */
    public Pageable autoCount(final boolean theAutoCount) {
        this.setAutoCount(theAutoCount);
        return this;
    }

    // -- 访问查询结果函数 --//

    /**
     * 获得页内的记录列表.
     */
    @Override
    public List<T> getContent() {
        return this.result;
    }

    /**
     * 设置页内的记录列表.
     */
    @Override
    public void setContent(List result) {
        this.result = result;
    }

    /**
     * 获得总记录数, 默认值为-1.
     */

    @Override
    public long getTotalCount() {
        return this.totalCount;
    }

    /**
     * 设置总记录数.
     */
    @Override
    public void setTotalCount(final long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 根据pageSize与totalCount计算总页数, 默认值为-1.
     */

    @Override
    public long getTotalPages() {
        if (this.totalCount < 0) {
            return -1;
        }

        long count = this.totalCount / this.pageSize;
        if (this.totalCount % this.pageSize > 0) {
            count++;
        }
        return count;
    }

    /**
     * 是否还有下一页.
     */
    @Override
    public boolean isHasNext() {
        return (this.pageNo + 1 <= this.getTotalPages());
    }

    /**
     * 取得下页的页号, 序号从1开始. 当前页为尾页时仍返回尾页序号.
     */
    @Override
    public int getNextPage() {
        if (this.isHasNext()) {
            return this.pageNo + 1;
        }
        else {
            return this.pageNo;
        }
    }

    /**
     * 是否还有上一页.
     */
    @Override
    public boolean isHasPre() {
        return (this.pageNo - 1 >= 1);
    }

    /**
     * 取得上页的页号, 序号从1开始. 当前页为首页时返回首页序号.
     */
    @Override
    public int getPrePage() {
        if (this.isHasPre()) {
            return this.pageNo - 1;
        }
        else {
            return this.pageNo;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.pageNo).append("-").append(this.pageSize).append("-").append(this.totalCount);
        return builder.toString();
    }

}
