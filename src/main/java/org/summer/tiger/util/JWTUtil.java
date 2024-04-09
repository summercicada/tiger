package org.summer.tiger.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.summer.tiger.pojo.UserJWT;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class JWTUtil {

    private final static String tokenSecret = "1234123412341234123412341234123412341234123412341234123412341234";

    public static String createToken(UserJWT userJwt) {
        SecretKey secretKey = new SecretKeySpec(tokenSecret.getBytes(), Jwts.SIG.HS256.getId());
        return Jwts.builder()
                .subject(userJwt.toJson())
                .signWith(secretKey)
                .compact();
    }


    public static void main(String[] args) {
        System.out.println(createToken(UserJWT.builder().username("hello").build()));
    }
}
