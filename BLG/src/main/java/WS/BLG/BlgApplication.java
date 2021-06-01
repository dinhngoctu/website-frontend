package WS.BLG;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RefreshScope
@SpringBootApplication
@RestController
@Slf4j
public class BlgApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlgApplication.class, args);
	}
	@Autowired
	DataSource dataSource;
	@Autowired
	Environment env;
	@Autowired
	private ConfigurableApplicationContext appContext;
	@GetMapping(value = "/test")
	public ResponseEntity<String> getPropertiesValue() {
		while (true) {
			log.info("log lặp");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return new ResponseEntity<>( HttpStatus.OK);
			}
		}
//		GenericApplicationContext context = new GenericApplicationContext();
//		appContext.refresh();
//		System.out.println(dataSource);
//        String value = env.getProperty("string.test.value");

	}

}
