package poc.ncpdp.parser.segments.concerns;

import java.util.Map;
import java.util.stream.Collectors;

import poc.ncpdp.parser.Constants;

public interface SegmentBuilder {
    static String buildSegment(Map<String, Object> values) {
        String segmentString = values.entrySet().stream()
                .map(e -> e.getKey() + String.valueOf(e.getValue()))
                .collect(Collectors.joining(Constants.FIELD_SEPARATOR));
        return Constants.FIELD_SEPARATOR + segmentString + Constants.SEGMENT_SEPARATOR;
    }
}
