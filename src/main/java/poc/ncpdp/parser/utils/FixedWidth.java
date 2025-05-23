package poc.ncpdp.parser.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class FixedWidth {
    public static Map<String, String> parseFixedWidth(Map<String, Integer> fields, String string) {
        Map<String, String> result = new LinkedHashMap<>();
        int pos = 0;
        for (Map.Entry<String, Integer> entry : fields.entrySet()) {
            int size = entry.getValue();
            String value = string.substring(pos, Math.min(pos + size, string.length()));
            result.put(entry.getKey(), value);
            pos += size;
        }
        return result;
    }

    public static String toFixedWidth(Map<String, Object> source, Map<String, Integer> schema) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : schema.entrySet()) {
            String field = entry.getKey();
            int size = entry.getValue();
            Object value = source.get(field);
            String strValue = value == null ? "" : value.toString();
            if (strValue.length() > size) {
                strValue = strValue.substring(0, size);
            }
            sb.append(String.format("%-" + size + "." + size + "s", strValue));
        }
        return sb.toString();
    }
}
