package com.insightsphere.blogapp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtility {

private static final String SECRET_KEY = "aksdbdd3873873#%^FWEFSF$T$#GESF@!@R$R$R%DFEG^Ydawtwefst$^&*$eewfsefddr@#rr523R32f$t3566WDFSDGRGR@#NSAFHL^^SRNSEFHALDJASLJD#RFSDBKJFBKJSDFi&^*&**%557AS*SADFFNFBhjasfhnsdnHhHhLDHASLKHDME7329846YQY4";
private static final long EXPIRATION_TIME = 1000 * 60 * 60;

private Key getSigningKey(){
    return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
}

public String generateToken(UserDetails userDetails){
    return Jwts.builder()
            .subject(userDetails.getUsername())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(getSigningKey())
            .compact();
}
    
}
