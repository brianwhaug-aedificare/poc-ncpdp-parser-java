package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponsePricingDTO;

public class ResponsePricing extends SegmentBase {
    private final ResponsePricingMapper mapper = new ResponsePricingMapper();
    private ResponsePricingDTO responsePricingDTO;

    public ResponsePricing() {
        super();
        this.responsePricingDTO = new ResponsePricingDTO();
    }

    public ResponsePricing(ResponsePricingDTO responsePricingDTO) {
        super();
        this.responsePricingDTO = responsePricingDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("F5", "grossAmountDue");
        map.put("F6", "ingredientCostPaid");
        map.put("F7", "dispensingFeePaid");
        map.put("AV", "taxExemptIndicator");
        map.put("AW", "flatSalesTaxAmountPaid");
        map.put("AX", "percentageSalesTaxAmountPaid");
        map.put("AY", "percentageSalesTaxRatePaid");
        map.put("AZ", "percentageSalesTaxBasisPaid");
        map.put("FL", "incentiveAmountPaid");
        map.put("J1", "professionalServiceFeePaid");
        map.put("J2", "otherAmountPaidCount");
        map.put("J3", "otherAmountPaidQualifier");
        map.put("J4", "otherAmountPaid");
        map.put("J5", "otherPayerAmountRecognized");
        map.put("F9", "totalAmountPaid");
        map.put("FM", "basisOfReimbursementDetermination");
        map.put("FN", "amountAttributedToSalesTax");
        map.put("FC", "accumulatedDeductibleAmount");
        map.put("FD", "remainingDeductibleAmount");
        map.put("FE", "remainingBenefitAmount");
        map.put("FH", "amountAppliedToPeriodicDeductible");
        map.put("FI", "amountOfCopay");
        map.put("FK", "amountExceedingPeriodicBenefitMaximum");
        map.put("HH", "basisOfCalculationDispensingFee");
        map.put("HJ", "basisOfCalculationCopay");
        map.put("HK", "basisOfCalculationFlatSalesTax");
        map.put("HM", "basisOfCalculationPercentageSalesTax");
        map.put("NZ", "amountAttributedToProcessorFee");
        map.put("EQ", "patientSalesTaxAmount");
        map.put("2Y", "planSalesTaxAmount");
        map.put("4U", "amountOfCoinsurance");
        map.put("4V", "basisOfCalculationCoinsurance");
        map.put("MU", "benefitStageCount");
        map.put("MV", "benefitStageQualifier");
        map.put("MW", "benefitStageAmount");
        map.put("G3", "estimatedGenericSavings");
        map.put("UC", "spendingAccountAmountRemaining");
        map.put("UD", "healthPlanFundedAssistanceAmount");
        map.put("UJ", "amountAttributedToProviderNetworkSelection");
        map.put("UK", "amountAttributedToProductSelectionBrandDrug");
        map.put("UM", "amountAttributedToProductSelectionNonPreferredFormularySelection");
        map.put("UN", "amountAttributedToProductSelectionBrandNonPreferredFormularySelection");
        map.put("UP", "amountAttributedToCoverageGap");
        map.put("U8", "ingredientCostContractedReimbursableAmount");
        map.put("U9", "dispensingFeeContractedReimbursableAmount");
        return map;
    }

