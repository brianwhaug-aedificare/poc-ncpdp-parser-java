package poc.ncpdp.data.transmissions;

import lombok.Data;

@Data
public class ResponseHeaderDTO {
    private String version;
    private String transactionCode;
    private String transactionCount;
    private String headerResponseStatus;
    private String serviceProviderIdQualifier;
    private String serviceProviderId;
    private String dateOfService;

    public ResponseHeaderDTO(String version, String transactionCode, String transactionCount, String headerResponseStatus, String serviceProviderIdQualifier, String serviceProviderId, String dateOfService) {
        this.version = version;
        this.transactionCode = transactionCode;
        this.transactionCount = transactionCount;
        this.headerResponseStatus = headerResponseStatus;
        this.serviceProviderIdQualifier = serviceProviderIdQualifier;
        this.serviceProviderId = serviceProviderId;
        this.dateOfService = dateOfService;
    }
}
