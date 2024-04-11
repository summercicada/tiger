package org.summer.tiger.util;

import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.summer.tiger.pojo.UserJWT;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JWTUtil {

    private final static String tokenSecret = "1234123412341234123412341234123412341234123412341234123412341234";
    private static SecretKey secretKey = Keys.hmacShaKeyFor(tokenSecret.getBytes(StandardCharsets.UTF_8));

    public static String createToken(UserJWT userJwt) {


        return Jwts.builder()
                .subject(userJwt.toJson())
                .claim("username", "hans xiao")
                .claim("age", 100)
                .issuedAt(new Date())
                .signWith(secretKey)
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .notBefore(new Date())
                .compact();
    }


    public static Object enToken(String tokenSecret) {
        Object payload = Jwts.parser().verifyWith(secretKey).build().parse(tokenSecret).getPayload();
        return payload;
    }


    public static void main(String[] args) {
        System.out.println(createToken(UserJWT.builder().username("hello").build()));
    }
}
