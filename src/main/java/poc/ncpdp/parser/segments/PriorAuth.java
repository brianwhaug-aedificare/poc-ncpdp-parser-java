package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PriorAuthDTO;

public class PriorAuth extends SegmentBase {
    private final PriorAuthMapper mapper = new PriorAuthMapper();
    private PriorAuthDTO priorAuthDTO;

    public PriorAuth() {
        super();
        this.priorAuthDTO = new PriorAuthDTO();
    }

    public PriorAuth(PriorAuthDTO priorAuthDTO) {
        super();
        this.priorAuthDTO = priorAuthDTO;
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
        return Collections.unmodifiableMap(map);
    }

    public PriorAuthDTO setDTOValues(Map<String, Object> values) {
        mapper.updatePriorAuthDTOFromMap(values, priorAuthDTO);
        return this.priorAuthDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromPriorAuthDTO(priorAuthDTO, values);
        return values;
    }

    private static class PriorAuthMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<PriorAuthDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("PR", PriorAuthDTO::setPriorAuthorizationProcessedDate);
            FIELD_SETTERS.put("PS", PriorAuthDTO::setPriorAuthorizationEffectiveDate);
            FIELD_SETTERS.put("PT", PriorAuthDTO::setPriorAuthorizationExpirationDate);
            FIELD_SETTERS.put("RA", PriorAuthDTO::setPriorAuthorizationQuantity);
            FIELD_SETTERS.put("RB", PriorAuthDTO::setPriorAuthorizationDollarsAuthorized);
            FIELD_SETTERS.put("PW", PriorAuthDTO::setPriorAuthorizationNumberOfRefillsAuthorized);
            FIELD_SETTERS.put("PX", PriorAuthDTO::setPriorAuthorizationQuantityAccumulated);
            FIELD_SETTERS.put("PY", PriorAuthDTO::setPriorAuthorizationNumberAssigned);
        }

        private static final java.util.Map<String, java.util.function.Function<PriorAuthDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("PR", PriorAuthDTO::getPriorAuthorizationProcessedDate);
            FIELD_GETTERS.put("PS", PriorAuthDTO::getPriorAuthorizationEffectiveDate);
            FIELD_GETTERS.put("PT", PriorAuthDTO::getPriorAuthorizationExpirationDate);
            FIELD_GETTERS.put("RA", PriorAuthDTO::getPriorAuthorizationQuantity);
            FIELD_GETTERS.put("RB", PriorAuthDTO::getPriorAuthorizationDollarsAuthorized);
            FIELD_GETTERS.put("PW", PriorAuthDTO::getPriorAuthorizationNumberOfRefillsAuthorized);
            FIELD_GETTERS.put("PX", PriorAuthDTO::getPriorAuthorizationQuantityAccumulated);
            FIELD_GETTERS.put("PY", PriorAuthDTO::getPriorAuthorizationNumberAssigned);
        }

        public void updatePriorAuthDTOFromMap(Map<String, Object> values, PriorAuthDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<PriorAuthDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromPriorAuthDTO(PriorAuthDTO dto, Map<String, Object> values) {
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
