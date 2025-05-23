package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseClaimDTO;

public class ResponseClaim extends SegmentBase {
    private final ResponseClaimMapper mapper = new ResponseClaimMapper();
    private ResponseClaimDTO responseClaimDTO;

    public ResponseClaim() {
        super();
        this.responseClaimDTO = new ResponseClaimDTO();
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

    private class ResponseClaimMapper {
        public void updateResponseClaimDTOFromMap(Map<String, Object> values, ResponseClaimDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "EM": dto.setPrescriptionReferenceNumberQualifier(value); break;
                    case "D2": dto.setPrescriptionReferenceNumber(value); break;
                    case "9F": dto.setPreferredProductCount(value); break;
                    case "AP": dto.setPreferredProductIdQualifier(value); break;
                    case "AR": dto.setPreferredProductId(value); break;
                    case "AS": dto.setPreferredProductIncentive(value); break;
                    case "AT": dto.setPreferredProductCostShareIncentive(value); break;
                    case "AU": dto.setPreferredProductDescription(value); break;
                    case "N4": dto.setMedicadeIcn(value); break;
                }
            }
        }
    }
}
