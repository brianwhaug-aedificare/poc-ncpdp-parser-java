package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseStatusDTO;

public class ResponseStatus extends SegmentBase {
    private final ResponseStatusMapper mapper = new ResponseStatusMapper();
    private ResponseStatusDTO responseStatusDTO;

    public ResponseStatus() {
        super();
        this.responseStatusDTO = new ResponseStatusDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("ST", "status");
        return Collections.unmodifiableMap(map);
    }

    public ResponseStatusDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponseStatusDTOFromMap(values, responseStatusDTO);
        setSegmentIdentification(responseStatusDTO);
        return this.responseStatusDTO;
    }

    private class ResponseStatusMapper {
        public void updateResponseStatusDTOFromMap(Map<String, Object> values, ResponseStatusDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "ST": dto.setStatus(value); break;
                }
            }
        }
    }
}
