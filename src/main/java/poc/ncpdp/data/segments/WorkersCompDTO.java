package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WorkersCompDTO extends SegmentDTO {
    private String dateOfInjury;
    private String employerName;
    private String employerStreetAddress;
    private String employerCityAddress;
    private String employerStateProvinceAddress;
    private String employerZipPostalCode;
    private String employerPhoneNumber;
    private String employerContactName;
    private String carrierId;
    private String claimReferenceId;
    private String billingEntityTypeIndicator;
    private String payToQualifier;
    private String payToId;
    private String payToName;
    private String payToStreetAddress;
    private String payToCityAddress;
    private String payToStateProvinceAddress;
    private String payToZipPostalZone;
    private String genericEquivalentProductIdQualifier;
    private String genericEquivalentProductId;
}
