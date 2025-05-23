package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseInsuranceAdditionalDocumentationDTO extends SegmentDTO {
    private String medicarePartDCoverageCode;
    private String cmsLowIncomeCostSharingLicsLevel;
    private String contractNumber;
    private String formularyId;
    private String benefitId;
    private String nextMedicarePartDEffectiveDate;
    private String nextMedicarePartDTerminationDate;
}
