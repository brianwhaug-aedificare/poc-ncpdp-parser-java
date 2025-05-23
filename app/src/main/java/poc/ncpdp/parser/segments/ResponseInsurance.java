package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseInsuranceDTO;

public class ResponseInsurance extends SegmentBase {
    private final ResponseInsuranceMapper mapper = new ResponseInsuranceMapper();
    private ResponseInsuranceDTO responseInsuranceDTO;

    public ResponseInsurance() {
        super();
        this.responseInsuranceDTO = new ResponseInsuranceDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("C1", "groupId");
        map.put("FO", "planId");
        map.put("2F", "networkReimbursementId");
        map.put("J7", "payerIdQualifier");
        map.put("J8", "payerId");
        map.put("N5", "medicaidIdNumber");
        map.put("N6", "medicaidAgencyNumber");
        map.put("C2", "cardholderId");
        return map;
    }

    public ResponseInsuranceDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponseInsuranceDTOFromMap(values, responseInsuranceDTO);
        setSegmentIdentification(responseInsuranceDTO);
        return this.responseInsuranceDTO;
    }

    private class ResponseInsuranceMapper {
        public void updateResponseInsuranceDTOFromMap(Map<String, Object> values, ResponseInsuranceDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "C1": dto.setGroupId(value); break;
                    case "FO": dto.setPlanId(value); break;
                    case "2F": dto.setNetworkReimbursementId(value); break;
                    case "J7": dto.setPayerIdQualifier(value); break;
                    case "J8": dto.setPayerId(value); break;
                    case "N5": dto.setMedicaidIdNumber(value); break;
                    case "N6": dto.setMedicaidAgencyNumber(value); break;
                    case "C2": dto.setCardholderId(value); break;
                }
            }
        }
    }
}
