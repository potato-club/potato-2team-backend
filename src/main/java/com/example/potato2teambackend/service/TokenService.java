package com.example.potato2teambackend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Slf4j
@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    private Date EXPIRED_TIME = new Date(System.currentTimeMillis() + 60 * 60 * 24);

    public String createToken(Long memberId) {
        try {;
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("yerimkoko")
                    .withClaim("memberId", memberId)
                    .withExpiresAt(EXPIRED_TIME)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new IllegalArgumentException("토큰 생성이 실패하였습니다.");
        }
    }


    public Long decodeToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            Long memberId = decodedJWT.getClaim("memberId").asLong();
            return memberId;
        } catch (JWTDecodeException exception) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }
    }

}
