package poc.ncpdp.parser.transmissions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Data;

import poc.ncpdp.parser.utils.FixedWidth;

@Data
public class RequestHeader implements TransmissionHeader {

    private static final String BIN_NUMBER = "bin_number";
    private static final String VERSION = "version";
    private static final String TRANSACTION_CODE = "transaction_code";
    private static final String PROCESSOR_CONTROL_NUMBER = "processor_control_number";
    private static final String TRANSACTION_COUNT = "transaction_count";
    private static final String SERVICE_PROVIDER_ID_QUALIFIER = "service_provider_id_qualifier";
    private static final String SERVICE_PROVIDER_ID = "service_provider_id";
    private static final String DATE_OF_SERVICE = "date_of_service";
    private static final String SOFTWARE = "software";

    private static final Map<String, Integer> HEADER_SCHEMA = createHeaderSchema();

    private static Map<String, Integer> createHeaderSchema() {
        Map<String, Integer> schema = new LinkedHashMap<>();
        schema.put(BIN_NUMBER, 6);
        schema.put(VERSION, 2);
        schema.put(TRANSACTION_CODE, 2);
        schema.put(PROCESSOR_CONTROL_NUMBER, 10);
        schema.put(TRANSACTION_COUNT, 1);
        schema.put(SERVICE_PROVIDER_ID_QUALIFIER, 2);
        schema.put(SERVICE_PROVIDER_ID, 15);
        schema.put(DATE_OF_SERVICE, 8);
        schema.put(SOFTWARE, 10);
        return schema;
    }

    public static Map<String, Integer> getHeaderSchema() {
        return HEADER_SCHEMA;
    }

    public String binNumber;
    public String version;
    public String transactionCode;
    public String processorControlNumber;
    public String transactionCount;
    public String serviceProviderIdQualifier;
    public String serviceProviderId;
    public String dateOfService;
    public String software;
    public Map<String, Object> header;
    public int headerLength;
    
    public RequestHeader(String rawMessage) {
        headerLength = getHeaderSchema().values().stream().mapToInt(Integer::intValue).sum();
        String headerString = rawMessage.substring(0, headerLength);
        
        this.header = new HashMap<>(FixedWidth.parseFixedWidth(getHeaderSchema(), headerString));
        this.binNumber = (String) header.get(BIN_NUMBER);
        this.version = (String) header.get(VERSION);
        this.transactionCode = (String) header.get(TRANSACTION_CODE);
        this.processorControlNumber = (String) header.get(PROCESSOR_CONTROL_NUMBER);
        this.transactionCount = (String) header.get(TRANSACTION_COUNT);
        this.serviceProviderIdQualifier = (String) header.get(SERVICE_PROVIDER_ID_QUALIFIER);
        this.serviceProviderId = (String) header.get(SERVICE_PROVIDER_ID);
        this.dateOfService = (String) header.get(DATE_OF_SERVICE);
        this.software = (String) header.get(SOFTWARE);
    }

    public Map<String, Object> getHeader() {
        return header;
    }
}
