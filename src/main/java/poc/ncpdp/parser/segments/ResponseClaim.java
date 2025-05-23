package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseClaimDTO;

public class ResponseClaim extends SegmentBase {
    private final ResponseClaimMapper mapper = new ResponseClaimMapper();
    private ResponseClaimDTO responseClaimDTO;

    public ResponseClaim() {
        super();
        this.responseClaimDTO = new ResponseClaimDTO();
    }

    public ResponseClaim(ResponseClaimDTO responseClaimDTO) {
        super();
        this.responseClaimDTO = responseClaimDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("EM", "prescriptionReferenceNumberQualifier");
        map.put("D2", "prescriptionReferenceNumber");
        map.put("9F", "preferredProductCount");
        map.put("AP", "preferredProductIdQualifier");
        map.put("AR", "preferredProductId");
        map.put("AS", "preferredProductIncentive");
        map.put("AT", "preferredProductCostShareIncentive");
        map.put("AU", "preferredProductDescription");
        map.put("N4", "medicadeIcn");
        return map;
    }

    public ResponseClaimDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponseClaimDTOFromMap(values, responseClaimDTO);
        setSegmentIdentification(responseClaimDTO);
        return this.responseClaimDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponseClaimDTO(responseClaimDTO, values);
        return values;
    }

    private static class ResponseClaimMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<ResponseClaimDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("EM", ResponseClaimDTO::setPrescriptionReferenceNumberQualifier);
            FIELD_SETTERS.put("D2", ResponseClaimDTO::setPrescriptionReferenceNumber);
            FIELD_SETTERS.put("9F", ResponseClaimDTO::setPreferredProductCount);
            FIELD_SETTERS.put("AP", ResponseClaimDTO::setPreferredProductIdQualifier);
            FIELD_SETTERS.put("AR", ResponseClaimDTO::setPreferredProductId);
            FIELD_SETTERS.put("AS", ResponseClaimDTO::setPreferredProductIncentive);
            FIELD_SETTERS.put("AT", ResponseClaimDTO::setPreferredProductCostShareIncentive);
            FIELD_SETTERS.put("AU", ResponseClaimDTO::setPreferredProductDescription);
            FIELD_SETTERS.put("N4", ResponseClaimDTO::setMedicadeIcn);
        }

        public void updateResponseClaimDTOFromMap(Map<String, Object> values, ResponseClaimDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<ResponseClaimDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponseClaimDTO(ResponseClaimDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "EM", dto.getPrescriptionReferenceNumberQualifier());
            putIfNotNull(values, "D2", dto.getPrescriptionReferenceNumber());
            putIfNotNull(values, "9F", dto.getPreferredProductCount());
            putIfNotNull(values, "AP", dto.getPreferredProductIdQualifier());
            putIfNotNull(values, "AR", dto.getPreferredProductId());
            putIfNotNull(values, "AS", dto.getPreferredProductIncentive());
            putIfNotNull(values, "AT", dto.getPreferredProductCostShareIncentive());
            putIfNotNull(values, "AU", dto.getPreferredProductDescription());
            putIfNotNull(values, "N4", dto.getMedicadeIcn());
        }
        
    }
}
