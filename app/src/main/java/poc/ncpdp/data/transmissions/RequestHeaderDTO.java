package poc.ncpdp.data.transmissions;

import lombok.Data;

@Data
public class RequestHeaderDTO {
    private String binNumber;
    private String version;
    private String transactionCode;
    private String processorControlNumber;
    private String transactionCount;
    private String serviceProviderIdQualifier;
    private String serviceProviderId;
    private String dateOfService;
    private String software;

     public RequestHeaderDTO(String binNumber, String version, String transactionCode, String processorControlNumber, String transactionCount, String serviceProviderIdQualifier, String serviceProviderId, String dateOfService, String software) {
        this.binNumber = binNumber;
        this.version = version;
        this.transactionCode = transactionCode;
        this.processorControlNumber = processorControlNumber;
        this.transactionCount = transactionCount;
        this.serviceProviderIdQualifier = serviceProviderIdQualifier;
        this.serviceProviderId = serviceProviderId;
        this.dateOfService = dateOfService;
        this.software = software;
    }
   
}
