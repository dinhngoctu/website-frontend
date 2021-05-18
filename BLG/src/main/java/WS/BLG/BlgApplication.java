package WS.BLG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RefreshScope
@SpringBootApplication
@RestController
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
		GenericApplicationContext context = new GenericApplicationContext();
		appContext.refresh();
		System.out.println(dataSource);
        String value = env.getProperty("string.test.value");
		return new ResponseEntity<>(value, HttpStatus.OK);

	}

}
