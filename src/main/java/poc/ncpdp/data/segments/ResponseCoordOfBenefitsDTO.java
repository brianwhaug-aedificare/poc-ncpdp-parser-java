package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseCoordOfBenefitsDTO extends SegmentDTO {
    private String otherPayerIdCount;
    private String otherPayerCoverageType;
    private String otherPayerIdQualifier;
    private String otherPayerId;
    private String otherPayerProcessorControlNumber;
    private String otherPayerCardholderId;
    private String otherPayerGroupId;
    private String otherPayerPersonCode;
    private String otherPayerHelpDeskPhoneNumber;
    private String otherPayerPatientRelationshipCode;
    private String otherPayerBenefitEffectiveDate;
    private String otherPayerBenefitTerminationDate;
}
