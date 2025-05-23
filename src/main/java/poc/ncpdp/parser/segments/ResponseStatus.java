package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import poc.ncpdp.data.segments.ResponseStatusDTO;

public class ResponseStatus extends SegmentBase {
    private final ResponseStatusMapper mapper = new ResponseStatusMapper();
    private ResponseStatusDTO responseStatusDTO;

    public ResponseStatus() {
        super();
        this.responseStatusDTO = new ResponseStatusDTO();
    }

    public ResponseStatus(ResponseStatusDTO responseStatusDTO) {
        super();
        this.responseStatusDTO = responseStatusDTO;
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

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponseStatusDTO(responseStatusDTO, values);
        return values;
    }

    private static class ResponseStatusMapper {
        private static final Map<String, BiConsumer<ResponseStatusDTO, String>> FIELD_SETTERS = Map.of(
                "ST", ResponseStatusDTO::setStatus);

        public void updateResponseStatusDTOFromMap(Map<String, Object> values, ResponseStatusDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<ResponseStatusDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponseStatusDTO(ResponseStatusDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "ST", dto.getStatus());
        }
    }
}
