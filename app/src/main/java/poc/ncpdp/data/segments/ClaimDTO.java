package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClaimDTO extends SegmentDTO {
    private String prescriptionReferenceNumberQualifier;
    private String prescriptionReferenceNumber;
    private String productServiceIdQualifier;
    private String productServiceId;
    private String associatedPrescriptionReferenceNumber;
    private String associatedPrescriptionDate;
    private String procedureModifierCodeCount;
    private String procedureModifierCode;
    private String quantityDispensed;
    private String fillNumber;
    private String daysSupply;
    private String compoundCode;
    private String dispenseAsWrittenProductSelectionCode;
    private String datePrescriptionWritten;
    private String numberOfRefillsAuthorized;
    private String prescriptionOriginCode;
    private String submissionClarificationCodeCount;
    private String submissionClarificationCode;
    private String quantityPrescribed;
    private String otherCoverageCode;
    private String specialPackagingIndicator;
    private String originallyPrescribedIdQualifier;
    private String originallyPrescribedCode;
    private String originallyPrescribedQuantity;
    private String alternateId;
    private String scheduledPrescriptionIdNumber;
    private String unitOfMeasure;
    private String levelOfService;
    private String priorAuthorizationTypeCode;
    private String priorAuthorizationNumberSubmitted;
    private String intermediaryAuthorizationTypeId;
    private String intermediaryAuthorizationId;
    private String dispensingStatus;
    private String quantityIntendedToBeDispensed;
    private String daysSupplyIntendedToBeDispensed;
    private String delayReasonCode;
    private String transactionReferenceNumber;
    private String patientAssignmentIndicator;
    private String routeOfAdministration;
    private String compoundType;
    private String medicadeIcn;
    private String pharmacyServiceType;
}
