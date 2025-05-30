package poc.ncpdp.parser.transmissions.concerns;

import java.util.List;
import java.util.Map;

import poc.ncpdp.data.transmissions.RequestDTO;
import poc.ncpdp.data.transmissions.ResponseDTO;
import poc.ncpdp.data.transmissions.TransactionGroupDTO;
import poc.ncpdp.data.transmissions.TransmissionGroupDTO;
import poc.ncpdp.parser.Constants;
import poc.ncpdp.parser.segments.SegmentDTOBuilder;
import poc.ncpdp.parser.segments.SegmentRegistry;
import poc.ncpdp.parser.segments.concerns.SegmentBuilder;
import poc.ncpdp.parser.transmissions.RequestHeader;
import poc.ncpdp.parser.transmissions.RequestHeaderSchema;
import poc.ncpdp.parser.transmissions.ResponseHeader;
import poc.ncpdp.parser.transmissions.ResponseHeaderSchema;
import poc.ncpdp.parser.utils.FixedWidth;

/**
 * Builds request and response transmission strings for NCPDP.
 *
 * <p>See: docs/ncpdp/diagrams/transmission_general_syntax.png for the general transmission syntax diagram.
 */
public interface Builder {
    /**
     * Builds a request transmission string as an ASCII (7 bit) by
     * taking in the RequestDTO object and converting it to a string
     * using the appropriate Domain to DTO mapping.
     */
    static String buildRequest(RequestDTO request) {
        StringBuilder sb = new StringBuilder();

        RequestHeader header = new RequestHeader(request.getRequestHeader());
        sb.append(FixedWidth.toFixedWidth(header.getHeader(), RequestHeaderSchema.getHeaderSchema()));
        sb.append(Constants.SEGMENT_SEPARATOR);

        sb.append(buildTransmission(request.getTransmissionGroup()));
        sb.append(buildTransactions(request.getTransactionGroups()));

        return sb.toString();
    }

    static String buildResponse(ResponseDTO response) {
        StringBuilder sb = new StringBuilder();

        ResponseHeader header = new ResponseHeader(response.getResponseHeader());
        sb.append(FixedWidth.toFixedWidth(header.getHeader(), ResponseHeaderSchema.getHeaderSchema()));
        sb.append(Constants.SEGMENT_SEPARATOR);

        sb.append(buildTransmission(response.getTransmissionGroup()));
        sb.append(buildTransactions(response.getTransactionGroups()));

        return sb.toString();
    }

    private static String buildTransmission(TransmissionGroupDTO transmissionGroup) {
        StringBuilder sb = new StringBuilder();
        for (var transmissiongSegmentDTO : transmissionGroup.getSegments()) {
            // Find the correct builder for the segment type
            SegmentDTOBuilder builder = SegmentRegistry.getBuilder(transmissiongSegmentDTO);
            if (builder != null) {
                // populates the Domain object with the DTO values
                Map<String, Object> values = builder.getDTOValues();
                String segmentString = SegmentBuilder.buildSegment(values);
                sb.append(segmentString);
            } else {
                throw new IllegalArgumentException(
                        "No builder found for segment: " + transmissiongSegmentDTO.getClass().getSimpleName());
            }
        }
        // Remove trailing segment separator if present
        return removeTrailingSegmentSeparator(sb.toString());
    }

    private static String buildTransactions(List<TransactionGroupDTO> transactionGroups) {
        StringBuilder sb = new StringBuilder();
        for (var transactionGroup : transactionGroups) {
            sb.append(Constants.GROUP_SEPARATOR);
            sb.append(Constants.SEGMENT_SEPARATOR);
            for (var transactionSegmentDTO : transactionGroup.getSegments()) {
                // Find the correct builder for the segment type
                SegmentDTOBuilder builder = SegmentRegistry.getBuilder(transactionSegmentDTO);
                if (builder != null) {
                    // populates the Domain object with the DTO values
                    Map<String, Object> values = builder.getDTOValues();
                    String segmentString = SegmentBuilder.buildSegment(values);
                    sb.append(segmentString);
                } else {
                    throw new IllegalArgumentException(
                            "No builder found for segment: " + transactionSegmentDTO.getClass().getSimpleName());
                }
            }
        }
        // Remove trailing segment separator if present
        return removeTrailingSegmentSeparator(sb.toString());
    }

    private static String removeTrailingSegmentSeparator(String result) {
        if (result.endsWith(Constants.SEGMENT_SEPARATOR)) {
            result = result.substring(0, result.length() - Constants.SEGMENT_SEPARATOR.length());
        }
        return result;
    }
}
