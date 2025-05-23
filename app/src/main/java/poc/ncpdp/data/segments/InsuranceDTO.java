package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InsuranceDTO extends SegmentDTO {
    private String cardholderId;
    private String cardholderFirstName;
    private String cardholderLastName;
    private String homePlan;
    private String planId;
    private String eligibilityClarificationCode;
    private String groupId;
    private String personCode;
    private String patientRelationshipCode;
    private String otherPayerBinNumber;
    private String otherPayerProcessorControlNumber;
    private String otherPayerCardholderId;
    private String otherPayerGroupId;
    private String medigapId;
    private String medicaidIndicator;
    private String providerAcceptAssignmentIndicator;
    private String cmsPartDDefinedQualifiedFacility;
    private String medicaidIdNumber;
    private String medicaidAgencyNumber;
}
