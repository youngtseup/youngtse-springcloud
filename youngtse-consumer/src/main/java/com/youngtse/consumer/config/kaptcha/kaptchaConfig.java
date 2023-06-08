package com.youngtse.consumer.config.kaptcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Title: kaptchaConfig
 * @Date 2023/5/11 23:43
 * @Author Youngtse
 * @Description: TODO
 */
@Configuration
public class kaptchaConfig {
    @Bean
    public DefaultKaptcha captchaProducer() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();

        // 设置验证码图片的宽度
        properties.setProperty("kaptcha.image.width", "200");
        // 设置验证码图片的高度
        properties.setProperty("kaptcha.image.height", "50");
        // 设置边框颜色为透明
        properties.setProperty("kaptcha.border.color", "0,0,0,0");
        // 设置背景渐变的起始颜色
        properties.setProperty("kaptcha.textproducer.font.color", "255,255,255");
        // 设置背景渐变的起始颜色
        properties.setProperty("kaptcha.background.clear.from", "182,220,142");
        // 设置背景渐变的结束颜色
        properties.setProperty("kaptcha.background.clear.to", "182,220,142");
        // 设置验证码文本字符长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 设置干扰线实现类为自定义的类
        properties.setProperty("kaptcha.noise.impl", "com.youngtse.consumer.config.kaptcha.KaptchNoiseConfig");

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}
