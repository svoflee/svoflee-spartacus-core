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

import java.security.MessageDigest;

import com.svoflee.spartacus.core.log.Logger;

/**
 * ShortUrl 是短地址连接的工具类
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class ShortUrl {

    private static final Logger log = Logger.getLogger(ShortUrl.class.getName());

    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (byte element : b) {
            resultSb.append(byteToHexString(element));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin) {
        String resultString = null;
        try {

            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");

            resultString.trim();

            resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
        }
        catch (Exception ex) {
        }
        return resultString;
    }

    // public static void main(String[] args) {
    //
    // String data = "189022881112011111118:09sz0000123456789987654321";
    // System.out.println(MD5Encode(data));
    // }

    public static void main(String[] args) {
        String url1 = "http://www.sunchis.com";
        String url2 = "http://www.sunchis.com ";

        // for (String string : ShortText(url)) {
        // print(string);
        // }
        U.p(getOneShotText(url1));
        U.p(getOneShotText(url2));

    }

    public static String getOneShotText(String longText) {
        return ShortText(longText)[0];
    }

    public static String[] ShortText(String string) {
        String key = "svoflee"; // 自定义生成MD5加密字符串前的混合KEY
        String[] chars = new String[] { // 要使用生成URL的字符
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

        String hex = MD5Encode(key + string.trim());
        int hexLen = hex.length();
        int subHexLen = hexLen / 8;
        String[] ShortStr = new String[4];

        for (int i = 0; i < subHexLen; i++) {
            String outChars = "";
            int j = i + 1;
            String subHex = hex.substring(i * 8, j * 8);
            long idx = Long.valueOf("3FFFFFFF", 16) & Long.valueOf(subHex, 16);

            for (int k = 0; k < 6; k++) {
                int index = (int) (Long.valueOf("0000003D", 16) & idx);
                outChars += chars[index];
                idx = idx >> 5;
            }
            ShortStr[i] = outChars;
        }

        return ShortStr;
    }

    private static void print(Object messagr) {
        System.out.println(messagr);
    }

}
