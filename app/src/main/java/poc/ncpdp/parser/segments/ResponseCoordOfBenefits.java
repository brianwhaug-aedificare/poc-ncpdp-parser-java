package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseCoordOfBenefitsDTO;

public class ResponseCoordOfBenefits extends SegmentBase {
    private final ResponseCoordOfBenefitsMapper mapper = new ResponseCoordOfBenefitsMapper();
    private ResponseCoordOfBenefitsDTO responseCoordOfBenefitsDTO;

    public ResponseCoordOfBenefits() {
        super();
        this.responseCoordOfBenefitsDTO = new ResponseCoordOfBenefitsDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("NT", "otherPayerIdCount");
        map.put("5C", "otherPayerCoverageType");
        map.put("6C", "otherPayerIdQualifier");
        map.put("7C", "otherPayerId");
        map.put("MH", "otherPayerProcessorControlNumber");
        map.put("NU", "otherPayerCardholderId");
        map.put("MJ", "otherPayerGroupId");
        map.put("UV", "otherPayerPersonCode");
        map.put("UB", "otherPayerHelpDeskPhoneNumber");
        map.put("UW", "otherPayerPatientRelationshipCode");
        map.put("UX", "otherPayerBenefitEffectiveDate");
        map.put("UY", "otherPayerBenefitTerminationDate");
        return map;
    }

    public ResponseCoordOfBenefitsDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponseCoordOfBenefitsDTOFromMap(values, responseCoordOfBenefitsDTO);
        setSegmentIdentification(responseCoordOfBenefitsDTO);
        return this.responseCoordOfBenefitsDTO;
    }

    private class ResponseCoordOfBenefitsMapper {
        public void updateResponseCoordOfBenefitsDTOFromMap(Map<String, Object> values, ResponseCoordOfBenefitsDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "NT": dto.setOtherPayerIdCount(value); break;
                    case "5C": dto.setOtherPayerCoverageType(value); break;
                    case "6C": dto.setOtherPayerIdQualifier(value); break;
                    case "7C": dto.setOtherPayerId(value); break;
                    case "MH": dto.setOtherPayerProcessorControlNumber(value); break;
                    case "NU": dto.setOtherPayerCardholderId(value); break;
                    case "MJ": dto.setOtherPayerGroupId(value); break;
                    case "UV": dto.setOtherPayerPersonCode(value); break;
                    case "UB": dto.setOtherPayerHelpDeskPhoneNumber(value); break;
                    case "UW": dto.setOtherPayerPatientRelationshipCode(value); break;
                    case "UX": dto.setOtherPayerBenefitEffectiveDate(value); break;
                    case "UY": dto.setOtherPayerBenefitTerminationDate(value); break;
                }
            }
        }
    }
}
