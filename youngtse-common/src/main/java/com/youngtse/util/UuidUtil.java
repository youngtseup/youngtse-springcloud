package com.youngtse.util;

import java.util.UUID;

/**
 * @Title: UuidUtil
 * @Date 2023/5/13 2:19
 * @Author Youngtse
 * @Description: TODO
 */
public class UuidUtil {

    public static String randomUUID36() {
        return UUID.randomUUID().toString();
    }

    public static String randomUUID32() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
