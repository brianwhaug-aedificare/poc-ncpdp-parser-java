package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PrescriberDTO extends SegmentDTO {
    private String prescriberIdQualifier;
    private String prescriberId;
    private String prescriberLastName;
    private String prescriberPhoneNumber;
    private String primaryCareProviderIdQualifier;
    private String primaryCareProviderId;
    private String primaryCareProviderLastName;
    private String prescriberFirstName;
    private String prescriberStreetAddress;
    private String prescriberCityAddress;
    private String prescriberStateProvinceAddress;
    private String prescriberZipPostalZone;
}
