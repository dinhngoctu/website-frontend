package WS.BLG;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@SpringBootApplication
@RestController
@Slf4j
public class BlgApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlgApplication.class, args);
    }
}
