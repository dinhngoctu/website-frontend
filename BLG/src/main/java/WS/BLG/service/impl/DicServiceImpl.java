package WS.BLG.service.impl;

import WS.BLG.entities.WordEntity;
import WS.BLG.repository.posgres.DicRepository;
import WS.BLG.response.IBResponse;
import WS.BLG.service.DicService;
import WS.BLG.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class DicServiceImpl implements DicService {
    @Autowired
    DicRepository dicRepository;

    @Override
    public WordEntity translateByDB(String searchValue, String dict) {
        Long currentUserId = 0l;
        Integer typeDict = Utils.HashMapValue.findDictType(dict);
        Optional<WordEntity> optional = dicRepository.findWordsBySearchValueAndTypeDicAndUserId(searchValue, typeDict, currentUserId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            WordEntity wordEntity = new WordEntity();
            wordEntity.setUserId(currentUserId);
            wordEntity.setTypeDic(typeDict);
            wordEntity.setSearchValue(searchValue);
            wordEntity.setValue(translateWordApi(searchValue, dict));
            WordEntity result = dicRepository.save(wordEntity);
            return result;
        }
    }

    public String translateWordApi(String value, String dic) {
        String url = "https://api.us-south.language-translator.watson.cloud.ibm.com/instances/06b07380-b972-4b05-8ae6-bf896b1dc539/v3/translate?version=2018-05-01";
        String data = "{\"text\":[\"" + value + "\"],\"model_id\":\"" + dic + "\"}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        headers.add("Content-type", "application/json");
        headers.add("Authorization", "Basic YXBpa2V5Ok9CU29VTDFfMVdzaWMtVTBxRV9nU0tTdXVwQTZ0d2xHQ1FpUXNWVmNDOU5G");
        HttpEntity<?> entity = new HttpEntity<>(data, headers);
        ResponseEntity res = restTemplate.postForEntity(url, entity, IBResponse.class);
        return res.getBody().toString();
    }
}
