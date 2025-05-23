package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.CouponDTO;

public class Coupon extends SegmentBase {
    private final CouponMapper mapper = new CouponMapper();
    private CouponDTO couponDTO;

    public Coupon() {
        super();
        this.couponDTO = new CouponDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("KE", "couponType");
        map.put("ME", "couponNumber");
        map.put("NE", "couponValueAmount");
        return Collections.unmodifiableMap(map);
    }

    public CouponDTO setDTOValues(Map<String, Object> values) {
        mapper.updateCouponDTOFromMap(values, couponDTO);
        return this.couponDTO;
    }

    private class CouponMapper {
        public void updateCouponDTOFromMap(Map<String, Object> values, CouponDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "KE": dto.setCouponType(value); break;
                    case "ME": dto.setCouponNumber(value); break;
                    case "NE": dto.setCouponValueAmount(value); break;
                }
            }
        }
    }
}
