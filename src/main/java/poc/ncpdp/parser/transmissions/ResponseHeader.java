package poc.ncpdp.parser.transmissions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;
import poc.ncpdp.data.transmissions.ResponseHeaderDTO;
import poc.ncpdp.parser.utils.FixedWidth;
@Data
public class ResponseHeader implements TransmissionHeader {
    private static final String VERSION = "version";
    private static final String TRANSACTION_CODE = "transaction_code";
    private static final String TRANSACTION_COUNT = "transaction_count";
    private static final String HEADER_RESPONSE_STATUS = "header_response_status";
    private static final String SERVICE_PROVIDER_ID_QUALIFIER = "service_provider_id_qualifier";
    private static final String SERVICE_PROVIDER_ID = "service_provider_id";
    private static final String DATE_OF_SERVICE = "date_of_service";

    private static final Map<String, Integer> HEADER_SCHEMA = createHeaderSchema();

    private static Map<String, Integer> createHeaderSchema() {
        Map<String, Integer> schema = new LinkedHashMap<>();
        schema.put(VERSION, 2);
        schema.put(TRANSACTION_CODE, 2);
        schema.put(TRANSACTION_COUNT, 1);
        schema.put(HEADER_RESPONSE_STATUS, 1);
        schema.put(SERVICE_PROVIDER_ID_QUALIFIER, 2);
        schema.put(SERVICE_PROVIDER_ID, 15);
        schema.put(DATE_OF_SERVICE, 8);
        return schema;
    }

    public static Map<String, Integer> getHeaderSchema() {
        return HEADER_SCHEMA;
    }

    public String version;
    public String transactionCode;
    public String transactionCount;
    public String headerResponseStatus;
    public String serviceProviderIdQualifier;
    public String serviceProviderId;
    public String dateOfService;
    public Map<String, Object> header;
    public int headerLength;

    public ResponseHeader(String rawMessage) {
        headerLength = getHeaderSchema().values().stream().mapToInt(Integer::intValue).sum();
        String headerString = rawMessage.substring(0, headerLength);

        this.header = new LinkedHashMap<>(FixedWidth.parseFixedWidth(getHeaderSchema(), headerString));
        this.version = (String) header.get(VERSION);
        this.transactionCode = (String) header.get(TRANSACTION_CODE);
        this.transactionCount = (String) header.get(TRANSACTION_COUNT);
        this.headerResponseStatus = (String) header.get(HEADER_RESPONSE_STATUS);
        this.serviceProviderIdQualifier = (String) header.get(SERVICE_PROVIDER_ID_QUALIFIER);
        this.serviceProviderId = (String) header.get(SERVICE_PROVIDER_ID);
        this.dateOfService = (String) header.get(DATE_OF_SERVICE);
    }

    public ResponseHeader(ResponseHeaderDTO headerDTO) {
        this.version = headerDTO.getVersion();
        this.transactionCode = headerDTO.getTransactionCode();
        this.transactionCount = headerDTO.getTransactionCount();
        this.headerResponseStatus = headerDTO.getHeaderResponseStatus();
        this.serviceProviderIdQualifier = headerDTO.getServiceProviderIdQualifier();
        this.serviceProviderId = headerDTO.getServiceProviderId();
        this.dateOfService = headerDTO.getDateOfService();

        this.header = new HashMap<>();
        header.put(VERSION, this.version);
        header.put(TRANSACTION_CODE, this.transactionCode);
        header.put(TRANSACTION_COUNT, this.transactionCount);
        header.put(HEADER_RESPONSE_STATUS, this.headerResponseStatus);
        header.put(SERVICE_PROVIDER_ID_QUALIFIER, this.serviceProviderIdQualifier);
        header.put(SERVICE_PROVIDER_ID, this.serviceProviderId);
        header.put(DATE_OF_SERVICE, this.dateOfService);
    }

    public Map<String, Object> getHeader() {
        return header;
    }
}
