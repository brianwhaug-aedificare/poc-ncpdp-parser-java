package poc.ncpdp.data.transmissions;

import java.util.List;
import lombok.Data;

@Data
public class ResponseDTO {
    ResponseHeaderDTO responseHeader;
    TransmissionGroupDTO transmissionGroup;
    List<TransactionGroupDTO> transactionGroups;

     public ResponseDTO(ResponseHeaderDTO responseHeader, TransmissionGroupDTO transmissionGroup, List<TransactionGroupDTO> transactionGroups) {
        this.responseHeader = responseHeader;
        this.transmissionGroup = transmissionGroup;
        this.transactionGroups = transactionGroups;
    }
}
