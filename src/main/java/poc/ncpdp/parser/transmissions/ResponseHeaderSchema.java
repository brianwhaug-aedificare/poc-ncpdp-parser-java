package poc.ncpdp.parser.transmissions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHeaderSchema {

    protected static final String VERSION = "version";
    protected static final String TRANSACTION_CODE = "transaction_code";
    protected static final String TRANSACTION_COUNT = "transaction_count";
    protected static final String HEADER_RESPONSE_STATUS = "header_response_status";
    protected static final String SERVICE_PROVIDER_ID_QUALIFIER = "service_provider_id_qualifier";
    protected static final String SERVICE_PROVIDER_ID = "service_provider_id";
    protected static final String DATE_OF_SERVICE = "date_of_service";

    private static final Map<String, Integer> schema = new LinkedHashMap<>();
    private static int headerLength = 0;

    static {
        schema.put(VERSION, 2);
        schema.put(TRANSACTION_CODE, 2);
        schema.put(TRANSACTION_COUNT, 1);
        schema.put(HEADER_RESPONSE_STATUS, 1);
        schema.put(SERVICE_PROVIDER_ID_QUALIFIER, 2);
        schema.put(SERVICE_PROVIDER_ID, 15);
        schema.put(DATE_OF_SERVICE, 8);

        headerLength = schema.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static Map<String, Object> build(String version, String transactionCode, String transactionCount,
            String headerResponseStatus, String serviceProviderIdQualifier,
            String serviceProviderId, String dateOfService) {
        Map<String, Object> header = new HashMap<>();
        header.put(VERSION, version);
        header.put(TRANSACTION_CODE, transactionCode);
        header.put(TRANSACTION_COUNT, transactionCount);
        header.put(HEADER_RESPONSE_STATUS, headerResponseStatus);
        header.put(SERVICE_PROVIDER_ID_QUALIFIER, serviceProviderIdQualifier);
        header.put(SERVICE_PROVIDER_ID, serviceProviderId);
        header.put(DATE_OF_SERVICE, dateOfService);
        return header;
    }

    public static Map<String, Integer> getHeaderSchema() {
        return schema;
    }

    public static int getHeaderLength() {
        return headerLength;
    }
}
