package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CouponDTO extends SegmentDTO {
    private String couponType;
    private String couponNumber;
    private String couponValueAmount;
}
