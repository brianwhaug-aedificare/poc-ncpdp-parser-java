package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseInsuranceAdditionalDocumentationDTO;

public class ResponseInsuranceAdditionalDocumentation extends SegmentBase {
    private final ResponseInsuranceAdditionalDocumentationMapper mapper = new ResponseInsuranceAdditionalDocumentationMapper();
    private ResponseInsuranceAdditionalDocumentationDTO responseInsuranceAdditionalDocumentationDTO;

    public ResponseInsuranceAdditionalDocumentation() {
        super();
        this.responseInsuranceAdditionalDocumentationDTO = new ResponseInsuranceAdditionalDocumentationDTO();
    }

    public ResponseInsuranceAdditionalDocumentation(ResponseInsuranceAdditionalDocumentationDTO responseInsuranceAdditionalDocumentationDTO) {
        super();
        this.responseInsuranceAdditionalDocumentationDTO = responseInsuranceAdditionalDocumentationDTO;
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

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponseInsuranceAdditionalDocumentationDTO(responseInsuranceAdditionalDocumentationDTO, values);
        return values;
    }

    private static class ResponseInsuranceAdditionalDocumentationMapper {
        private static final Map<String, java.util.function.BiConsumer<ResponseInsuranceAdditionalDocumentationDTO, String>> FIELD_SETTERS = Map.of(
            "UR", ResponseInsuranceAdditionalDocumentationDTO::setMedicarePartDCoverageCode,
            "UQ", ResponseInsuranceAdditionalDocumentationDTO::setCmsLowIncomeCostSharingLicsLevel,
            "U1", ResponseInsuranceAdditionalDocumentationDTO::setContractNumber,
            "FF", ResponseInsuranceAdditionalDocumentationDTO::setFormularyId,
            "U6", ResponseInsuranceAdditionalDocumentationDTO::setBenefitId,
            "US", ResponseInsuranceAdditionalDocumentationDTO::setNextMedicarePartDEffectiveDate,
            "UT", ResponseInsuranceAdditionalDocumentationDTO::setNextMedicarePartDTerminationDate
        );

        private static final Map<String, java.util.function.Function<ResponseInsuranceAdditionalDocumentationDTO, Object>> FIELD_GETTERS = Map.of(
            "UR", ResponseInsuranceAdditionalDocumentationDTO::getMedicarePartDCoverageCode,
            "UQ", ResponseInsuranceAdditionalDocumentationDTO::getCmsLowIncomeCostSharingLicsLevel,
            "U1", ResponseInsuranceAdditionalDocumentationDTO::getContractNumber,
            "FF", ResponseInsuranceAdditionalDocumentationDTO::getFormularyId,
            "U6", ResponseInsuranceAdditionalDocumentationDTO::getBenefitId,
            "US", ResponseInsuranceAdditionalDocumentationDTO::getNextMedicarePartDEffectiveDate,
            "UT", ResponseInsuranceAdditionalDocumentationDTO::getNextMedicarePartDTerminationDate
        );

        public void updateResponseInsuranceAdditionalDocumentationDTOFromMap(Map<String, Object> values, ResponseInsuranceAdditionalDocumentationDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<ResponseInsuranceAdditionalDocumentationDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponseInsuranceAdditionalDocumentationDTO(ResponseInsuranceAdditionalDocumentationDTO dto, Map<String, Object> values) {
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
