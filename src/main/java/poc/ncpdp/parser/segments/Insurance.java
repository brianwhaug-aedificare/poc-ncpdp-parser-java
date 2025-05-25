package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.InsuranceDTO;

public class Insurance extends SegmentBase {

    private final InsuranceMapper mapper = new InsuranceMapper();
    private InsuranceDTO insuranceDTO;

    public Insurance() {
        super();
        this.insuranceDTO = new InsuranceDTO();
    }

    public Insurance(InsuranceDTO insuranceDTO) {
        super();
        this.insuranceDTO = insuranceDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("C2", "cardholderId");
        map.put("CC", "cardholderFirstName");
        map.put("CD", "cardholderLastName");
        map.put("CE", "homePlan");
        map.put("FO", "planId");
        map.put("C9", "eligibilityClarificationCode");
        map.put("C1", "groupId");
        map.put("C3", "personCode");
        map.put("C6", "patientRelationshipCode");
        map.put("MG", "otherPayerBinNumber");
        map.put("MH", "otherPayerProcessorControlNumber");
        map.put("NU", "otherPayerCardholderId");
        map.put("MJ", "otherPayerGroupId");
        map.put("2A", "medigapId");
        map.put("2B", "medicaidIndicator");
        map.put("2D", "providerAcceptAssignmentIndicator");
        map.put("G2", "cmsPartDDefinedQualifiedFacility");
        map.put("N5", "medicaidIdNumber");
        map.put("N6", "medicaidAgencyNumber");
        return Collections.unmodifiableMap(map);
    }

    public InsuranceDTO setDTOValues(Map<String, Object> values) {
        mapper.updateInsuranceDTOFromMap(values, insuranceDTO);
        setSegmentIdentification(insuranceDTO);
        return this.insuranceDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromInsuranceDTO(insuranceDTO, values);
        return values;
    }

    private static class InsuranceMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<InsuranceDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("C2", InsuranceDTO::setCardholderId);
            FIELD_SETTERS.put("CC", InsuranceDTO::setCardholderFirstName);
            FIELD_SETTERS.put("CD", InsuranceDTO::setCardholderLastName);
            FIELD_SETTERS.put("CE", InsuranceDTO::setHomePlan);
            FIELD_SETTERS.put("FO", InsuranceDTO::setPlanId);
            FIELD_SETTERS.put("C9", InsuranceDTO::setEligibilityClarificationCode);
            FIELD_SETTERS.put("C1", InsuranceDTO::setGroupId);
            FIELD_SETTERS.put("C3", InsuranceDTO::setPersonCode);
            FIELD_SETTERS.put("C6", InsuranceDTO::setPatientRelationshipCode);
            FIELD_SETTERS.put("MG", InsuranceDTO::setOtherPayerBinNumber);
            FIELD_SETTERS.put("MH", InsuranceDTO::setOtherPayerProcessorControlNumber);
            FIELD_SETTERS.put("NU", InsuranceDTO::setOtherPayerCardholderId);
            FIELD_SETTERS.put("MJ", InsuranceDTO::setOtherPayerGroupId);
            FIELD_SETTERS.put("2A", InsuranceDTO::setMedigapId);
            FIELD_SETTERS.put("2B", InsuranceDTO::setMedicaidIndicator);
            FIELD_SETTERS.put("2D", InsuranceDTO::setProviderAcceptAssignmentIndicator);
            FIELD_SETTERS.put("G2", InsuranceDTO::setCmsPartDDefinedQualifiedFacility);
            FIELD_SETTERS.put("N5", InsuranceDTO::setMedicaidIdNumber);
            FIELD_SETTERS.put("N6", InsuranceDTO::setMedicaidAgencyNumber);
        }

        private static final java.util.Map<String, java.util.function.Function<InsuranceDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("C2", InsuranceDTO::getCardholderId);
            FIELD_GETTERS.put("CC", InsuranceDTO::getCardholderFirstName);
            FIELD_GETTERS.put("CD", InsuranceDTO::getCardholderLastName);
            FIELD_GETTERS.put("CE", InsuranceDTO::getHomePlan);
            FIELD_GETTERS.put("FO", InsuranceDTO::getPlanId);
            FIELD_GETTERS.put("C9", InsuranceDTO::getEligibilityClarificationCode);
            FIELD_GETTERS.put("C1", InsuranceDTO::getGroupId);
            FIELD_GETTERS.put("C3", InsuranceDTO::getPersonCode);
            FIELD_GETTERS.put("C6", InsuranceDTO::getPatientRelationshipCode);
            FIELD_GETTERS.put("MG", InsuranceDTO::getOtherPayerBinNumber);
            FIELD_GETTERS.put("MH", InsuranceDTO::getOtherPayerProcessorControlNumber);
            FIELD_GETTERS.put("NU", InsuranceDTO::getOtherPayerCardholderId);
            FIELD_GETTERS.put("MJ", InsuranceDTO::getOtherPayerGroupId);
            FIELD_GETTERS.put("2A", InsuranceDTO::getMedigapId);
            FIELD_GETTERS.put("2B", InsuranceDTO::getMedicaidIndicator);
            FIELD_GETTERS.put("2D", InsuranceDTO::getProviderAcceptAssignmentIndicator);
            FIELD_GETTERS.put("G2", InsuranceDTO::getCmsPartDDefinedQualifiedFacility);
            FIELD_GETTERS.put("N5", InsuranceDTO::getMedicaidIdNumber);
            FIELD_GETTERS.put("N6", InsuranceDTO::getMedicaidAgencyNumber);
        }

        public void updateInsuranceDTOFromMap(Map<String, Object> values, InsuranceDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<InsuranceDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromInsuranceDTO(InsuranceDTO dto, Map<String, Object> values) {
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
