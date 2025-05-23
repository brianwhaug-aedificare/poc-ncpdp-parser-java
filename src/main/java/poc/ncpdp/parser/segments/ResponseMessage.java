package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseMessageDTO;

public class ResponseMessage extends SegmentBase {
    private final ResponseMessageMapper mapper = new ResponseMessageMapper();
    private ResponseMessageDTO responseMessageDTO;

    public ResponseMessage() {
        super();
        this.responseMessageDTO = new ResponseMessageDTO();
    }

    public ResponseMessage(ResponseMessageDTO responseMessageDTO) {
        super();
        this.responseMessageDTO = responseMessageDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("F4", "message");
        return Collections.unmodifiableMap(map);
    }

    public ResponseMessageDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponseMessageDTOFromMap(values, responseMessageDTO);
        setSegmentIdentification(responseMessageDTO);
        return this.responseMessageDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponseMessageDTO(responseMessageDTO, values);
        return values;
    }

    private static class ResponseMessageMapper {
        private static final Map<String, java.util.function.BiConsumer<ResponseMessageDTO, String>> FIELD_SETTERS = Map.of(
            "F4", ResponseMessageDTO::setMessage
        );

        public void updateResponseMessageDTOFromMap(Map<String, Object> values, ResponseMessageDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<ResponseMessageDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponseMessageDTO(ResponseMessageDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "F4", dto.getMessage());
        }
    }
}
