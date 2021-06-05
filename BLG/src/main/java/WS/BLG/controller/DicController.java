package WS.BLG.controller;

import WS.BLG.entities.WordEntity;
import WS.BLG.request.TranslateRequest;
import WS.BLG.service.DicService;
import WS.BLG.service.core.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/dict")
public class DicController {
    @Autowired
    DicService dicService;
    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping(value = "/translate")
    public ResponseEntity<?> translate(@RequestBody TranslateRequest request, BindingResult bindingResult) {
        ResponseEntity checkResult = mapValidationErrorService.getError(bindingResult);
        if (null != checkResult) {
            return checkResult;
        }
        if (StringUtils.isEmpty(request.getSearchValue()) || StringUtils.isEmpty(request.getDict())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        WordEntity wordEntity = dicService.translateByDB(request.getSearchValue(), request.getDict());
        return new ResponseEntity<>(wordEntity, HttpStatus.OK);
    }
}
