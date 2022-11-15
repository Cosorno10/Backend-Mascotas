package shared.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Encrypt {

	private String secret = "M@agnobyDem4nd";
	private int iterations = 2000;  // number of hash iteration
	private int hashWidth = 256;      // hash width in bits
	private final Pbkdf2PasswordEncoder encoder = new Pbkdf2PasswordEncoder(secret, iterations, hashWidth);

	public Encrypt() {
		encoder.setEncodeHashAsBase64(true);
	}

	public String enc(String src) {
		return encoder.encode(src);
	}

	public boolean validate(String src, String encrypt) {
		return encoder.matches(src, encrypt);
	}
}
