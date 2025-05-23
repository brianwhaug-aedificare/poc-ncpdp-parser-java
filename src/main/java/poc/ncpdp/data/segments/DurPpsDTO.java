package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DurPpsDTO extends SegmentDTO {
    private String durPpsCodeCounter;
    private String reasonForServiceCode;
    private String professionalServiceCode;
    private String resultOfServiceCode;
    private String durPpsLevelOfEffort;
    private String durCoAgentIdQualifier;
    private String durCoAgentId;
}
