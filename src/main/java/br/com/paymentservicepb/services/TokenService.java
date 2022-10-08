package br.com.paymentservicepb.services;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
