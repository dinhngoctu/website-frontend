package WS.BLG.service;

import WS.BLG.entities.WordEntity;

public interface DicService {
    WordEntity translateByDB(String searchValue, String dict);
}
