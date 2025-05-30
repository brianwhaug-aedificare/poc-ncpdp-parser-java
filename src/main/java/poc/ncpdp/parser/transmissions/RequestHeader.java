package poc.ncpdp.parser.transmissions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Data;
import poc.ncpdp.data.transmissions.RequestHeaderDTO;
import poc.ncpdp.parser.utils.FixedWidth;

@Data
public class RequestHeader implements TransmissionHeader {

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
    
    public RequestHeader(String rawMessage) {
        // populates the header from the raw message
        int headerLength = RequestHeaderSchema.getHeaderLength();
        String headerString = rawMessage.substring(0, headerLength);
        
        this.header = new HashMap<>(FixedWidth.parseFixedWidth(RequestHeaderSchema.getHeaderSchema(), headerString));
        
        this.binNumber = (String) header.get(RequestHeaderSchema.BIN_NUMBER);
        this.version = (String) header.get(RequestHeaderSchema.VERSION);
        this.transactionCode = (String) header.get(RequestHeaderSchema.TRANSACTION_CODE);
        this.processorControlNumber = (String) header.get(RequestHeaderSchema.PROCESSOR_CONTROL_NUMBER);
        this.transactionCount = (String) header.get(RequestHeaderSchema.TRANSACTION_COUNT);
        this.serviceProviderIdQualifier = (String) header.get(RequestHeaderSchema.SERVICE_PROVIDER_ID_QUALIFIER);
        this.serviceProviderId = (String) header.get(RequestHeaderSchema.SERVICE_PROVIDER_ID);
        this.dateOfService = (String) header.get(RequestHeaderSchema.DATE_OF_SERVICE);
        this.software = (String) header.get(RequestHeaderSchema.SOFTWARE);
    }

    public RequestHeader(RequestHeaderDTO requestHeaderDTO) {
        // populates the header from the RequestHeaderDTO
        this.binNumber = requestHeaderDTO.getBinNumber();
        this.version = requestHeaderDTO.getVersion();
        this.transactionCode = requestHeaderDTO.getTransactionCode();
        this.processorControlNumber = requestHeaderDTO.getProcessorControlNumber();
        this.transactionCount = requestHeaderDTO.getTransactionCount();
        this.serviceProviderIdQualifier = requestHeaderDTO.getServiceProviderIdQualifier();
        this.serviceProviderId = requestHeaderDTO.getServiceProviderId();
        this.dateOfService = requestHeaderDTO.getDateOfService();
        this.software = requestHeaderDTO.getSoftware();

        this.header = RequestHeaderSchema.build(
                this.binNumber,
                this.version,
                this.transactionCode,
                this.processorControlNumber,
                this.transactionCount,
                this.serviceProviderIdQualifier,
                this.serviceProviderId,
                this.dateOfService,
                this.software
        );
    }
}
