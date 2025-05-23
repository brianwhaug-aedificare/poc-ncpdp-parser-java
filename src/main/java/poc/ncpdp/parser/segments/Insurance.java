package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.InsuranceDTO;

public class Insurance extends SegmentBase {

    private final InsuranceMapper mapper = new InsuranceMapper();
    private InsuranceDTO insuranceDTO;

    public Insurance() {
        super();
        this.insuranceDTO = new InsuranceDTO();
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

    private class InsuranceMapper {
        public void updateInsuranceDTOFromMap(Map<String, Object> values, InsuranceDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "C2": dto.setCardholderId(value); break;
                    case "CC": dto.setCardholderFirstName(value); break;
                    case "CD": dto.setCardholderLastName(value); break;
                    case "CE": dto.setHomePlan(value); break;
                    case "FO": dto.setPlanId(value); break;
                    case "C9": dto.setEligibilityClarificationCode(value); break;
                    case "C1": dto.setGroupId(value); break;
                    case "C3": dto.setPersonCode(value); break;
                    case "C6": dto.setPatientRelationshipCode(value); break;
                    case "MG": dto.setOtherPayerBinNumber(value); break;
                    case "MH": dto.setOtherPayerProcessorControlNumber(value); break;
                    case "NU": dto.setOtherPayerCardholderId(value); break;
                    case "MJ": dto.setOtherPayerGroupId(value); break;
                    case "2A": dto.setMedigapId(value); break;
                    case "2B": dto.setMedicaidIndicator(value); break;
                    case "2D": dto.setProviderAcceptAssignmentIndicator(value); break;
                    case "G2": dto.setCmsPartDDefinedQualifiedFacility(value); break;
                    case "N5": dto.setMedicaidIdNumber(value); break;
                    case "N6": dto.setMedicaidAgencyNumber(value); break;
                }
            }
        }
    }
}
