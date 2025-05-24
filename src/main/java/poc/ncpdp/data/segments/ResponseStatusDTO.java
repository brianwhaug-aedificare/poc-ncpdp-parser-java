package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseStatusDTO extends SegmentDTO {
    private String responseStatus;
    private String authorizationNumber;
    private String rejectCount;
    private String rejectCode;
    private String rejectFieldOccurrenceIndicator;
    private String approvedMessageCodeCount;
    private String approvedMessageCode;
    private String additionalMessageInformationCount;
    private String additionalMessageInformationQualifier;
    private String additionalMessageInformation;
    private String additionalMessageInformationContinuity;
    private String helpDeskPhoneNumberQualifier;
    private String helpDeskPhoneNumber;
    private String transactionReferenceNumber;
    private String internalControlNumber;
    private String url;
}
