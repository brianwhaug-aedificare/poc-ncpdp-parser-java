package poc.ncpdp.data.transmissions;

import poc.ncpdp.data.segments.SegmentDTO;
import java.util.List;

public class TransmissionGroupDTO {
    List<SegmentDTO> segments;

    public TransmissionGroupDTO(List<SegmentDTO> segments) {
        this.segments = segments;
    }
}
