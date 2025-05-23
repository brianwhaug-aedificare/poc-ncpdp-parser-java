package poc.ncpdp.parser.segments.concerns;

import java.util.HashMap;
import java.util.Map;

/**
 * Parser interface for parsing NCPDP segments.
 * This interface provides a method to parse a raw string source into a map of key-value pairs.
 * The map will contain the field identifier as the key and the field value as the value.
 * Example: DE = 20070915
 */
public interface Parser {
    static Map<String, String> parse(String source) {
        String[] elements = source.split("[\u001C\u001E\u0003\u001D]");
        Map<String, String> segmentHash = new HashMap<>();
        for (String e : elements) {
            if (!e.isEmpty() && e.length() > 2) {
                String key = e.substring(0, 2);
                String value = e.substring(2);
                segmentHash.put(key, value);
            }
        }
        return segmentHash;
    }
}
