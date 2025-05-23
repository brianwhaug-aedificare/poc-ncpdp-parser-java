package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PriorAuthDTO;

public class PriorAuth extends SegmentBase {
    private final PriorAuthMapper mapper = new PriorAuthMapper();
    private PriorAuthDTO priorAuthDTO;

    public PriorAuth() {
        super();
        this.priorAuthDTO = new PriorAuthDTO();
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

    private class PriorAuthMapper {
        public void updatePriorAuthDTOFromMap(Map<String, Object> values, PriorAuthDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "PR": dto.setPriorAuthorizationProcessedDate(value); break;
                    case "PS": dto.setPriorAuthorizationEffectiveDate(value); break;
                    case "PT": dto.setPriorAuthorizationExpirationDate(value); break;
                    case "RA": dto.setPriorAuthorizationQuantity(value); break;
                    case "RB": dto.setPriorAuthorizationDollarsAuthorized(value); break;
                    case "PW": dto.setPriorAuthorizationNumberOfRefillsAuthorized(value); break;
                    case "PX": dto.setPriorAuthorizationQuantityAccumulated(value); break;
                    case "PY": dto.setPriorAuthorizationNumberAssigned(value); break;
                }
            }
        }
    }
}
