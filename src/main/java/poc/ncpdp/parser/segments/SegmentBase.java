package poc.ncpdp.parser.segments;

import poc.ncpdp.data.segments.SegmentDTO;
import poc.ncpdp.parser.segments.concerns.Parser;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class SegmentBase implements SegmentDTOBuilder {
    private static final String SEGMENT_IDENTIFICATION = "AM";
   
    protected final Map<String, Object> hash;

    public SegmentBase() {
        this(new HashMap<>());
    }

    public SegmentBase(Map<String, ?> initialHash) {
        this.hash = new HashMap<>();
        if (initialHash != null) {
            this.hash.putAll(initialHash);
        }
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>();
        map.put(SEGMENT_IDENTIFICATION, "segmentIdentification");
        return map;
    }

    public static String getFieldBySymbol(String sym) {
        for (Map.Entry<String, String> entry : fieldIdToSymbol().entrySet()) {
            if (Objects.equals(entry.getValue(), sym)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String getSymbolByField(String field) {
        return fieldIdToSymbol().get(field);
    }

    public static SegmentBase build(Map<String, Object> initialHash) {
        // Get raw string value which contains the segment data
        String raw = (String) initialHash.get("raw");
        Map<String, String> parsedFields = new HashMap<>();

        // Use Parser to split raw string into field key-value pairs
        String givenIdentifier = null;
        if (raw != null) {
            parsedFields = Parser.parse(raw);
            givenIdentifier = parsedFields.get(SEGMENT_IDENTIFICATION);
        }

        SegmentBase segment = SegmentRegistry.getSegment(givenIdentifier);
        if (segment == null) {
            throw new RuntimeException("No segment class found for identifier: " + givenIdentifier);
        } else {
            segment.merge(parsedFields);
            return segment;
        }
    }

    public Object get(Object key) {
        String fieldKey = key instanceof String ? (String) key : getFieldBySymbol(key.toString());
        return hash.get(fieldKey);
    }

    public void set(Object key, Object value) {
        String fieldKey = key instanceof String ? (String) key : getFieldBySymbol(key.toString());
        hash.put(fieldKey, value);
    }

    public SegmentBase merge(Map<String, ?> other) {
        if (other != null) {
            for (Map.Entry<String, ?> entry : other.entrySet()) {
                set(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public Map<String, Object> getHash() {
        return Collections.unmodifiableMap(hash);
    }

    // sets the segment identification in the DTO
    public void setSegmentIdentification(SegmentDTO segmentDTO) {
        String segmentId = (String) hash.get(SEGMENT_IDENTIFICATION);
        if (segmentId != null) {
            segmentDTO.setSegmentIdentification(segmentId);
        }
    }
    
    // adds the segment identification to the map
    public static void setSegmentIdentification(Map<String, Object> values, String segmentId) {
        values.put(SEGMENT_IDENTIFICATION, segmentId);
    }
}
