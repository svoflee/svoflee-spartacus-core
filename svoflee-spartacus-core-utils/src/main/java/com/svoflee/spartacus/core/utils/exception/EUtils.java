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

package com.svoflee.spartacus.core.utils.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.svoflee.spartacus.core.log.Logger;

/**
 * EUtils 是异常工具方法
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public abstract class EUtils {

    private final static Logger log = Logger.getLogger(EUtils.class);

    private static final String notSupporttedException = "Not Supported In Version:";

    public static AppException notSupportedException(String version) {
        return new AppException(notSupporttedException + version, new UnsupportedOperationException());
    }

    /**
     * 抛出不支持的异常
     * 
     * @param version
     */
    public static void throwNotSupportedException(Object version) {
        // AppException appEx = AppException.notSupportedException(version.toString());
        throw notSupportedException(version.toString());
    }

    /**
     * 抛出不支持的异常
     * 
     * @param version
     */
    public static void throwNotSupportedException() {
        throw notSupportedException(" ALL Version ");
    }

    public static void throwRuntimeException(Throwable ex, String msgKey, String... args) {
        String message = getMessageFromMsgKey(msgKey, args);
        AppException appEx = new AppException(message + "@" + ex.getMessage(), ex);
        // appEx.setRootCause(ex);
        // appEx.setMessageKey(msgKey);
        // appEx.setMessageArgs(args);
        // appEx.setMessage(message);
        // Class aThrowableClass = appEx.getClass();
        // if (ex != null) {
        // aThrowableClass = ex.getClass();
        // }
        // log.error(aThrowableClass + "   " + msgKey);
        throw appEx;
    }

    private static String getMessageFromMsgKey(String msgKey, String... args) {
        // TODO:@@@异常通过资源文件获取文本
        String message = msgKey;
        // try {
        // message = I18nHelper.getMessage(msgKey, args);
        // }
        // catch (NoSuchMessageException e) {
        // // e.printStackTrace();
        // }
        return message;
    }

    public static void throwDefaultRuntimeException(Throwable e) {
        throwRuntimeException(e, AppException.messageKey, null);
    }

    public static void throwDefaultRuntimeException(String msg) {
        throwRuntimeException(null, msg, null);
    }

    public static void throwRuntimeException(Throwable ex, String msgKey) {
        throwRuntimeException(ex, msgKey, null);
    }

    public static void throwRuntimeException(String msgKey) {
        throwRuntimeException(null, msgKey, null);
    }

    public static void throwRuntimeException(String msgKey, String... args) {
        throwRuntimeException(null, msgKey, args);
    }

    public static void throwRuntimeException(Throwable ex) {
        throwRuntimeException(ex, null, null);
    }

    /**
     * 将CheckedException转换为UncheckedException.
     */
    public static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException) {
            return (RuntimeException) e;
        }
        else {
            return new AppException(e);
        }
    }

    /**
     * 将ErrorStack转化为String.
     */
    public static String getStackTraceAsString(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

}
