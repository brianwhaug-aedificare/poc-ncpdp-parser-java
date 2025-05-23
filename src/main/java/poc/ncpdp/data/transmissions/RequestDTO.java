package poc.ncpdp.data.transmissions;

import java.util.List;
import lombok.Data;

@Data
public class RequestDTO {
    RequestHeaderDTO requestHeader;
    TransmissionGroupDTO transmissionGroup;
    List<TransactionGroupDTO> transactionGroups;

    public RequestDTO(RequestHeaderDTO requestHeader, TransmissionGroupDTO transmissionGroup, List<TransactionGroupDTO> transactionGroups) {
        this.requestHeader = requestHeader;
        this.transmissionGroup = transmissionGroup;
        this.transactionGroups = transactionGroups;
    }
}
