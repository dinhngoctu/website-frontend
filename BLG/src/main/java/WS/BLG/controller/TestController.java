package WS.BLG.controller;

import WS.BLG.entities.BLGModel;
//import WS.BLG.repository.MongoCRepo;
import WS.BLG.service.FluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

@RestController
public class TestController {
    @Autowired
    FluxService fluxService;
//    @Autowired
//    MongoCRepo mongoCRepo;
    @Autowired

    @GetMapping("/test-flux")
    public String getNew() {
        AtomicReference<String> str = new AtomicReference<>("");
        Flux<String> result = fluxService.getMessage();
        result.subscribe(e ->{
            str.set(e);
        });
        return str.get();
    }

//    @GetMapping("/test-trans/{value}/{dic}")
//    public String testTrans(@PathVariable String value,@PathVariable String dic ) {
//        return fluxService.translateWordApi(value,dic);
//    }
//    @GetMapping("/test-mongo")
//    public Object getMongo() {
//        return mongoCRepo.findAll();
//    }

//    @PostMapping("/test-mongo")
//    public ResponseEntity<?> postObject(@RequestBody BLGModel obj) {
////        BLGModel res = mongoCRepo.save(obj);
//        return new ResponseEntity<Object>(res, HttpStatus.OK);
//    }
}
