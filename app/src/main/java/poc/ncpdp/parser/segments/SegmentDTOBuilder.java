package poc.ncpdp.parser.segments;

import java.util.Map;

import poc.ncpdp.data.segments.SegmentDTO;

public interface SegmentDTOBuilder {

    public SegmentDTO setDTOValues(Map<String, Object> values);
    
}
