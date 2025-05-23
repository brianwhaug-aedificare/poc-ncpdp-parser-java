package poc.ncpdp.data.transmissions;

import java.util.List;

import poc.ncpdp.data.segments.SegmentDTO;

public class TransactionGroupDTO {
    List<SegmentDTO> segments;

    public TransactionGroupDTO(List<SegmentDTO> segments) {
        this.segments = segments;
    }

    public List<SegmentDTO> getSegments() {
        return segments;
    }
}
