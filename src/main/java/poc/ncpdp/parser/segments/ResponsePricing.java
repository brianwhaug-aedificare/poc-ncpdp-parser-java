package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponsePricingDTO;

public class ResponsePricing extends SegmentBase {
    private final ResponsePricingMapper mapper = new ResponsePricingMapper();
    private ResponsePricingDTO responsePricingDTO;

    public ResponsePricing() {
        super();
        this.responsePricingDTO = new ResponsePricingDTO();
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

    private class ResponsePricingMapper {
        public void updateResponsePricingDTOFromMap(Map<String, Object> values, ResponsePricingDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "F5": dto.setGrossAmountDue(value); break;
                    case "F6": dto.setIngredientCostPaid(value); break;
                    case "F7": dto.setDispensingFeePaid(value); break;
                    case "AV": dto.setTaxExemptIndicator(value); break;
                    case "AW": dto.setFlatSalesTaxAmountPaid(value); break;
                    case "AX": dto.setPercentageSalesTaxAmountPaid(value); break;
                    case "AY": dto.setPercentageSalesTaxRatePaid(value); break;
                    case "AZ": dto.setPercentageSalesTaxBasisPaid(value); break;
                    case "FL": dto.setIncentiveAmountPaid(value); break;
                    case "J1": dto.setProfessionalServiceFeePaid(value); break;
                    case "J2": dto.setOtherAmountPaidCount(value); break;
                    case "J3": dto.setOtherAmountPaidQualifier(value); break;
                    case "J4": dto.setOtherAmountPaid(value); break;
                    case "J5": dto.setOtherPayerAmountRecognized(value); break;
                    case "F9": dto.setTotalAmountPaid(value); break;
                    case "FM": dto.setBasisOfReimbursementDetermination(value); break;
                    case "FN": dto.setAmountAttributedToSalesTax(value); break;
                    case "FC": dto.setAccumulatedDeductibleAmount(value); break;
                    case "FD": dto.setRemainingDeductibleAmount(value); break;
                    case "FE": dto.setRemainingBenefitAmount(value); break;
                    case "FH": dto.setAmountAppliedToPeriodicDeductible(value); break;
                    case "FI": dto.setAmountOfCopay(value); break;
                    case "FK": dto.setAmountExceedingPeriodicBenefitMaximum(value); break;
                    case "HH": dto.setBasisOfCalculationDispensingFee(value); break;
                    case "HJ": dto.setBasisOfCalculationCopay(value); break;
                    case "HK": dto.setBasisOfCalculationFlatSalesTax(value); break;
                    case "HM": dto.setBasisOfCalculationPercentageSalesTax(value); break;
                    case "NZ": dto.setAmountAttributedToProcessorFee(value); break;
                    case "EQ": dto.setPatientSalesTaxAmount(value); break;
                    case "2Y": dto.setPlanSalesTaxAmount(value); break;
                    case "4U": dto.setAmountOfCoinsurance(value); break;
                    case "4V": dto.setBasisOfCalculationCoinsurance(value); break;
                    case "MU": dto.setBenefitStageCount(value); break;
                    case "MV": dto.setBenefitStageQualifier(value); break;
                    case "MW": dto.setBenefitStageAmount(value); break;
                    case "G3": dto.setEstimatedGenericSavings(value); break;
                    case "UC": dto.setSpendingAccountAmountRemaining(value); break;
                    case "UD": dto.setHealthPlanFundedAssistanceAmount(value); break;
                    case "UJ": dto.setAmountAttributedToProviderNetworkSelection(value); break;
                    case "UK": dto.setAmountAttributedToProductSelectionBrandDrug(value); break;
                    case "UM": dto.setAmountAttributedToProductSelectionNonPreferredFormularySelection(value); break;
                    case "UN": dto.setAmountAttributedToProductSelectionBrandNonPreferredFormularySelection(value); break;
                    case "UP": dto.setAmountAttributedToCoverageGap(value); break;
                    case "U8": dto.setIngredientCostContractedReimbursableAmount(value); break;
                    case "U9": dto.setDispensingFeeContractedReimbursableAmount(value); break;
                }
            }
        }
    }
}
