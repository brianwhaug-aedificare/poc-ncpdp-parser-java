package poc.ncpdp.parser.transmissions;

import poc.ncpdp.parser.transmissions.groups.TransmissionGroup;
import poc.ncpdp.parser.transmissions.groups.TransactionGroup;
import java.util.List;
import java.util.Map;

public interface Transmission {
    Map<String, Object> getHeader();
    TransmissionGroup getTransmissionGroup();
    List<TransactionGroup> getTransactionGroups();
}
