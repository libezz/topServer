package topServer;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TopServerApplication {

	private final Logger logger = LoggerFactory.getLogger(TopServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TopServerApplication.class, args);
	}
	
	@PostConstruct
	public void postConstruct() {
		logger.warn("=======>server reStart<=======");
	}
}
