package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;
import poc.ncpdp.data.segments.ResponsePriorAuthDTO;

public class ResponsePriorAuth extends SegmentBase {
    private final ResponsePriorAuthMapper mapper = new ResponsePriorAuthMapper();
    private ResponsePriorAuthDTO responsePriorAuthDTO;

    public ResponsePriorAuth() {
        super();
        this.responsePriorAuthDTO = new ResponsePriorAuthDTO();
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

    private class ResponsePriorAuthMapper {
        public void updateResponsePriorAuthDTOFromMap(Map<String, Object> values, ResponsePriorAuthDTO dto) {
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
