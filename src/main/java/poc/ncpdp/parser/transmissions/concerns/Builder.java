package poc.ncpdp.parser.transmissions.concerns;

import java.util.Map;

import poc.ncpdp.data.transmissions.RequestDTO;
import poc.ncpdp.data.transmissions.TransmissionGroupDTO;
import poc.ncpdp.parser.Constants;
import poc.ncpdp.parser.segments.SegmentDTOBuilder;
import poc.ncpdp.parser.segments.SegmentDTOBuilderFactory;
import poc.ncpdp.parser.segments.concerns.SegmentBuilder;
import poc.ncpdp.parser.transmissions.RequestHeader;
import poc.ncpdp.parser.utils.FixedWidth;

public interface Builder {
    /**
     * Builds a request transmission string as an ASCII (7 bit) by
     * taking in the RequestDTO object and converting it to a string
     * using the appropriate Domain to DTO mapping.
     */
    static String buildRequest(RequestDTO request) {
        StringBuilder sb = new StringBuilder();
        SegmentDTOBuilder builder;

        // build header
        RequestHeader header = new RequestHeader(request.getRequestHeader());
        sb.append(FixedWidth.toFixedWidth(header.getHeader(), RequestHeader.getHeaderSchema()));
        sb.append(Constants.SEGMENT_SEPARATOR);

        // build transmission group
        TransmissionGroupDTO transmissionGroup = request.getTransmissionGroup();
        StringBuilder transmission = new StringBuilder();
        for (var transmissiongSegmentDTO : transmissionGroup.getSegments()) {
            // Find the correct builder for the segment type
            builder = SegmentDTOBuilderFactory.getBuilder(transmissiongSegmentDTO);
            if (builder != null) {
                // populates the Domain object with the DTO values
                Map<String, Object> values = builder.getDTOValues();
                String segmentString = SegmentBuilder.buildSegment(values);
                System.out.println("Builder Segment String: " + segmentString);
                transmission.append(segmentString);
            } else {
                throw new IllegalArgumentException(
                        "No builder found for segment: " + transmissiongSegmentDTO.getClass().getSimpleName());
            }
        }
        String result = transmission.toString();
        if (result.endsWith(Constants.SEGMENT_SEPARATOR)) {
            result = result.substring(0, result.length() - Constants.SEGMENT_SEPARATOR.length());
        }
        sb.append(result);

        // Build transaction groups
        for (var transactionGroup : request.getTransactionGroups()) {
            sb.append(Constants.GROUP_SEPARATOR);
            sb.append(Constants.SEGMENT_SEPARATOR);
            for (var transactionSegmentDTO : transactionGroup.getSegments()) {
                // Find the correct builder for the segment type
                builder = SegmentDTOBuilderFactory.getBuilder(transactionSegmentDTO);
                StringBuilder transaction = new StringBuilder();
                if (builder != null) {
                    // populates the Domain object with the DTO values
                    Map<String, Object> values = builder.getDTOValues();
                    String segmentString = SegmentBuilder.buildSegment(values);
                    System.out.println("Builder Segment String: " + segmentString);
                    transaction.append(segmentString);
                } else {
                    throw new IllegalArgumentException(
                            "No builder found for segment: " + transactionSegmentDTO.getClass().getSimpleName());
                }
                sb.append(transaction.toString());
            }
        }
        result = sb.toString();
        if (result.endsWith(Constants.SEGMENT_SEPARATOR)) {
            result = result.substring(0, result.length() - Constants.SEGMENT_SEPARATOR.length());
        }
        return result;
    }
}
