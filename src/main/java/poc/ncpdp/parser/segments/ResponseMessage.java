package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseMessageDTO;

public class ResponseMessage extends SegmentBase {
    private final ResponseMessageMapper mapper = new ResponseMessageMapper();
    private ResponseMessageDTO responseMessageDTO;

    public ResponseMessage() {
        super();
        this.responseMessageDTO = new ResponseMessageDTO();
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

    private class ResponseMessageMapper {
        public void updateResponseMessageDTOFromMap(Map<String, Object> values, ResponseMessageDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "F4": dto.setMessage(value); break;
                }
            }
        }
    }
}
