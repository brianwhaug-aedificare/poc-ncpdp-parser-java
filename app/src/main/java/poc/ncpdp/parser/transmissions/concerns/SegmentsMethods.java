package poc.ncpdp.parser.transmissions.concerns;

import java.util.List;
import java.util.stream.Collectors;

import poc.ncpdp.parser.segments.SegmentBase;
import poc.ncpdp.parser.transmissions.groups.TransactionGroup;
import poc.ncpdp.parser.transmissions.groups.TransmissionGroup;

public interface SegmentsMethods {
    List<String> TRANSMISSION_LEVEL_SEGMENTS = List.of(
        "patient",
        "insurance",
        "response_message",
        "response_insurance",
        "response_patient"
    );

    List<String> TRANSACTION_LEVEL_SEGMENTS = List.of(
        "pharmacy_provider",
        "prescriber",
        "coord_of_benefits",
        "workers_comp",
        "claim",
        "dur_pps",
        "coupon",
        "compound",
        "pricing",
        "prior_auth",
        "clinical",
        "additional_documentation",
        "facility",
        "narrative",
        "response_status",
        "response_claim",
        "response_pricing",
        "response_dur_pps",
        "response_prior_auth",
        "response_additional_documentation",
        "response_coord_of_benefits"
    );

    default SegmentBase getSegment(Class<? extends SegmentBase> segmentKlass) {
        throw new UnsupportedOperationException("Implement segment lookup/creation logic");
    }

    default void sortSegments(List<SegmentBase> segments, TransmissionGroup transmissionGroup, List<TransactionGroup> transactionGroups) {
        for (SegmentBase segment : segments) {
            String segmentSym = segment.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
            if (TRANSMISSION_LEVEL_SEGMENTS.contains(segmentSym)) {
                transmissionGroup.getSegments().add(segment);
            } else {
                if (transactionGroups.isEmpty()) {
                    transactionGroups.add(new TransactionGroup(new java.util.ArrayList<>(),new java.util.ArrayList<>()));
                }
                transactionGroups.get(0).getSegments().add(segment);
            }
        }
    }

    default List<SegmentBase> segments(TransmissionGroup transmissionGroup, List<TransactionGroup> transactionGroups) {
        List<SegmentBase> all = transmissionGroup.getSegments().stream().collect(Collectors.toList());
        for (TransactionGroup group : transactionGroups) {
            all.addAll(group.getSegments());
        }
        return all.stream().filter(s -> s != null).collect(Collectors.toList());
    }
}
