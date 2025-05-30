package poc.ncpdp.parser.segments.concerns;

import java.util.HashMap;
import java.util.Map;

/**
 * Parser interface for parsing NCPDP segments.
 */
public interface Parser {
    /**
     * Parses a raw NCPDP segment string into a map of field identifiers and their
     * corresponding values.
     * 
     * -Avoids regex engine overhead.
     * -Only one pass through the string.
     * -No intermediate array allocation.
     * 
     * For small strings, the difference is negligible. For large NCPDP
     * messages, this manual approach is more efficient and gives more control.
     *
     * @param source the raw segment string to parse
     * @return a map where keys are field identifiers and values are the
     *         corresponding field values
     */
    static Map<String, String> parse(String source) {
        Map<String, String> segmentHash = new HashMap<>();
        int len = source.length();
        int start = 0;
        for (int i = 0; i < len; i++) {
            char c = source.charAt(i);
            if (c == 0x1C || c == 0x1E || c == 0x03 || c == 0x1D) { // delimiters
                if (i > start + 2) {
                    String key = source.substring(start, start + 2);
                    String value = source.substring(start + 2, i);
                    segmentHash.put(key, value);
                }
                start = i + 1;
            }
        }
        // Handle last segment (if not followed by delimiter)
        if (start < len - 2) {
            String key = source.substring(start, start + 2);
            String value = source.substring(start + 2);
            segmentHash.put(key, value);
        }
        return segmentHash;
    }
}
