package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import poc.ncpdp.data.segments.CoordOfBenefitsDTO;

public class CoordOfBenefits extends SegmentBase {
    private final CoordOfBenefitsMapper mapper = new CoordOfBenefitsMapper();
    private CoordOfBenefitsDTO coordOfBenefitsDTO;

    public CoordOfBenefits() {
        super();
        this.coordOfBenefitsDTO = new CoordOfBenefitsDTO();
    }

    public CoordOfBenefits(CoordOfBenefitsDTO coordOfBenefitsDTO) {
        super();
        this.coordOfBenefitsDTO = coordOfBenefitsDTO;
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

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromCoordOfBenefitsDTO(coordOfBenefitsDTO, values);
        return values;
    }

    private static class CoordOfBenefitsMapper {
        private static final Map<String, BiConsumer<CoordOfBenefitsDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new HashMap<>();
            FIELD_SETTERS.put("4C", (dto, v) -> dto.setCoordinationOfBenefitsOtherPaymentsCount(v));
            FIELD_SETTERS.put("5C", (dto, v) -> dto.setOtherPayerCoverageType(v));
            FIELD_SETTERS.put("6C", (dto, v) -> dto.setOtherPayerIdQualifier(v));
            FIELD_SETTERS.put("7C", (dto, v) -> dto.setOtherPayerId(v));
            FIELD_SETTERS.put("E8", (dto, v) -> dto.setOtherPayerDate(v));
            FIELD_SETTERS.put("A7", (dto, v) -> dto.setInternalControlNumber(v));
            FIELD_SETTERS.put("HB", (dto, v) -> dto.setOtherPayerAmountPaidCount(v));
            FIELD_SETTERS.put("HC", (dto, v) -> dto.setOtherPayerAmountPaidQualifier(v));
            FIELD_SETTERS.put("DV", (dto, v) -> dto.setOtherPayerAmountPaid(v));
            FIELD_SETTERS.put("5E", (dto, v) -> dto.setOtherPayerRejectCount(v));
            FIELD_SETTERS.put("6E", (dto, v) -> dto.setOtherPayerRejectCode(v));
            FIELD_SETTERS.put("NR", (dto, v) -> dto.setOtherPayerPatientResponsibilityAmountCount(v));
            FIELD_SETTERS.put("NP", (dto, v) -> dto.setOtherPayerPatientResponsibilityAmountQualifier(v));
            FIELD_SETTERS.put("NQ", (dto, v) -> dto.setOtherPayerPatientResponsibilityAmount(v));
            FIELD_SETTERS.put("MU", (dto, v) -> dto.setBenefitStageCount(v));
            FIELD_SETTERS.put("MV", (dto, v) -> dto.setBenefitStageQualifier(v));
            FIELD_SETTERS.put("MW", (dto, v) -> dto.setBenefitStageAmount(v));
        }

        private static final Map<String, java.util.function.Function<CoordOfBenefitsDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("4C", CoordOfBenefitsDTO::getCoordinationOfBenefitsOtherPaymentsCount);
            FIELD_GETTERS.put("5C", CoordOfBenefitsDTO::getOtherPayerCoverageType);
            FIELD_GETTERS.put("6C", CoordOfBenefitsDTO::getOtherPayerIdQualifier);
            FIELD_GETTERS.put("7C", CoordOfBenefitsDTO::getOtherPayerId);
            FIELD_GETTERS.put("E8", CoordOfBenefitsDTO::getOtherPayerDate);
            FIELD_GETTERS.put("A7", CoordOfBenefitsDTO::getInternalControlNumber);
            FIELD_GETTERS.put("HB", CoordOfBenefitsDTO::getOtherPayerAmountPaidCount);
            FIELD_GETTERS.put("HC", CoordOfBenefitsDTO::getOtherPayerAmountPaidQualifier);
            FIELD_GETTERS.put("DV", CoordOfBenefitsDTO::getOtherPayerAmountPaid);
            FIELD_GETTERS.put("5E", CoordOfBenefitsDTO::getOtherPayerRejectCount);
            FIELD_GETTERS.put("6E", CoordOfBenefitsDTO::getOtherPayerRejectCode);
            FIELD_GETTERS.put("NR", CoordOfBenefitsDTO::getOtherPayerPatientResponsibilityAmountCount);
            FIELD_GETTERS.put("NP", CoordOfBenefitsDTO::getOtherPayerPatientResponsibilityAmountQualifier);
            FIELD_GETTERS.put("NQ", CoordOfBenefitsDTO::getOtherPayerPatientResponsibilityAmount);
            FIELD_GETTERS.put("MU", CoordOfBenefitsDTO::getBenefitStageCount);
            FIELD_GETTERS.put("MV", CoordOfBenefitsDTO::getBenefitStageQualifier);
            FIELD_GETTERS.put("MW", CoordOfBenefitsDTO::getBenefitStageAmount);
        }

        public void updateCoordOfBenefitsDTOFromMap(Map<String, Object> values, CoordOfBenefitsDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<CoordOfBenefitsDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromCoordOfBenefitsDTO(CoordOfBenefitsDTO dto, Map<String, Object> values) {
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
