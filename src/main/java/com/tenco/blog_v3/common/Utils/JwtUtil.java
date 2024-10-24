package com.tenco.blog_v3.common.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tenco.blog_v3.user.User;

import java.util.Date;

/**
 * JWT 토큰의 생성 및 검증을 위한 유틸 글래스 이다.
 * 여기서는 알고리즘 HMAC512 알고리즘을 사용한다.
 */
public class JwtUtil {
    /**
     * 주어진 사용자 정보(USER)로 JWT 토큰을 생성한다.
     *
     * @param user
     * @return 생성된 JWT String
     */
    public static String create(User user){

        return JWT.create()
                .withSubject("blog")
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                // 서명
                .sign(Algorithm.HMAC256("tencoding"));
    }

    public static User verify(String token){

        // JWT 디코딩
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("tencoding"))
                .build()
                .verify(token);

        // 검증된 JWT에서 사용자 ID와 이름 추출 해보자.
        int id = decodedJWT.getClaim("id").asInt();
        String username = decodedJWT.getClaim("username").asString();

        return User.builder().id(id).username(username).build();
    }

}
