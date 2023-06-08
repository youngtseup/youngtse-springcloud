package com.youngtse.consumer.config.kaptcha;

import com.google.code.kaptcha.NoiseProducer;
import com.google.code.kaptcha.util.Configurable;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Title: KaptchNoiseConfig
 * @Date 2023/5/11 23:54
 * @Author Youngtse
 * @Description: TODO
 */
public class KaptchNoiseConfig extends Configurable implements NoiseProducer {
    @Override
    public void makeNoise(BufferedImage image, float factorOne, float factorTwo, float factorThree, float factorFour) {
        int width = image.getWidth();
        int height = image.getHeight();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        // 设置RenderingHints来改善图像质量
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // 设置干扰线的颜色
        graphics.setColor(new Color(83, 133, 31));

        // 添加干扰线
        for (int i = 0; i < 2; i++) {
            int x1 = (int) (Math.random() * width);
            int y1 = (int) (Math.random() * height);
            int x2 = (int) (Math.random() * width);
            int y2 = (int) (Math.random() * height);

            graphics.drawLine(x1, y1, x2, y2);
        }

        graphics.dispose();
    }
}
