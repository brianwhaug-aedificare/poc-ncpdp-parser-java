package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseInsuranceDTO;

public class ResponseInsurance extends SegmentBase {
    private final ResponseInsuranceMapper mapper = new ResponseInsuranceMapper();
    private ResponseInsuranceDTO responseInsuranceDTO;

    public ResponseInsurance() {
        super();
        this.responseInsuranceDTO = new ResponseInsuranceDTO();
    }

    public ResponseInsurance(ResponseInsuranceDTO responseInsuranceDTO) {
        super();
        this.responseInsuranceDTO = responseInsuranceDTO;
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

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponseInsuranceDTO(responseInsuranceDTO, values);
        return values;
    }

    private static class ResponseInsuranceMapper {
        private static final Map<String, java.util.function.BiConsumer<ResponseInsuranceDTO, String>> FIELD_SETTERS = Map.of(
            "C1", ResponseInsuranceDTO::setGroupId,
            "FO", ResponseInsuranceDTO::setPlanId,
            "2F", ResponseInsuranceDTO::setNetworkReimbursementId,
            "J7", ResponseInsuranceDTO::setPayerIdQualifier,
            "J8", ResponseInsuranceDTO::setPayerId,
            "N5", ResponseInsuranceDTO::setMedicaidIdNumber,
            "N6", ResponseInsuranceDTO::setMedicaidAgencyNumber,
            "C2", ResponseInsuranceDTO::setCardholderId
        );

        public void updateResponseInsuranceDTOFromMap(Map<String, Object> values, ResponseInsuranceDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<ResponseInsuranceDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponseInsuranceDTO(ResponseInsuranceDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "C1", dto.getGroupId());
            putIfNotNull(values, "FO", dto.getPlanId());
            putIfNotNull(values, "2F", dto.getNetworkReimbursementId());
            putIfNotNull(values, "J7", dto.getPayerIdQualifier());
            putIfNotNull(values, "J8", dto.getPayerId());
            putIfNotNull(values, "N5", dto.getMedicaidIdNumber());
            putIfNotNull(values, "N6", dto.getMedicaidAgencyNumber());
            putIfNotNull(values, "C2", dto.getCardholderId());
        }
    }
}
