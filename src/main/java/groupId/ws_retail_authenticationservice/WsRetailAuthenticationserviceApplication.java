package groupId.ws_retail_authenticationservice;

import groupId.ws_retail_authenticationservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(User.class)
@Slf4j
public class WsRetailAuthenticationserviceApplication implements CommandLineRunner {

	public WsRetailAuthenticationserviceApplication(User user) {
		this.user = user;
	}

	public static void main(String[] args) {
		SpringApplication.run(WsRetailAuthenticationserviceApplication.class, args);
	}

	private User user;


	@Override
	public void run(String... args) throws Exception {
		log.info("Username:"+user.getUsername());
		log.info("Password:"+user.getPassword());
	}
}
