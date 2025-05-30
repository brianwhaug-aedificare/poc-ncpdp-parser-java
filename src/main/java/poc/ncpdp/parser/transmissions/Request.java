package poc.ncpdp.parser.transmissions;

import java.util.List;
import lombok.Getter;

import poc.ncpdp.parser.Constants;
import poc.ncpdp.parser.segments.SegmentBase;
import poc.ncpdp.parser.segments.concerns.Serializer;
import poc.ncpdp.parser.transmissions.groups.TransmissionGroup;
import poc.ncpdp.parser.utils.FixedWidth;
import poc.ncpdp.parser.transmissions.concerns.SegmentsMethods;
import poc.ncpdp.parser.transmissions.groups.TransactionGroup;

@Getter
public class Request implements Transmission, SegmentsMethods, Serializer {
    
    protected final RequestHeader header;
    protected final TransmissionGroup transmissionGroup;
    protected final List<TransactionGroup> transactionGroups;
    protected final List<SegmentBase> segments;

    public Request(RequestHeader header, TransmissionGroup transmissionGroup,
            List<TransactionGroup> transactionGroups, List<SegmentBase> segments) {
            this.header = header;
        this.transmissionGroup = transmissionGroup;
        this.transactionGroups = transactionGroups;
        this.segments = segments != null ? segments : new java.util.ArrayList<>();
        if (!this.segments.isEmpty()) {
            sortSegments(this.segments, transmissionGroup, transactionGroups);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FixedWidth.toFixedWidth(header.getHeader(), RequestHeaderSchema.getHeaderSchema()));
        sb.append(Constants.SEGMENT_SEPARATOR);
        sb.append(transmissionGroup.toString());
        for (TransactionGroup group : transactionGroups) {
            sb.append(group.toString());
        }
        return sb.toString();
    }
    
    public TransmissionHeader getHeader() {
        return header;
    }
}
