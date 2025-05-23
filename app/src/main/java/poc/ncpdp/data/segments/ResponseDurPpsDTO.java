package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseDurPpsDTO extends SegmentDTO {
    private String durPpsResponseCodeCounter;
    private String reasonForServiceCode;
    private String clinicalSignificanceCode;
    private String otherPharmacyIndicator;
    private String quantityOfPreviousFill;
    private String previousDateOfFill;
    private String databaseIndicator;
    private String otherPrescriberIndicator;
    private String durFreeTextMessage;
    private String durAdditionalText;
}
