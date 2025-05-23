package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseCoordOfBenefitsDTO;

public class ResponseCoordOfBenefits extends SegmentBase {
    private final ResponseCoordOfBenefitsMapper mapper = new ResponseCoordOfBenefitsMapper();
    private ResponseCoordOfBenefitsDTO responseCoordOfBenefitsDTO;

    public ResponseCoordOfBenefits() {
        super();
        this.responseCoordOfBenefitsDTO = new ResponseCoordOfBenefitsDTO();
    }

    public ResponseCoordOfBenefits(ResponseCoordOfBenefitsDTO responseCoordOfBenefitsDTO) {
        super();
        this.responseCoordOfBenefitsDTO = responseCoordOfBenefitsDTO;
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

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponseCoordOfBenefitsDTO(responseCoordOfBenefitsDTO, values);
        return values;
    }

    private static class ResponseCoordOfBenefitsMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<ResponseCoordOfBenefitsDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("NT", ResponseCoordOfBenefitsDTO::setOtherPayerIdCount);
            FIELD_SETTERS.put("5C", ResponseCoordOfBenefitsDTO::setOtherPayerCoverageType);
            FIELD_SETTERS.put("6C", ResponseCoordOfBenefitsDTO::setOtherPayerIdQualifier);
            FIELD_SETTERS.put("7C", ResponseCoordOfBenefitsDTO::setOtherPayerId);
            FIELD_SETTERS.put("MH", ResponseCoordOfBenefitsDTO::setOtherPayerProcessorControlNumber);
            FIELD_SETTERS.put("NU", ResponseCoordOfBenefitsDTO::setOtherPayerCardholderId);
            FIELD_SETTERS.put("MJ", ResponseCoordOfBenefitsDTO::setOtherPayerGroupId);
            FIELD_SETTERS.put("UV", ResponseCoordOfBenefitsDTO::setOtherPayerPersonCode);
            FIELD_SETTERS.put("UB", ResponseCoordOfBenefitsDTO::setOtherPayerHelpDeskPhoneNumber);
            FIELD_SETTERS.put("UW", ResponseCoordOfBenefitsDTO::setOtherPayerPatientRelationshipCode);
            FIELD_SETTERS.put("UX", ResponseCoordOfBenefitsDTO::setOtherPayerBenefitEffectiveDate);
            FIELD_SETTERS.put("UY", ResponseCoordOfBenefitsDTO::setOtherPayerBenefitTerminationDate);
        }

        public void updateResponseCoordOfBenefitsDTOFromMap(Map<String, Object> values, ResponseCoordOfBenefitsDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<ResponseCoordOfBenefitsDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponseCoordOfBenefitsDTO(ResponseCoordOfBenefitsDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "NT", dto.getOtherPayerIdCount());
            putIfNotNull(values, "5C", dto.getOtherPayerCoverageType());
            putIfNotNull(values, "6C", dto.getOtherPayerIdQualifier());
            putIfNotNull(values, "7C", dto.getOtherPayerId());
            putIfNotNull(values, "MH", dto.getOtherPayerProcessorControlNumber());
            putIfNotNull(values, "NU", dto.getOtherPayerCardholderId());
            putIfNotNull(values, "MJ", dto.getOtherPayerGroupId());
            putIfNotNull(values, "UV", dto.getOtherPayerPersonCode());
            putIfNotNull(values, "UB", dto.getOtherPayerHelpDeskPhoneNumber());
            putIfNotNull(values, "UW", dto.getOtherPayerPatientRelationshipCode());
            putIfNotNull(values, "UX", dto.getOtherPayerBenefitEffectiveDate());
            putIfNotNull(values, "UY", dto.getOtherPayerBenefitTerminationDate());
        }
    }
}
