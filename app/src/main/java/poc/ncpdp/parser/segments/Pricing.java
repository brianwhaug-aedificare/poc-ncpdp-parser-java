package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PricingDTO;

public class Pricing extends SegmentBase {
    private final PricingMapper mapper = new PricingMapper();
    private PricingDTO pricingDTO;

    public Pricing() {
        super();
        this.pricingDTO = new PricingDTO();
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
        return this.pricingDTO;
    }

    private class PricingMapper {
        public void updatePricingDTOFromMap(Map<String, Object> values, PricingDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "D9": dto.setIngredientCostSubmitted(value); break;
                    case "DC": dto.setDispensingFeeSubmitted(value); break;
                    case "BE": dto.setProfessionalServiceFeeSubmitted(value); break;
                    case "DX": dto.setPatientPaidAmountSubmitted(value); break;
                    case "E3": dto.setIncentiveAmountSubmitted(value); break;
                    case "H7": dto.setOtherAmountClaimedSubmittedCount(value); break;
                    case "H8": dto.setOtherAmountClaimedSubmittedQualifier(value); break;
                    case "H9": dto.setOtherAmountClaimedSubmitted(value); break;
                    case "HA": dto.setFlatSalesTaxAmountSubmitted(value); break;
                    case "GE": dto.setPercentageSalesTaxAmountSubmitted(value); break;
                    case "HE": dto.setPercentageSalesTaxRateSubmitted(value); break;
                    case "JE": dto.setPercentageSalesTaxBasisSubmitted(value); break;
                    case "DQ": dto.setUsualAndCustomaryCharge(value); break;
                    case "DU": dto.setGrossAmountDue(value); break;
                    case "DN": dto.setBasisOfCostDetermination(value); break;
                }
            }
        }
    }
}
