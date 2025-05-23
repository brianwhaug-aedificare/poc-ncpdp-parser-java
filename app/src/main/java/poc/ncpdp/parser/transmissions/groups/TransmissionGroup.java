package poc.ncpdp.parser.transmissions.groups;

import java.util.List;
import java.util.stream.Collectors;

import poc.ncpdp.data.segments.SegmentDTO;
import poc.ncpdp.parser.Constants;
import poc.ncpdp.parser.segments.SegmentBase;

public class TransmissionGroup extends GroupBase {
    public TransmissionGroup(List<SegmentBase> segments, List<SegmentDTO> dtos) {
        super(segments, dtos);
    }

    @Override
    public String toString() {
        String result = segments.stream().map(Object::toString).collect(Collectors.joining());
        if (result.endsWith(Constants.SEGMENT_SEPARATOR)) {
            result = result.substring(0, result.length() - Constants.SEGMENT_SEPARATOR.length());
        }
        return result;
    }
}
