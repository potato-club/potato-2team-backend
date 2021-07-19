package com.example.potato2teambackend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String createToken(Long memberId) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer("yerimkoko")
                    .withClaim("memberId", memberId)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new IllegalArgumentException("토큰이 생성이 실패하였습니다.");
        }
    }

}
