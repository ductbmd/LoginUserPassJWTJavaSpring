package auth.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import auth.simple.config.AppProperties;



@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class AuthUserpassJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthUserpassJwtApplication.class, args);
	}
	
}
