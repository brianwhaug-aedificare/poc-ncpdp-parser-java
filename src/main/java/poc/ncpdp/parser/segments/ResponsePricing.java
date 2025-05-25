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

        private static final Map<String, java.util.function.Function<ResponsePricingDTO, Object>> FIELD_GETTERS = Map.ofEntries(
            Map.entry("F5", ResponsePricingDTO::getGrossAmountDue),
            Map.entry("F6", ResponsePricingDTO::getIngredientCostPaid),
            Map.entry("F7", ResponsePricingDTO::getDispensingFeePaid),
            Map.entry("AV", ResponsePricingDTO::getTaxExemptIndicator),
            Map.entry("AW", ResponsePricingDTO::getFlatSalesTaxAmountPaid),
            Map.entry("AX", ResponsePricingDTO::getPercentageSalesTaxAmountPaid),
            Map.entry("AY", ResponsePricingDTO::getPercentageSalesTaxRatePaid),
            Map.entry("AZ", ResponsePricingDTO::getPercentageSalesTaxBasisPaid),
            Map.entry("FL", ResponsePricingDTO::getIncentiveAmountPaid),
            Map.entry("J1", ResponsePricingDTO::getProfessionalServiceFeePaid),
            Map.entry("J2", ResponsePricingDTO::getOtherAmountPaidCount),
            Map.entry("J3", ResponsePricingDTO::getOtherAmountPaidQualifier),
            Map.entry("J4", ResponsePricingDTO::getOtherAmountPaid),
            Map.entry("J5", ResponsePricingDTO::getOtherPayerAmountRecognized),
            Map.entry("F9", ResponsePricingDTO::getTotalAmountPaid),
            Map.entry("FM", ResponsePricingDTO::getBasisOfReimbursementDetermination),
            Map.entry("FN", ResponsePricingDTO::getAmountAttributedToSalesTax),
            Map.entry("FC", ResponsePricingDTO::getAccumulatedDeductibleAmount),
            Map.entry("FD", ResponsePricingDTO::getRemainingDeductibleAmount),
            Map.entry("FE", ResponsePricingDTO::getRemainingBenefitAmount),
            Map.entry("FH", ResponsePricingDTO::getAmountAppliedToPeriodicDeductible),
            Map.entry("FI", ResponsePricingDTO::getAmountOfCopay),
            Map.entry("FK", ResponsePricingDTO::getAmountExceedingPeriodicBenefitMaximum),
            Map.entry("HH", ResponsePricingDTO::getBasisOfCalculationDispensingFee),
            Map.entry("HJ", ResponsePricingDTO::getBasisOfCalculationCopay),
            Map.entry("HK", ResponsePricingDTO::getBasisOfCalculationFlatSalesTax),
            Map.entry("HM", ResponsePricingDTO::getBasisOfCalculationPercentageSalesTax),
            Map.entry("NZ", ResponsePricingDTO::getAmountAttributedToProcessorFee),
            Map.entry("EQ", ResponsePricingDTO::getPatientSalesTaxAmount),
            Map.entry("2Y", ResponsePricingDTO::getPlanSalesTaxAmount),
            Map.entry("4U", ResponsePricingDTO::getAmountOfCoinsurance),
            Map.entry("4V", ResponsePricingDTO::getBasisOfCalculationCoinsurance),
            Map.entry("MU", ResponsePricingDTO::getBenefitStageCount),
            Map.entry("MV", ResponsePricingDTO::getBenefitStageQualifier),
            Map.entry("MW", ResponsePricingDTO::getBenefitStageAmount),
            Map.entry("G3", ResponsePricingDTO::getEstimatedGenericSavings),
            Map.entry("UC", ResponsePricingDTO::getSpendingAccountAmountRemaining),
            Map.entry("UD", ResponsePricingDTO::getHealthPlanFundedAssistanceAmount),
            Map.entry("UJ", ResponsePricingDTO::getAmountAttributedToProviderNetworkSelection),
            Map.entry("UK", ResponsePricingDTO::getAmountAttributedToProductSelectionBrandDrug),
            Map.entry("UM", ResponsePricingDTO::getAmountAttributedToProductSelectionNonPreferredFormularySelection),
            Map.entry("UN", ResponsePricingDTO::getAmountAttributedToProductSelectionBrandNonPreferredFormularySelection),
            Map.entry("UP", ResponsePricingDTO::getAmountAttributedToCoverageGap),
            Map.entry("U8", ResponsePricingDTO::getIngredientCostContractedReimbursableAmount),
            Map.entry("U9", ResponsePricingDTO::getDispensingFeeContractedReimbursableAmount)
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
            FIELD_GETTERS.forEach((key, getter) -> {
                Object value = getter.apply(dto);
                if (value != null) {
                    values.put(key, value);
                }
            });
        }
    }
}
