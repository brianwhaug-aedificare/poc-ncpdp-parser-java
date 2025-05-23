package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PharmacyProviderDTO extends SegmentDTO {
    private String providerIdQualifier;
    private String providerId;
}
