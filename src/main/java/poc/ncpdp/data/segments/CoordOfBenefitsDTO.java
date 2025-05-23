package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CoordOfBenefitsDTO extends SegmentDTO {
    private String coordinationOfBenefitsOtherPaymentsCount;
    private String otherPayerCoverageType;
    private String otherPayerIdQualifier;
    private String otherPayerId;
    private String otherPayerDate;
    private String internalControlNumber;
    private String otherPayerAmountPaidCount;
    private String otherPayerAmountPaidQualifier;
    private String otherPayerAmountPaid;
    private String otherPayerRejectCount;
    private String otherPayerRejectCode;
    private String otherPayerPatientResponsibilityAmountCount;
    private String otherPayerPatientResponsibilityAmountQualifier;
    private String otherPayerPatientResponsibilityAmount;
    private String benefitStageCount;
    private String benefitStageQualifier;
    private String benefitStageAmount;
}
