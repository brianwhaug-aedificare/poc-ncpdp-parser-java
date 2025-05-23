package poc.ncpdp.parser.transmissions;

import poc.ncpdp.parser.transmissions.concerns.SegmentsMethods;
import poc.ncpdp.parser.transmissions.concerns.Serializer;
import poc.ncpdp.parser.transmissions.groups.TransactionGroup;
import poc.ncpdp.parser.transmissions.groups.TransmissionGroup;
import poc.ncpdp.parser.segments.SegmentBase;

import java.util.List;
import java.util.Map;

public abstract class TransmissionBase implements Transmission, SegmentsMethods, Serializer {
    protected final Map<String, Object> header;
    protected final TransmissionGroup transmissionGroup;
    protected final List<TransactionGroup> transactionGroups;
    protected final List<SegmentBase> segments;

    protected TransmissionBase(Map<String, Object> header, TransmissionGroup transmissionGroup, List<TransactionGroup> transactionGroups, List<SegmentBase> segments) {
        this.header = header;
        this.transmissionGroup = transmissionGroup;
        this.transactionGroups = transactionGroups;
        this.segments = segments != null ? segments : new java.util.ArrayList<>();
        if (!this.segments.isEmpty()) {
            sortSegments(this.segments, transmissionGroup, transactionGroups);
        }
    }

    public Map<String, Object> getHeader() {
        return header;
    }

    public TransmissionGroup getTransmissionGroup() {
        return transmissionGroup;
    }

    public List<TransactionGroup> getTransactionGroups() {
        return transactionGroups;
    }

    public List<SegmentBase> getSegments() {
        return segments;
    }
}
