package poc.ncpdp.parser.transmissions;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestHeaderSchema {

    protected static final String BIN_NUMBER = "bin_number";
    protected static final String VERSION = "version";
    protected static final String TRANSACTION_CODE = "transaction_code";
    protected static final String PROCESSOR_CONTROL_NUMBER = "processor_control_number";
    protected static final String TRANSACTION_COUNT = "transaction_count";
    protected static final String SERVICE_PROVIDER_ID_QUALIFIER = "service_provider_id_qualifier";
    protected static final String SERVICE_PROVIDER_ID = "service_provider_id";
    protected static final String DATE_OF_SERVICE = "date_of_service";
    protected static final String SOFTWARE = "software";

    private static final Map<String, Integer> schema = new LinkedHashMap<>();
    private static int headerLength = 0;

    static {
        schema.put(BIN_NUMBER, 6);
        schema.put(VERSION, 2);
        schema.put(TRANSACTION_CODE, 2);
        schema.put(PROCESSOR_CONTROL_NUMBER, 10);
        schema.put(TRANSACTION_COUNT, 1);
        schema.put(SERVICE_PROVIDER_ID_QUALIFIER, 2);
        schema.put(SERVICE_PROVIDER_ID, 15);
        schema.put(DATE_OF_SERVICE, 8);
        schema.put(SOFTWARE, 10);

        headerLength = schema.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static Map<String, Object> build(String binNumber, String version, String transactionCode,
            String processorControlNumber, String transactionCount, String serviceProviderIdQualifier,
            String serviceProviderId, String dateOfService, String software) {
        Map<String, Object> header = new LinkedHashMap<>();
        header.put(BIN_NUMBER, binNumber);
        header.put(VERSION, version);
        header.put(TRANSACTION_CODE, transactionCode);
        header.put(PROCESSOR_CONTROL_NUMBER, processorControlNumber);
        header.put(TRANSACTION_COUNT, transactionCount);
        header.put(SERVICE_PROVIDER_ID_QUALIFIER, serviceProviderIdQualifier);
        header.put(SERVICE_PROVIDER_ID, serviceProviderId);
        header.put(DATE_OF_SERVICE, dateOfService);
        header.put(SOFTWARE, software);
        return header;
    }

    public static Map<String, Integer> getHeaderSchema() {
        return schema;
    }

    public static int getHeaderLength() {
        return headerLength;
    }
}
