/*
 * Copyright (c)  http://www.svoflee.com All rights reserved.
 *  
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
 *       
 */

package com.svoflee.spartacus.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import com.svoflee.spartacus.core.utils.security.MD5Utils;

/**
 * U 是各种无法分类的帮助方法的工具类
 * 
 * @author <a href="mailto:svoflee@gmail.com">svoflee@gmail.com</a>
 * @since 1.0.0
 * @version 1.0.0
 */
public final class U {

    /**
     * 返回classpath路径的文件Resource 的InputStream
     */
    public static InputStream getClasspathResourceAsStream(String filename) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
        return is;
    }

    /**
     * 通过数字，对应一个字母0-A,28-AB
     * 
     * @param number
     * @return
     */
    public static String selectLetter(int number) {
        String result = "";
        if (number == 0) {
            result = "A";
        }
        else if (number == 1) {
            result = "B";
        }
        else if (number == 2) {
            result = "C";
        }
        else if (number == 3) {
            result = "D";
        }
        else if (number == 4) {
            result = "E";
        }
        else if (number == 5) {
            result = "F";
        }
        else if (number == 6) {
            result = "G";
        }
        else if (number == 7) {
            result = "H";
        }
        else if (number == 8) {
            result = "I";
        }
        else if (number == 9) {
            result = "J";
        }
        else if (number == 10) {
            result = "K";
        }
        else if (number == 11) {
            result = "L";

        }
        else if (number == 12) {
            result = "M";
        }
        else if (number == 13) {
            result = "N";
        }
        else if (number == 14) {
            result = "O";
        }
        else if (number == 15) {
            result = "P";
        }
        else if (number == 16) {
            result = "Q";
        }
        else if (number == 17) {
            result = "R";
        }
        else if (number == 18) {
            result = "S";
        }
        else if (number == 19) {
            result = "T";
        }
        else if (number == 20) {
            result = "U";
        }
        else if (number == 21) {
            result = "V";
        }
        else if (number == 22) {
            result = "W";
        }
        else if (number == 23) {
            result = "X";
        }
        else if (number == 24) {
            result = "Y";
        }
        else if (number == 25) {
            result = "Z";
        }
        return result;
    }

    public static String getColumnNameString(int colNum) {
        String result = "";
        int loop = colNum / 26;
        int next = colNum % 26;
        for (int i = 0; i < loop; i++) {
            result = result + selectLetter(loop - 1);
        }
        result = result + selectLetter(next);
        return result;
    }

    /**
     * 判断是否是基本类型
     * 
     * @param type
     * @return
     */
    public static boolean isPrimitive(Class<?> type) {
        return type.isPrimitive() || (type == String.class) || (type == Character.class) || (type == Boolean.class)
                || (type == Byte.class) || (type == Short.class) || (type == Integer.class) || (type == Long.class)
                || (type == Float.class) || (type == Double.class) || (type == Object.class);
    }

    /**
     * 当读取 e 时，退出当前线程
     */
    public static void readExit() {
        String exit = "e";
        String readString = "";
        byte b[] = new byte[255];
        try {
            U.p("Input [e] for exit:");
            System.in.read(b);
            readString = new String(b).trim();

            while (!readString.equalsIgnoreCase(exit)) {
                U.p("Input [e] for exit:");
                System.in.read(b);
                readString = new String(b).trim();
            }
        }
        catch (IOException e) {
            U.p(e);
        }
    }

    /**
     * 用简单的打印，简化输出
     * 
     * @param o
     */
    public static void p(Object o) {
        if (o instanceof Iterable) {
            ps((Iterable) o);
        }
        else {
            System.out.println(o);
        }
    }

    public static void ps(Object... os) {
        for (Object o : os) {
            p(o);
        }
    }

    public static void ps(Iterable os) {
        for (Object o : os) {
            p(o);
        }
    }

    /**
     * 创建处理的标识码
     * 
     * @return
     */
    public static String buildOpVersion() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    /**
     * 构造数据的唯一指纹,采用MD5算法
     * 
     * @param rawRowFingerPrint
     * @return
     */
    public static String buildFingerPrint(Object rawRowFingerPrint) {
        return MD5Utils.getMd5String(rawRowFingerPrint.toString());
    }

    public static void main(String[] args) {
        U.readExit();
    }

}
