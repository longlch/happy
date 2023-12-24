package happy.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {
     String extractUsername(String token);
    String generateToken(UserDetails userDetails);

    String generateRefreshToken(UserDetails userDetails, long refreshExpiration);
    boolean isTokenValid(String token, UserDetails userDetails);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

}
