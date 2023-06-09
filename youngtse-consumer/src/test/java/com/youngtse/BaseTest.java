package com.youngtse;


import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Title: BaseTest
 * @Date 2023/5/24 0:27
 * @Author Youngtse
 */
public class BaseTest {
    @Test
    public void passwordEncoderTest() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);

    }
}
