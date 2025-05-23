package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NarrativeDTO extends SegmentDTO {
    private String narrativeMessage;
}
