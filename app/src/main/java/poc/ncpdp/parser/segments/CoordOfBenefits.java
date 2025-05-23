package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.CoordOfBenefitsDTO;

public class CoordOfBenefits extends SegmentBase {

    private final CoordOfBenefitsMapper mapper = new CoordOfBenefitsMapper();
    private CoordOfBenefitsDTO coordOfBenefitsDTO;

    public CoordOfBenefits() {
        super();
        this.coordOfBenefitsDTO = new CoordOfBenefitsDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("4C", "coordinationOfBenefitsOtherPaymentsCount");
        map.put("5C", "otherPayerCoverageType");
        map.put("6C", "otherPayerIdQualifier");
        map.put("7C", "otherPayerId");
        map.put("E8", "otherPayerDate");
        map.put("A7", "internalControlNumber");
        map.put("HB", "otherPayerAmountPaidCount");
        map.put("HC", "otherPayerAmountPaidQualifier");
        map.put("DV", "otherPayerAmountPaid");
        map.put("5E", "otherPayerRejectCount");
        map.put("6E", "otherPayerRejectCode");
        map.put("NR", "otherPayerPatientResponsibilityAmountCount");
        map.put("NP", "otherPayerPatientResponsibilityAmountQualifier");
        map.put("NQ", "otherPayerPatientResponsibilityAmount");
        map.put("MU", "benefitStageCount");
        map.put("MV", "benefitStageQualifier");
        map.put("MW", "benefitStageAmount");
        return Collections.unmodifiableMap(map);
    }

    public CoordOfBenefitsDTO setDTOValues(Map<String, Object> values) {
        mapper.updateCoordOfBenefitsDTOFromMap(values, coordOfBenefitsDTO);
        setSegmentIdentification(coordOfBenefitsDTO);
        return this.coordOfBenefitsDTO;
    }

    private class CoordOfBenefitsMapper {
        public void updateCoordOfBenefitsDTOFromMap(Map<String, Object> values, CoordOfBenefitsDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "4C": dto.setCoordinationOfBenefitsOtherPaymentsCount(value); break;
                    case "5C": dto.setOtherPayerCoverageType(value); break;
                    case "6C": dto.setOtherPayerIdQualifier(value); break;
                    case "7C": dto.setOtherPayerId(value); break;
                    case "E8": dto.setOtherPayerDate(value); break;
                    case "A7": dto.setInternalControlNumber(value); break;
                    case "HB": dto.setOtherPayerAmountPaidCount(value); break;
                    case "HC": dto.setOtherPayerAmountPaidQualifier(value); break;
                    case "DV": dto.setOtherPayerAmountPaid(value); break;
                    case "5E": dto.setOtherPayerRejectCount(value); break;
                    case "6E": dto.setOtherPayerRejectCode(value); break;
                    case "NR": dto.setOtherPayerPatientResponsibilityAmountCount(value); break;
                    case "NP": dto.setOtherPayerPatientResponsibilityAmountQualifier(value); break;
                    case "NQ": dto.setOtherPayerPatientResponsibilityAmount(value); break;
                    case "MU": dto.setBenefitStageCount(value); break;
                    case "MV": dto.setBenefitStageQualifier(value); break;
                    case "MW": dto.setBenefitStageAmount(value); break;
                }
            }
        }
    }
}
