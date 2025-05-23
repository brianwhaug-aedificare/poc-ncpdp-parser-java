package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseInsuranceDTO extends SegmentDTO {
    private String groupId;
    private String planId;
    private String networkReimbursementId;
    private String payerIdQualifier;
    private String payerId;
    private String medicaidIdNumber;
    private String medicaidAgencyNumber;
    private String cardholderId;
}
