package poc.ncpdp.parser.transmissions.groups;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import poc.ncpdp.data.segments.SegmentDTO;
import poc.ncpdp.parser.Constants;
import poc.ncpdp.parser.segments.SegmentBase;
import poc.ncpdp.parser.segments.SegmentDTOBuilder;
import poc.ncpdp.parser.segments.SegmentRegistry;

public class GroupBase {
    protected final List<SegmentBase> segments;
    protected final List<SegmentDTO> segmentDTOs;

    public GroupBase(List<SegmentBase> segments, List<SegmentDTO> dtos) {
        this.segments = segments != null ? segments : new ArrayList<>();
        this.segmentDTOs = dtos != null ? dtos : new ArrayList<>();
    }

    public static GroupBase parse(String string, String segmentSeparator) {
        String[] rawSegments = string.split(segmentSeparator);
        List<SegmentBase> segments = new ArrayList<>();
        List<SegmentDTO> segmentDTOs = new ArrayList<>();
        
        // might not be the best place to initialize all segments
        // but it is the only place where we know all segments are present
        // and we need to initialize them before parsing
        SegmentRegistry.initializeAllSegments();
        
        for (String rawSegment : rawSegments) {
            if (!rawSegment.trim().isEmpty()) {
                SegmentBase segment = SegmentBase.build(Map.of("raw", rawSegment));
                SegmentDTOBuilder builder = (SegmentDTOBuilder) segment;
                SegmentDTO dto = builder.setDTOValues(segment.getHash());

                segments.add(segment);
                segmentDTOs.add(dto);
            }
        }
        return new GroupBase(segments, segmentDTOs);
    }

    public List<SegmentBase> getSegments() {
        return segments;
    }

    public List<SegmentDTO> getSegmentDTOs() {
        return segmentDTOs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.GROUP_SEPARATOR);
        sb.append(Constants.SEGMENT_SEPARATOR);
        sb.append(segments.stream().map(Object::toString).collect(Collectors.joining()));
        // Remove trailing segment separator if present
        String result = sb.toString();
        if (result.endsWith(Constants.SEGMENT_SEPARATOR)) {
            result = result.substring(0, result.length() - Constants.SEGMENT_SEPARATOR.length());
        }
        return result;
    }

    public Map<String, Object> toJson(boolean keyGroupBySegmentSym) {
        if (keyGroupBySegmentSym) {
            return segments.stream()
                .filter(s -> s != null)
                .collect(Collectors.toMap(
                    s -> s.getClass().getSimpleName(),
                    SegmentBase::getHash,
                    (a, b) -> b
                ));
        } else {
            return Map.of("segments", segments.stream().map(SegmentBase::getHash).collect(Collectors.toList()));
        }
    }

    public SegmentBase getSegment(Class<? extends SegmentBase> segmentKlass) {
        for (SegmentBase s : segments) {
            if (segmentKlass.isInstance(s)) {
                return s;
            }
        }
        try {
            SegmentBase segment = segmentKlass.getConstructor().newInstance();
            segments.add(segment);
            return segment;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
