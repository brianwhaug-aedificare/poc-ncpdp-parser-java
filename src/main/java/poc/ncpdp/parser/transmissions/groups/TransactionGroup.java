package poc.ncpdp.parser.transmissions.groups;

import java.util.List;

import poc.ncpdp.data.segments.SegmentDTO;
import poc.ncpdp.parser.segments.SegmentBase;

public class TransactionGroup extends GroupBase {
    public TransactionGroup(List<SegmentBase> segments, List<SegmentDTO> dtos) {
        super(segments, dtos);
    }
}
