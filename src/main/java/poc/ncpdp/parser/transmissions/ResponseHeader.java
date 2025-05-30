package poc.ncpdp.parser.transmissions;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;
import poc.ncpdp.data.transmissions.ResponseHeaderDTO;
import poc.ncpdp.parser.utils.FixedWidth;
@Data
public class ResponseHeader implements TransmissionHeader {

    public String version;
    public String transactionCode;
    public String transactionCount;
    public String headerResponseStatus;
    public String serviceProviderIdQualifier;
    public String serviceProviderId;
    public String dateOfService;

    public Map<String, Object> header;

    public ResponseHeader(String rawMessage) {
        int headerLength = ResponseHeaderSchema.getHeaderLength();
        String headerString = rawMessage.substring(0, headerLength);

        this.header = new LinkedHashMap<>(FixedWidth.parseFixedWidth(ResponseHeaderSchema.getHeaderSchema(), headerString));
        
        this.version = (String) header.get(ResponseHeaderSchema.VERSION);
        this.transactionCode = (String) header.get(ResponseHeaderSchema.TRANSACTION_CODE);
        this.transactionCount = (String) header.get(ResponseHeaderSchema.TRANSACTION_COUNT);
        this.headerResponseStatus = (String) header.get(ResponseHeaderSchema.HEADER_RESPONSE_STATUS);
        this.serviceProviderIdQualifier = (String) header.get(ResponseHeaderSchema.SERVICE_PROVIDER_ID_QUALIFIER);
        this.serviceProviderId = (String) header.get(ResponseHeaderSchema.SERVICE_PROVIDER_ID);
        this.dateOfService = (String) header.get(ResponseHeaderSchema.DATE_OF_SERVICE);
    }

    public ResponseHeader(ResponseHeaderDTO headerDTO) {
        this.version = headerDTO.getVersion();
        this.transactionCode = headerDTO.getTransactionCode();
        this.transactionCount = headerDTO.getTransactionCount();
        this.headerResponseStatus = headerDTO.getHeaderResponseStatus();
        this.serviceProviderIdQualifier = headerDTO.getServiceProviderIdQualifier();
        this.serviceProviderId = headerDTO.getServiceProviderId();
        this.dateOfService = headerDTO.getDateOfService();

        this.header = ResponseHeaderSchema.build(
                this.version,
                this.transactionCode,
                this.transactionCount,
                this.headerResponseStatus,
                this.serviceProviderIdQualifier,
                this.serviceProviderId,
                this.dateOfService
        );
    }

    public Map<String, Object> getHeader() {
        return header;
    }
}
