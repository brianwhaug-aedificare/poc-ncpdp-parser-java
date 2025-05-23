package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponsePriorAuthDTO extends SegmentDTO {
    private String priorAuthorizationProcessedDate;
    private String priorAuthorizationEffectiveDate;
    private String priorAuthorizationExpirationDate;
    private String priorAuthorizationQuantity;
    private String priorAuthorizationDollarsAuthorized;
    private String priorAuthorizationNumberOfRefillsAuthorized;
    private String priorAuthorizationQuantityAccumulated;
    private String priorAuthorizationNumberAssigned;
}
