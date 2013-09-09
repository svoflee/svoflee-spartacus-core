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

package com.svoflee.spartacus.core.log;

import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 * 对SLF4J的封装，为了扩展日志收集处理
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class Logger {

    private final org.slf4j.Logger logger;

    /** Logging framework configuration file path. */
    // public final static String LOGGING_CONFIGURATION_FILE_PATH = "/WEB-INF/config/log.xml";

    /**
	 *
	 */
    private Logger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    public static Logger getLogger(String name) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(name);
        return new Logger(logger);
    }

    @SuppressWarnings("rawtypes")
    public static Logger getLogger(Class clazz) {
        org.slf4j.Logger logger = LoggerFactory.getLogger(clazz);
        return new Logger(logger);
    }

    public void debug(String msg) {
        logger.debug(msg);
    }

    public void debug(String msg, Throwable thrown) {
        logger.debug(msg, thrown);
    }

    public void error(String msg) {
        logger.error(msg);
    }

    public void error(String msg, Throwable thrown) {
        logger.error(msg, thrown);
    }

    public void info(String msg) {
        logger.info(msg);
    }

    public void info(String msg, Throwable thrown) {
        logger.info(msg, thrown);
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    public void trace(String msg) {
        logger.trace(msg);
    }

    public void trace(String msg, Throwable thrown) {
        logger.trace(msg, thrown);
    }

    public void warn(String msg) {
        logger.warn(msg);
    }

    public void warn(String msg, Throwable thrown) {
        logger.warn(msg, thrown);
    }

    public String getName() {
        return logger.getName();
    }

    public void trace(String format, Object... argArray) {
        logger.trace(format, argArray);
    }

    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    public void trace(Marker marker, String msg) {
        logger.trace(marker, msg);

    }

    public void trace(Marker marker, String format, Object... argArray) {
        logger.trace(marker, format, argArray);

    }

    public void trace(Marker marker, String msg, Throwable t) {
        logger.trace(marker, msg, t);

    }

    public void debug(String format, Object... argArray) {
        logger.debug(format, argArray);

    }

    public boolean isDebugEnabled(Marker marker) {
        return logger.isDebugEnabled(marker);
    }

    public void debug(Marker marker, String msg) {
        logger.debug(marker, msg);

    }

    public void debug(Marker marker, String format, Object... args) {
        logger.debug(marker, format, args);
    }

    public void debug(Marker marker, String msg, Throwable t) {
        logger.debug(marker, msg, t);
    }

    public void info(String format, Object arg) {
        logger.info(format, arg);
    }

    public void info(String format, Object... argArray) {
        logger.info(format, argArray);
    }

    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    public void info(Marker marker, String msg) {
        logger.info(marker, msg);
    }

    public void info(Marker marker, String format, Object... argArray) {
        logger.info(marker, format, argArray);
    }

    public void info(Marker marker, String msg, Throwable t) {
        logger.info(marker, msg, t);

    }

    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public void warn(String format, Object... argArray) {
        logger.warn(format, argArray);
    }

    public boolean isWarnEnabled(Marker marker) {
        return logger.isWarnEnabled(marker);
    }

    public void warn(Marker marker, String msg) {
        logger.warn(marker, msg);
    }

    public void warn(Marker marker, String format, Object... argArray) {
        logger.warn(marker, format, argArray);
    }

    public void warn(Marker marker, String msg, Throwable t) {
        logger.warn(marker, msg, t);
    }

    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    public void error(String format, Object... argArray) {
        logger.error(format, argArray);

    }

    public boolean isErrorEnabled(Marker marker) {
        return logger.isErrorEnabled(marker);
    }

    public void error(Marker marker, String msg) {
        logger.error(marker, msg);
    }

    public void error(Marker marker, String format, Object... argArray) {
        logger.error(marker, format, argArray);
    }

    public void error(Marker marker, String msg, Throwable t) {
        logger.error(marker, msg, t);

    }
}
