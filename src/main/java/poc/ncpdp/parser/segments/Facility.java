package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.FacilityDTO;

public class Facility extends SegmentBase {
    private final FacilityMapper mapper = new FacilityMapper();
    private FacilityDTO facilityDTO;

    public Facility() {
        super();
        this.facilityDTO = new FacilityDTO();
    }

    public Facility(FacilityDTO facilityDTO) {
        super();
        this.facilityDTO = facilityDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("8C", "facilityId");
        map.put("3Q", "facilityName");
        map.put("3U", "facilityStreetAddress");
        map.put("5J", "facilityCityAddress");
        map.put("3V", "facilityStateProvinceAddress");
        map.put("6D", "facilityZipPostalZone");
        return Collections.unmodifiableMap(map);
    }

    public FacilityDTO setDTOValues(Map<String, Object> values) {
        mapper.updateFacilityDTOFromMap(values, facilityDTO);
        setSegmentIdentification(facilityDTO);
        return this.facilityDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromFacilityDTO(facilityDTO, values);
        return values;
    }

    private static class FacilityMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<FacilityDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("8C", (dto, v) -> dto.setFacilityId(v));
            FIELD_SETTERS.put("3Q", (dto, v) -> dto.setFacilityName(v));
            FIELD_SETTERS.put("3U", (dto, v) -> dto.setFacilityStreetAddress(v));
            FIELD_SETTERS.put("5J", (dto, v) -> dto.setFacilityCityAddress(v));
            FIELD_SETTERS.put("3V", (dto, v) -> dto.setFacilityStateProvinceAddress(v));
            FIELD_SETTERS.put("6D", (dto, v) -> dto.setFacilityZipPostalZone(v));
        }

        public void updateFacilityDTOFromMap(Map<String, Object> values, FacilityDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<FacilityDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromFacilityDTO(FacilityDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "8C", dto.getFacilityId());
            putIfNotNull(values, "3Q", dto.getFacilityName());
            putIfNotNull(values, "3U", dto.getFacilityStreetAddress());
            putIfNotNull(values, "5J", dto.getFacilityCityAddress());
            putIfNotNull(values, "3V", dto.getFacilityStateProvinceAddress());
            putIfNotNull(values, "6D", dto.getFacilityZipPostalZone());
        }
    }
}
