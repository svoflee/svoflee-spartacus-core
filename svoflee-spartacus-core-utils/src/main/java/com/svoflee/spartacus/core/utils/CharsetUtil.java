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

package com.svoflee.spartacus.core.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import com.svoflee.spartacus.core.log.Logger;

/**
 * CharsetUtil 是
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class CharsetUtil {

    protected static final Logger log = Logger.getLogger(CharsetUtil.class);

    public static String tranEncodeTOGB2312(String str) {
        try {
            String strEncode = CharsetUtil.getEncoding(str);
            String temp = new String(str.getBytes(strEncode), "GB2312");
            return temp;
        }
        catch (IOException ex) {
            return null;
        }
    }

    public static String tranUTF8TOGB2312(String str) {
        try {
            String temp = new String(str.getBytes("UTF-8"), "GB2312");
            return temp;
        }
        catch (java.io.IOException ex) {
            return null;
        }
    }

    public static String tranEncodeTOGB18030(String str) {
        try {
            String strEncode = CharsetUtil.getEncoding(str);
            String temp = new String(str.getBytes(strEncode), "GB2312");
            return temp;
        }
        catch (java.io.IOException ex) {
            return null;
        }
    }

    public static String getEncodeString(byte[] bytes, String encode) {
        try {
            String temp = new String(bytes, encode);
            return temp;
        }
        catch (java.io.IOException ex) {
            return null;
        }
    }

    public static String getGB2312String(byte[] bytes) {
        return getEncodeString(bytes, "gb2312");
    }

    public static String getGB18030String(byte[] bytes) {
        return getEncodeString(bytes, "gb18030");
    }

    public static String getUTF8String(byte[] bytes) {
        return getEncodeString(bytes, "UTF-8");
    }

    public static String tranEncodeTOUTF8(String str) {
        try {
            String strEncode = CharsetUtil.getEncoding(str);
            String temp = new String(str.getBytes(strEncode), "UTF-8");
            return temp;
        }
        catch (java.io.IOException ex) {

            return null;
        }
    }

    public static boolean isGB2312(char c) {

        return Charset.forName("GB2312").newEncoder().canEncode(c);
    }

    public static String getEncoding(String str) {
        String encodeValue = "";
        String[] encode = { "GB2312", "GB18030", "ISO-8859-1", "UTF-8", "GBK", "ASCII", "BIG5", "UCS" };
        for (String element : encode) {
            encodeValue = element;
            boolean canPaser = Charset.forName(encodeValue).newEncoder().canEncode(str);
            if (canPaser) {
                break;
            }
        }
        return encodeValue;
    }

}
