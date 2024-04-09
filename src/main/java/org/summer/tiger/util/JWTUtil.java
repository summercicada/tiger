package org.summer.tiger.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.summer.tiger.pojo.UserJWT;

public class JWTUtil {

    private final static String tokenSecret = "1234123412341234123412341234123412341234123412341234123412341234";

    public static String createToken(UserJWT userJwt) {
        return Jwts.builder().subject(userJwt.toJson()).signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(tokenSecret))).compact();
    }


    public static void main(String[] args) {
        System.out.println(createToken(null));
    }
}
