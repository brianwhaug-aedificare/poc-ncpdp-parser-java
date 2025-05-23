package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PricingDTO;

public class Pricing extends SegmentBase {
    private final PricingMapper mapper = new PricingMapper();
    private PricingDTO pricingDTO;

    public Pricing() {
        super();
        this.pricingDTO = new PricingDTO();
    }

    public Pricing(PricingDTO pricingDTO) {
        super();
        this.pricingDTO = pricingDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("D9", "ingredientCostSubmitted");
        map.put("DC", "dispensingFeeSubmitted");
        map.put("BE", "professionalServiceFeeSubmitted");
        map.put("DX", "patientPaidAmountSubmitted");
        map.put("E3", "incentiveAmountSubmitted");
        map.put("H7", "otherAmountClaimedSubmittedCount");
        map.put("H8", "otherAmountClaimedSubmittedQualifier");
        map.put("H9", "otherAmountClaimedSubmitted");
        map.put("HA", "flatSalesTaxAmountSubmitted");
        map.put("GE", "percentageSalesTaxAmountSubmitted");
        map.put("HE", "percentageSalesTaxRateSubmitted");
        map.put("JE", "percentageSalesTaxBasisSubmitted");
        map.put("DQ", "usualAndCustomaryCharge");
        map.put("DU", "grossAmountDue");
        map.put("DN", "basisOfCostDetermination");
        return Collections.unmodifiableMap(map);
    }

    public PricingDTO setDTOValues(Map<String, Object> values) {
        mapper.updatePricingDTOFromMap(values, pricingDTO);
        setSegmentIdentification(pricingDTO);
        return this.pricingDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromPricingDTO(pricingDTO, values);
        return values;
    }

    private static class PricingMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<PricingDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("D9", PricingDTO::setIngredientCostSubmitted);
            FIELD_SETTERS.put("DC", PricingDTO::setDispensingFeeSubmitted);
            FIELD_SETTERS.put("BE", PricingDTO::setProfessionalServiceFeeSubmitted);
            FIELD_SETTERS.put("DX", PricingDTO::setPatientPaidAmountSubmitted);
            FIELD_SETTERS.put("E3", PricingDTO::setIncentiveAmountSubmitted);
            FIELD_SETTERS.put("H7", PricingDTO::setOtherAmountClaimedSubmittedCount);
            FIELD_SETTERS.put("H8", PricingDTO::setOtherAmountClaimedSubmittedQualifier);
            FIELD_SETTERS.put("H9", PricingDTO::setOtherAmountClaimedSubmitted);
            FIELD_SETTERS.put("HA", PricingDTO::setFlatSalesTaxAmountSubmitted);
            FIELD_SETTERS.put("GE", PricingDTO::setPercentageSalesTaxAmountSubmitted);
            FIELD_SETTERS.put("HE", PricingDTO::setPercentageSalesTaxRateSubmitted);
            FIELD_SETTERS.put("JE", PricingDTO::setPercentageSalesTaxBasisSubmitted);
            FIELD_SETTERS.put("DQ", PricingDTO::setUsualAndCustomaryCharge);
            FIELD_SETTERS.put("DU", PricingDTO::setGrossAmountDue);
            FIELD_SETTERS.put("DN", PricingDTO::setBasisOfCostDetermination);
        }

        public void updatePricingDTOFromMap(Map<String, Object> values, PricingDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<PricingDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromPricingDTO(PricingDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "D9", dto.getIngredientCostSubmitted());
            putIfNotNull(values, "DC", dto.getDispensingFeeSubmitted());
            putIfNotNull(values, "BE", dto.getProfessionalServiceFeeSubmitted());
            putIfNotNull(values, "DX", dto.getPatientPaidAmountSubmitted());
            putIfNotNull(values, "E3", dto.getIncentiveAmountSubmitted());
            putIfNotNull(values, "H7", dto.getOtherAmountClaimedSubmittedCount());
            putIfNotNull(values, "H8", dto.getOtherAmountClaimedSubmittedQualifier());
            putIfNotNull(values, "H9", dto.getOtherAmountClaimedSubmitted());
            putIfNotNull(values, "HA", dto.getFlatSalesTaxAmountSubmitted());
            putIfNotNull(values, "GE", dto.getPercentageSalesTaxAmountSubmitted());
            putIfNotNull(values, "HE", dto.getPercentageSalesTaxRateSubmitted());
            putIfNotNull(values, "JE", dto.getPercentageSalesTaxBasisSubmitted());
            putIfNotNull(values, "DQ", dto.getUsualAndCustomaryCharge());
            putIfNotNull(values, "DU", dto.getGrossAmountDue());
            putIfNotNull(values, "DN", dto.getBasisOfCostDetermination());
        }
    }
}
