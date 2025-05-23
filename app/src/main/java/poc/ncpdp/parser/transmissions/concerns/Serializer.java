package poc.ncpdp.parser.transmissions.concerns;

import java.util.List;
import java.util.Map;

public interface Serializer {
    static Map<String, Object> toJson(Map<String, Object> header, Object transmissionGroup, List<?> transactionGroups, Map<String, Object> options) {
        return Map.of(
            "header", header,
            "transmission_group", transmissionGroup instanceof JsonSerializable ? ((JsonSerializable) transmissionGroup).toJson(options) : transmissionGroup,
            "transaction_groups", transactionGroups.stream().map(g -> g instanceof JsonSerializable ? ((JsonSerializable) g).toJson(options) : g).toList()
        );
    }

    interface JsonSerializable {
        Map<String, Object> toJson(Map<String, Object> options);
    }
}
