package WS.BLG.controller;

import WS.BLG.entities.BLGModel;
import WS.BLG.repository.MongoCRepo;
import WS.BLG.service.FluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TestController {
    @Autowired
    FluxService fluxService;
    @Autowired
    MongoCRepo mongoCRepo;

    @GetMapping("/test-flux")
    public Flux<String> getNew() {
        return fluxService.getMessage();
    }
    @GetMapping("/test-mongo")
    public Object getMongo() {
        return mongoCRepo.findAll();
    }

    @PostMapping("/test-mongo")
    public ResponseEntity<?> postObject(@RequestBody BLGModel obj) {
        BLGModel res = mongoCRepo.save(obj);
        return new ResponseEntity<Object>(res, HttpStatus.OK);
    }
}
