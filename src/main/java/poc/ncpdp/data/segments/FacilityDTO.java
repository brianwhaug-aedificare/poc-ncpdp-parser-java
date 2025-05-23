package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FacilityDTO extends SegmentDTO {
    private String facilityId;
    private String facilityName;
    private String facilityStreetAddress;
    private String facilityCityAddress;
    private String facilityStateProvinceAddress;
    private String facilityZipPostalZone;
}
