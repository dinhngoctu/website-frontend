package WS.BLG.utils;

import java.util.HashMap;

public class Utils {
    public static class HashMapValue{
        public static Integer findDictType(String key){
            HashMap<String, Integer> hashMap = new HashMap<>();
            hashMap.put("en-vi", 0);
            return hashMap.get(key);
        }
    }
}
