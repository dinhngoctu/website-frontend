package WS.BLG.service.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {
    public ResponseEntity<?> getError(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach(e -> {
                map.put(e.getField(), e.getDefaultMessage());
            });
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
