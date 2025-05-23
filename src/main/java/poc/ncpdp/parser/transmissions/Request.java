package poc.ncpdp.parser.transmissions;

import java.util.List;
import java.util.Map;

import poc.ncpdp.parser.Constants;
import poc.ncpdp.parser.segments.SegmentBase;
import poc.ncpdp.parser.transmissions.groups.TransmissionGroup;
import poc.ncpdp.parser.utils.FixedWidth;
import poc.ncpdp.parser.transmissions.groups.TransactionGroup;

public class Request extends TransmissionBase {
    public Request(Map<String, Object> header, TransmissionGroup transmissionGroup, List<TransactionGroup> transactionGroups, List<SegmentBase> segments) {
        super(header, transmissionGroup, transactionGroups, segments);
    }

     public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FixedWidth.toFixedWidth(header, RequestHeader.getHeaderSchema()));
        sb.append(Constants.SEGMENT_SEPARATOR);
        sb.append(transmissionGroup.toString());
        for (TransactionGroup group : transactionGroups) {
            sb.append(group.toString());
        }
        return sb.toString();
    }
}
