package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import poc.ncpdp.data.segments.CouponDTO;

public class Coupon extends SegmentBase {
    private final CouponMapper mapper = new CouponMapper();
    private CouponDTO couponDTO;

    public Coupon() {
        super();
        this.couponDTO = new CouponDTO();
    }

    public Coupon(CouponDTO couponDTO) {
        super();
        this.couponDTO = couponDTO;
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
        setSegmentIdentification(couponDTO);
        return this.couponDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromCouponDTO(couponDTO, values);
        return values;
    }

    private static class CouponMapper {
        private static final Map<String, BiConsumer<CouponDTO, String>> FIELD_SETTERS = Map.of(
            "KE", CouponDTO::setCouponType,
            "ME", CouponDTO::setCouponNumber,
            "NE", CouponDTO::setCouponValueAmount
        );

        private static final Map<String, java.util.function.Function<CouponDTO, Object>> FIELD_GETTERS = Map.of(
            "KE", CouponDTO::getCouponType,
            "ME", CouponDTO::getCouponNumber,
            "NE", CouponDTO::getCouponValueAmount
        );

        public void updateCouponDTOFromMap(Map<String, Object> values, CouponDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<CouponDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromCouponDTO(CouponDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            FIELD_GETTERS.forEach((key, getter) -> {
                Object value = getter.apply(dto);
                if (value != null) {
                    values.put(key, value);
                }
            });
        }
    }
}
