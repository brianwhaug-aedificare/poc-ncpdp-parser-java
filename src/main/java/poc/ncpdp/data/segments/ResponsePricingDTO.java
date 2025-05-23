package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponsePricingDTO extends SegmentDTO {
    private String grossAmountDue;
    private String ingredientCostPaid;
    private String dispensingFeePaid;
    private String taxExemptIndicator;
    private String flatSalesTaxAmountPaid;
    private String percentageSalesTaxAmountPaid;
    private String percentageSalesTaxRatePaid;
    private String percentageSalesTaxBasisPaid;
    private String incentiveAmountPaid;
    private String professionalServiceFeePaid;
    private String otherAmountPaidCount;
    private String otherAmountPaidQualifier;
    private String otherAmountPaid;
    private String otherPayerAmountRecognized;
    private String totalAmountPaid;
    private String basisOfReimbursementDetermination;
    private String amountAttributedToSalesTax;
    private String accumulatedDeductibleAmount;
    private String remainingDeductibleAmount;
    private String remainingBenefitAmount;
    private String amountAppliedToPeriodicDeductible;
    private String amountOfCopay;
    private String amountExceedingPeriodicBenefitMaximum;
    private String basisOfCalculationDispensingFee;
    private String basisOfCalculationCopay;
    private String basisOfCalculationFlatSalesTax;
    private String basisOfCalculationPercentageSalesTax;
    private String amountAttributedToProcessorFee;
    private String patientSalesTaxAmount;
    private String planSalesTaxAmount;
    private String amountOfCoinsurance;
    private String basisOfCalculationCoinsurance;
    private String benefitStageCount;
    private String benefitStageQualifier;
    private String benefitStageAmount;
    private String estimatedGenericSavings;
    private String spendingAccountAmountRemaining;
    private String healthPlanFundedAssistanceAmount;
    private String amountAttributedToProviderNetworkSelection;
    private String amountAttributedToProductSelectionBrandDrug;
    private String amountAttributedToProductSelectionNonPreferredFormularySelection;
    private String amountAttributedToProductSelectionBrandNonPreferredFormularySelection;
    private String amountAttributedToCoverageGap;
    private String ingredientCostContractedReimbursableAmount;
    private String dispensingFeeContractedReimbursableAmount;
}
