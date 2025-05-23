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
            putIfNotNull(values, "PR", dto.getPriorAuthorizationProcessedDate());
            putIfNotNull(values, "PS", dto.getPriorAuthorizationEffectiveDate());
            putIfNotNull(values, "PT", dto.getPriorAuthorizationExpirationDate());
            putIfNotNull(values, "RA", dto.getPriorAuthorizationQuantity());
            putIfNotNull(values, "RB", dto.getPriorAuthorizationDollarsAuthorized());
            putIfNotNull(values, "PW", dto.getPriorAuthorizationNumberOfRefillsAuthorized());
            putIfNotNull(values, "PX", dto.getPriorAuthorizationQuantityAccumulated());
            putIfNotNull(values, "PY", dto.getPriorAuthorizationNumberAssigned());
        }
    }
}
