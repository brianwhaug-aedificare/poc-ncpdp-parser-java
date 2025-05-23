package poc.ncpdp.parser.segments.concerns;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public interface Serializer {
    // Serializes instance to string
    static String toString(Map<String, Object> hash) {
        String string = hash.entrySet().stream()
                .map(e -> e.getKey() + String.valueOf(e.getValue()))
                .collect(Collectors.joining("\u001C"));
        return "\u001C" + string + "\u001E";
    }

    // Returns a hash as JSON-like map (optionally with readable keys)
    static Map<String, Object> toJson(Map<String, Object> hash, Map<String, String> fieldIdToSymbol, boolean readable) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : hash.entrySet()) {
            String key = entry.getKey();
            String readableKey = readable && fieldIdToSymbol.containsKey(key) ? fieldIdToSymbol.get(key) : key;
            result.put(readableKey, entry.getValue());
        }
        return result;
    }
}
