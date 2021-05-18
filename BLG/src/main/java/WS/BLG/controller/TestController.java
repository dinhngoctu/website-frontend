package WS.BLG.controller;

import WS.BLG.service.FluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.sql.DataSource;

@RestController
public class TestController {
    @Autowired
    FluxService fluxService;

    @GetMapping("/test-flux")
    public Flux<String> getNew() {
        return fluxService.getMessage();
    }
}
