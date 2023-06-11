package com.youngtse.common.util;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: RSAUtil
 * @Date 2023/5/30 21:56
 * @Author Youngtse
 */
public class RsaUtil {

    public static Map<String, String> keyPairGenerator() {
        // 使用RSA算法生成密钥对
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        keyPairGenerator.initialize(2048); // 设置密钥长度为2048位
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 获取公钥和私钥
        byte[] publicKey = keyPair.getPublic().getEncoded();
        byte[] privateKey = keyPair.getPrivate().getEncoded();

        String publicString = Base64.getEncoder().encodeToString(publicKey);
        String privateString = Base64.getEncoder().encodeToString(privateKey);

        System.out.println("公钥：" + publicString);
        System.out.println("私钥：" + privateString);

        Map<String, String> map = new HashMap<>();
        map.put("publicKey", publicString);
        map.put("privateKey", privateString);
        return map;
    }


    /**
     * 加密
     * @param publicKeyString base64编码的公钥
     * @param encryptText
     * @return base64编码后的加密数据
     */
    public static String encrypt(String publicKeyString, String encryptText) {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
        KeyFactory keyFactory = null;
        PublicKey publicKey = null;
        Cipher cipher = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] bytes = cipher.doFinal(encryptText.getBytes());
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     * @param privateKeyString base64编码的私钥
     * @param decryptText base64 加密的数据
     * @return
     */
    public static String decrypt(String privateKeyString, String decryptText) {
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
        KeyFactory keyFactory = null;
        PrivateKey privateKey = null;
        Cipher cipher = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(decryptText));
            return new String(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
