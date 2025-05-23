package poc.ncpdp.parser.transmissions;

import poc.ncpdp.parser.transmissions.groups.TransmissionGroup;
import poc.ncpdp.parser.transmissions.groups.TransactionGroup;
import java.util.List;

public interface Transmission {
    TransmissionHeader getHeader();
    TransmissionGroup getTransmissionGroup();
    List<TransactionGroup> getTransactionGroups();
}
