package com.github.brunoonofre64.infra.security;


import org.springframework.stereotype.Component;


@Component
public class JwtUtil {

//    @Value("${jwt.secret}")
//    private String secret;
//
//    public String generateToken(UserEntity userEntity) {
//        Algorithm algorithm = Algorithm.HMAC256(secret);
//        return JWT.create()
//                .withSubject(userEntity.getEmail())
//                .withClaim("roles", userEntity.getRoles().stream()
//                        .map(RoleEntity::getRoleName).collect(Collectors.toList()))
//                .sign(algorithm);
//    }
}