    public ResponsePricingDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponsePricingDTOFromMap(values, responsePricingDTO);
        setSegmentIdentification(responsePricingDTO);
        return this.responsePricingDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponsePricingDTO(responsePricingDTO, values);
        return values;
    }

    private static class ResponsePricingMapper {
        private static final Map<String, java.util.function.BiConsumer<ResponsePricingDTO, String>> FIELD_SETTERS = Map.ofEntries(
            Map.entry("F5", ResponsePricingDTO::setGrossAmountDue),
            Map.entry("F6", ResponsePricingDTO::setIngredientCostPaid),
            Map.entry("F7", ResponsePricingDTO::setDispensingFeePaid),
            Map.entry("AV", ResponsePricingDTO::setTaxExemptIndicator),
            Map.entry("AW", ResponsePricingDTO::setFlatSalesTaxAmountPaid),
            Map.entry("AX", ResponsePricingDTO::setPercentageSalesTaxAmountPaid),
            Map.entry("AY", ResponsePricingDTO::setPercentageSalesTaxRatePaid),
            Map.entry("AZ", ResponsePricingDTO::setPercentageSalesTaxBasisPaid),
            Map.entry("FL", ResponsePricingDTO::setIncentiveAmountPaid),
            Map.entry("J1", ResponsePricingDTO::setProfessionalServiceFeePaid),
            Map.entry("J2", ResponsePricingDTO::setOtherAmountPaidCount),
            Map.entry("J3", ResponsePricingDTO::setOtherAmountPaidQualifier),
            Map.entry("J4", ResponsePricingDTO::setOtherAmountPaid),
            Map.entry("J5", ResponsePricingDTO::setOtherPayerAmountRecognized),
            Map.entry("F9", ResponsePricingDTO::setTotalAmountPaid),
            Map.entry("FM", ResponsePricingDTO::setBasisOfReimbursementDetermination),
            Map.entry("FN", ResponsePricingDTO::setAmountAttributedToSalesTax),
            Map.entry("FC", ResponsePricingDTO::setAccumulatedDeductibleAmount),
            Map.entry("FD", ResponsePricingDTO::setRemainingDeductibleAmount),
            Map.entry("FE", ResponsePricingDTO::setRemainingBenefitAmount),
            Map.entry("FH", ResponsePricingDTO::setAmountAppliedToPeriodicDeductible),
            Map.entry("FI", ResponsePricingDTO::setAmountOfCopay),
            Map.entry("FK", ResponsePricingDTO::setAmountExceedingPeriodicBenefitMaximum),
            Map.entry("HH", ResponsePricingDTO::setBasisOfCalculationDispensingFee),
            Map.entry("HJ", ResponsePricingDTO::setBasisOfCalculationCopay),
            Map.entry("HK", ResponsePricingDTO::setBasisOfCalculationFlatSalesTax),
            Map.entry("HM", ResponsePricingDTO::setBasisOfCalculationPercentageSalesTax),
            Map.entry("NZ", ResponsePricingDTO::setAmountAttributedToProcessorFee),
            Map.entry("EQ", ResponsePricingDTO::setPatientSalesTaxAmount),
            Map.entry("2Y", ResponsePricingDTO::setPlanSalesTaxAmount),
            Map.entry("4U", ResponsePricingDTO::setAmountOfCoinsurance),
            Map.entry("4V", ResponsePricingDTO::setBasisOfCalculationCoinsurance),
            Map.entry("MU", ResponsePricingDTO::setBenefitStageCount),
            Map.entry("MV", ResponsePricingDTO::setBenefitStageQualifier),
            Map.entry("MW", ResponsePricingDTO::setBenefitStageAmount),
            Map.entry("G3", ResponsePricingDTO::setEstimatedGenericSavings),
            Map.entry("UC", ResponsePricingDTO::setSpendingAccountAmountRemaining),
            Map.entry("UD", ResponsePricingDTO::setHealthPlanFundedAssistanceAmount),
            Map.entry("UJ", ResponsePricingDTO::setAmountAttributedToProviderNetworkSelection),
            Map.entry("UK", ResponsePricingDTO::setAmountAttributedToProductSelectionBrandDrug),
            Map.entry("UM", ResponsePricingDTO::setAmountAttributedToProductSelectionNonPreferredFormularySelection),
            Map.entry("UN", ResponsePricingDTO::setAmountAttributedToProductSelectionBrandNonPreferredFormularySelection),
            Map.entry("UP", ResponsePricingDTO::setAmountAttributedToCoverageGap),
            Map.entry("U8", ResponsePricingDTO::setIngredientCostContractedReimbursableAmount),
            Map.entry("U9", ResponsePricingDTO::setDispensingFeeContractedReimbursableAmount)
        );

        public void updateResponsePricingDTOFromMap(Map<String, Object> values, ResponsePricingDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<ResponsePricingDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponsePricingDTO(ResponsePricingDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "F5", dto.getGrossAmountDue());
            putIfNotNull(values, "F6", dto.getIngredientCostPaid());
            putIfNotNull(values, "F7", dto.getDispensingFeePaid());
            putIfNotNull(values, "AV", dto.getTaxExemptIndicator());
            putIfNotNull(values, "AW", dto.getFlatSalesTaxAmountPaid());
            putIfNotNull(values, "AX", dto.getPercentageSalesTaxAmountPaid());
            putIfNotNull(values, "AY", dto.getPercentageSalesTaxRatePaid());
            putIfNotNull(values, "AZ", dto.getPercentageSalesTaxBasisPaid());
            putIfNotNull(values, "FL", dto.getIncentiveAmountPaid());
            putIfNotNull(values, "J1", dto.getProfessionalServiceFeePaid());
            putIfNotNull(values, "J2", dto.getOtherAmountPaidCount());
            putIfNotNull(values, "J3", dto.getOtherAmountPaidQualifier());
            putIfNotNull(values, "J4", dto.getOtherAmountPaid());
            putIfNotNull(values, "J5", dto.getOtherPayerAmountRecognized());
            putIfNotNull(values, "F9", dto.getTotalAmountPaid());
            putIfNotNull(values, "FM", dto.getBasisOfReimbursementDetermination());
            putIfNotNull(values, "FN", dto.getAmountAttributedToSalesTax());
            putIfNotNull(values, "FC", dto.getAccumulatedDeductibleAmount());
            putIfNotNull(values, "FD", dto.getRemainingDeductibleAmount());
            putIfNotNull(values, "FE", dto.getRemainingBenefitAmount());
            putIfNotNull(values, "FH", dto.getAmountAppliedToPeriodicDeductible());
            putIfNotNull(values, "FI", dto.getAmountOfCopay());
            putIfNotNull(values, "FK", dto.getAmountExceedingPeriodicBenefitMaximum());
            putIfNotNull(values, "HH", dto.getBasisOfCalculationDispensingFee());
            putIfNotNull(values, "HJ", dto.getBasisOfCalculationCopay());
            putIfNotNull(values, "HK", dto.getBasisOfCalculationFlatSalesTax());
            putIfNotNull(values, "HM", dto.getBasisOfCalculationPercentageSalesTax());
            putIfNotNull(values, "NZ", dto.getAmountAttributedToProcessorFee());
            putIfNotNull(values, "EQ", dto.getPatientSalesTaxAmount());
            putIfNotNull(values, "2Y", dto.getPlanSalesTaxAmount());
            putIfNotNull(values, "4U", dto.getAmountOfCoinsurance());
            putIfNotNull(values, "4V", dto.getBasisOfCalculationCoinsurance());
            putIfNotNull(values, "MU", dto.getBenefitStageCount());
            putIfNotNull(values, "MV", dto.getBenefitStageQualifier());
            putIfNotNull(values, "MW", dto.getBenefitStageAmount());
            putIfNotNull(values, "G3", dto.getEstimatedGenericSavings());
            putIfNotNull(values, "UC", dto.getSpendingAccountAmountRemaining());
            putIfNotNull(values, "UD", dto.getHealthPlanFundedAssistanceAmount());
            putIfNotNull(values, "UJ", dto.getAmountAttributedToProviderNetworkSelection());
            putIfNotNull(values, "UK", dto.getAmountAttributedToProductSelectionBrandDrug());
            putIfNotNull(values, "UM", dto.getAmountAttributedToProductSelectionNonPreferredFormularySelection());
            putIfNotNull(values, "UN", dto.getAmountAttributedToProductSelectionBrandNonPreferredFormularySelection());
            putIfNotNull(values, "UP", dto.getAmountAttributedToCoverageGap());
            putIfNotNull(values, "U8", dto.getIngredientCostContractedReimbursableAmount());
            putIfNotNull(values, "U9", dto.getDispensingFeeContractedReimbursableAmount());
        }
    }
}
