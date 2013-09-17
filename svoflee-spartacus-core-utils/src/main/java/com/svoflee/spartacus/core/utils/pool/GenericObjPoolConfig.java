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

package com.svoflee.spartacus.core.utils.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * GenericObjPoolConfig 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class GenericObjPoolConfig extends GenericObjectPoolConfig {

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxTotal() {
        return super.getMaxTotal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxTotal(int maxTotal) {
        super.setMaxTotal(maxTotal);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxIdle() {
        return super.getMaxIdle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxIdle(int maxIdle) {
        super.setMaxIdle(maxIdle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinIdle() {
        return super.getMinIdle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMinIdle(int minIdle) {
        super.setMinIdle(minIdle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericObjectPoolConfig clone() {
        return super.clone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getLifo() {
        return super.getLifo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLifo(boolean lifo) {
        super.setLifo(lifo);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getMaxWaitMillis() {
        return super.getMaxWaitMillis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxWaitMillis(long maxWaitMillis) {
        super.setMaxWaitMillis(maxWaitMillis);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getMinEvictableIdleTimeMillis() {
        return super.getMinEvictableIdleTimeMillis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
        super.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getSoftMinEvictableIdleTimeMillis() {
        return super.getSoftMinEvictableIdleTimeMillis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSoftMinEvictableIdleTimeMillis(long softMinEvictableIdleTimeMillis) {
        super.setSoftMinEvictableIdleTimeMillis(softMinEvictableIdleTimeMillis);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumTestsPerEvictionRun() {
        return super.getNumTestsPerEvictionRun();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
        super.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getTestOnBorrow() {
        return super.getTestOnBorrow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTestOnBorrow(boolean testOnBorrow) {
        super.setTestOnBorrow(testOnBorrow);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getTestOnReturn() {
        return super.getTestOnReturn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTestOnReturn(boolean testOnReturn) {
        super.setTestOnReturn(testOnReturn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getTestWhileIdle() {
        return super.getTestWhileIdle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTestWhileIdle(boolean testWhileIdle) {
        super.setTestWhileIdle(testWhileIdle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTimeBetweenEvictionRunsMillis() {
        return super.getTimeBetweenEvictionRunsMillis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        super.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEvictionPolicyClassName() {
        return super.getEvictionPolicyClassName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEvictionPolicyClassName(String evictionPolicyClassName) {
        super.setEvictionPolicyClassName(evictionPolicyClassName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getBlockWhenExhausted() {
        return super.getBlockWhenExhausted();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBlockWhenExhausted(boolean blockWhenExhausted) {
        super.setBlockWhenExhausted(blockWhenExhausted);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getJmxEnabled() {
        return super.getJmxEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setJmxEnabled(boolean jmxEnabled) {
        super.setJmxEnabled(jmxEnabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getJmxNamePrefix() {
        return super.getJmxNamePrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setJmxNamePrefix(String jmxNamePrefix) {
        super.setJmxNamePrefix(jmxNamePrefix);
    }

}
