package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseClaimDTO extends SegmentDTO {
    private String prescriptionReferenceNumberQualifier;
    private String prescriptionReferenceNumber;
    private String preferredProductCount;
    private String preferredProductIdQualifier;
    private String preferredProductId;
    private String preferredProductIncentive;
    private String preferredProductCostShareIncentive;
    private String preferredProductDescription;
    private String medicadeIcn;
}
