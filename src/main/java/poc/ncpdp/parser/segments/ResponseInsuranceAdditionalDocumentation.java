package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseInsuranceAdditionalDocumentationDTO;

public class ResponseInsuranceAdditionalDocumentation extends SegmentBase {
    private final ResponseInsuranceAdditionalDocumentationMapper mapper = new ResponseInsuranceAdditionalDocumentationMapper();
    private ResponseInsuranceAdditionalDocumentationDTO responseInsuranceAdditionalDocumentationDTO;

    public ResponseInsuranceAdditionalDocumentation() {
        super();
        this.responseInsuranceAdditionalDocumentationDTO = new ResponseInsuranceAdditionalDocumentationDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("UR", "medicarePartDCoverageCode");
        map.put("UQ", "cmsLowIncomeCostSharingLicsLevel");
        map.put("U1", "contractNumber");
        map.put("FF", "formularyId");
        map.put("U6", "benefitId");
        map.put("US", "nextMedicarePartDEffectiveDate");
        map.put("UT", "nextMedicarePartDTerminationDate");
        return map;
    }

    public ResponseInsuranceAdditionalDocumentationDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponseInsuranceAdditionalDocumentationDTOFromMap(values, responseInsuranceAdditionalDocumentationDTO);
        setSegmentIdentification(responseInsuranceAdditionalDocumentationDTO);
        return this.responseInsuranceAdditionalDocumentationDTO;
    }

    private class ResponseInsuranceAdditionalDocumentationMapper {
        public void updateResponseInsuranceAdditionalDocumentationDTOFromMap(Map<String, Object> values, ResponseInsuranceAdditionalDocumentationDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "UR": dto.setMedicarePartDCoverageCode(value); break;
                    case "UQ": dto.setCmsLowIncomeCostSharingLicsLevel(value); break;
                    case "U1": dto.setContractNumber(value); break;
                    case "FF": dto.setFormularyId(value); break;
                    case "U6": dto.setBenefitId(value); break;
                    case "US": dto.setNextMedicarePartDEffectiveDate(value); break;
                    case "UT": dto.setNextMedicarePartDTerminationDate(value); break;
                }
            }
        }
    }
}
