package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PricingDTO extends SegmentDTO {
    private String ingredientCostSubmitted;
    private String dispensingFeeSubmitted;
    private String professionalServiceFeeSubmitted;
    private String patientPaidAmountSubmitted;
    private String incentiveAmountSubmitted;
    private String otherAmountClaimedSubmittedCount;
    private String otherAmountClaimedSubmittedQualifier;
    private String otherAmountClaimedSubmitted;
    private String flatSalesTaxAmountSubmitted;
    private String percentageSalesTaxAmountSubmitted;
    private String percentageSalesTaxRateSubmitted;
    private String percentageSalesTaxBasisSubmitted;
    private String usualAndCustomaryCharge;
    private String grossAmountDue;
    private String basisOfCostDetermination;
}
