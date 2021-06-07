package WS.BLG.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TranslateRequest extends BaseRequest {
    String searchValue;
    String dict;
}
