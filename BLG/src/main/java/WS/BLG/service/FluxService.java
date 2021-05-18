package WS.BLG.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FluxService {
    String one_note = "one note";
    AtomicInteger num_status = new AtomicInteger(1);
    AtomicInteger num2 = new AtomicInteger(1);

    public Flux<String> getMessage() {
        System.out.println("-----------------"+num2.incrementAndGet());
        return Flux.generate((SynchronousSink<String> synk) -> synk.next(one_note +num_status.incrementAndGet())).delayElements(Duration.ofSeconds(2));
    }
}
