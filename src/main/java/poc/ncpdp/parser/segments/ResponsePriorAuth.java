package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import poc.ncpdp.data.segments.ResponsePriorAuthDTO;

public class ResponsePriorAuth extends SegmentBase {
    private final ResponsePriorAuthMapper mapper = new ResponsePriorAuthMapper();
    private ResponsePriorAuthDTO responsePriorAuthDTO;

    public ResponsePriorAuth() {
        super();
        this.responsePriorAuthDTO = new ResponsePriorAuthDTO();
    }

    public ResponsePriorAuth(ResponsePriorAuthDTO responsePriorAuthDTO) {
        super();
        this.responsePriorAuthDTO = responsePriorAuthDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("PR", "priorAuthorizationProcessedDate");
        map.put("PS", "priorAuthorizationEffectiveDate");
        map.put("PT", "priorAuthorizationExpirationDate");
        map.put("RA", "priorAuthorizationQuantity");
        map.put("RB", "priorAuthorizationDollarsAuthorized");
        map.put("PW", "priorAuthorizationNumberOfRefillsAuthorized");
        map.put("PX", "priorAuthorizationQuantityAccumulated");
        map.put("PY", "priorAuthorizationNumberAssigned");
        return map;
    }

    public ResponsePriorAuthDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponsePriorAuthDTOFromMap(values, responsePriorAuthDTO);
        setSegmentIdentification(responsePriorAuthDTO);
        return this.responsePriorAuthDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponsePriorAuthDTO(responsePriorAuthDTO, values);
        return values;
    }

    private static class ResponsePriorAuthMapper {
        private static final Map<String, BiConsumer<ResponsePriorAuthDTO, String>> FIELD_SETTERS = Map.of(
            "PR", ResponsePriorAuthDTO::setPriorAuthorizationProcessedDate,
            "PS", ResponsePriorAuthDTO::setPriorAuthorizationEffectiveDate,
            "PT", ResponsePriorAuthDTO::setPriorAuthorizationExpirationDate,
            "RA", ResponsePriorAuthDTO::setPriorAuthorizationQuantity,
            "RB", ResponsePriorAuthDTO::setPriorAuthorizationDollarsAuthorized,
            "PW", ResponsePriorAuthDTO::setPriorAuthorizationNumberOfRefillsAuthorized,
            "PX", ResponsePriorAuthDTO::setPriorAuthorizationQuantityAccumulated,
            "PY", ResponsePriorAuthDTO::setPriorAuthorizationNumberAssigned
        );

        private static final Map<String, java.util.function.Function<ResponsePriorAuthDTO, Object>> FIELD_GETTERS = Map.of(
            "PR", ResponsePriorAuthDTO::getPriorAuthorizationProcessedDate,
            "PS", ResponsePriorAuthDTO::getPriorAuthorizationEffectiveDate,
            "PT", ResponsePriorAuthDTO::getPriorAuthorizationExpirationDate,
            "RA", ResponsePriorAuthDTO::getPriorAuthorizationQuantity,
            "RB", ResponsePriorAuthDTO::getPriorAuthorizationDollarsAuthorized,
            "PW", ResponsePriorAuthDTO::getPriorAuthorizationNumberOfRefillsAuthorized,
            "PX", ResponsePriorAuthDTO::getPriorAuthorizationQuantityAccumulated,
            "PY", ResponsePriorAuthDTO::getPriorAuthorizationNumberAssigned
        );

        public void updateResponsePriorAuthDTOFromMap(Map<String, Object> values, ResponsePriorAuthDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<ResponsePriorAuthDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponsePriorAuthDTO(ResponsePriorAuthDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            FIELD_GETTERS.forEach((key, getter) -> {
                Object value = getter.apply(dto);
                if (value != null) {
                    values.put(key, value);
                }
            });
        }
    }
}
