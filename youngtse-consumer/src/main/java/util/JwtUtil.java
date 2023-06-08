package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

/**
 * @Title: JwtUtil
 * @Date 2023/5/17 21:59
 * @Author Youngtse
 * @Description: TODO
 */
public class JwtUtil {


    /**
     * 生成jwt
     * @param username
     * @param secretKey
     * @return
     */
    public static String generateToken(String username, String secretKey) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .signWith(getSigningKey(secretKey))
                .compact();
    }

    private static Key getSigningKey(String secretKey) {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    public static String generateSecretKey() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        byte[] secretKeyBytes = secretKey.getEncoded();
        return Base64.getEncoder().encodeToString(secretKeyBytes);
    }

    /**
     * 获取jwt中存储的username
     * @param token
     * @param secretKey
     * @return
     */
    public static String getUsername(String token, String secretKey) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(getSigningKey(secretKey))
                .build()
                .parseClaimsJws(token);
        String username = claimsJws.getBody().getSubject();
        return username;
    }

}
