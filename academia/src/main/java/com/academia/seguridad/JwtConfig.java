package academia.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

@Configuration
public class JwtConfig{
	
	@Bean
	public SecretKey secretKey() {
		return Keys.secretKeyFor(SignatureAlgorithm.HS256);
	}
	
}