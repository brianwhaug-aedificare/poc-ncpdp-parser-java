package poc.ncpdp.parser.segments;

import poc.ncpdp.data.segments.SegmentDTO;

public class SegmentDTOBuilderFactory {

    public static SegmentDTOBuilder getBuilder(SegmentDTO segmentDTO) {
        try {
            // Find a constructor that takes the DTO as an argument
            String segmentIndification = segmentDTO.getSegmentIdentification();
            Class<? extends SegmentDTOBuilder> builderClass = SegmentRegistry.segmentIdToKlass.get(segmentIndification);
            if (builderClass == null) {
                throw new IllegalArgumentException("No builder class found for segment identification: " + segmentIndification);
            }
            // Create an instance of the builder class using reflection
            // and pass the DTO to its constructor
            // This assumes that the builder class has a constructor that takes the DTO as an argument
            // and that the builder class implements SegmentDTOBuilder
            return (SegmentDTOBuilder) builderClass.getDeclaredConstructor(segmentDTO.getClass()).newInstance(segmentDTO);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create SegmentDTOBuilder instance with DTO", e);
        }
    }
}
