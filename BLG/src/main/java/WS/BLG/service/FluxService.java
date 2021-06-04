package WS.BLG.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.nio.charset.StandardCharsets;
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

    public String translateWordApi(String value, String dic) {
        String url = "https://api.us-south.language-translator.watson.cloud.ibm.com/instances/06b07380-b972-4b05-8ae6-bf896b1dc539/v3/translate?version=2018-05-01";
        String data = "{\"text\":[\""+value+"\"],\"model_id\":\""+dic+"\"}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        headers.add("Content-type", "application/json");
        headers.add("Authorization", "Basic YXBpa2V5Ok9CU29VTDFfMVdzaWMtVTBxRV9nU0tTdXVwQTZ0d2xHQ1FpUXNWVmNDOU5G");
        HttpEntity<?> entity = new HttpEntity<>(data,headers);
        ResponseEntity res = restTemplate.postForEntity(url, entity, String.class);
        return res.getBody().toString();
    }

}
