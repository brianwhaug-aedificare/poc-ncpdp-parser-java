package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.FacilityDTO;

public class Facility extends SegmentBase {
    private final FacilityMapper mapper = new FacilityMapper();
    private FacilityDTO facilityDTO;

    public Facility() {
        super();
        this.facilityDTO = new FacilityDTO();
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
        return this.facilityDTO;
    }

    private class FacilityMapper {
        public void updateFacilityDTOFromMap(Map<String, Object> values, FacilityDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "8C": dto.setFacilityId(value); break;
                    case "3Q": dto.setFacilityName(value); break;
                    case "3U": dto.setFacilityStreetAddress(value); break;
                    case "5J": dto.setFacilityCityAddress(value); break;
                    case "3V": dto.setFacilityStateProvinceAddress(value); break;
                    case "6D": dto.setFacilityZipPostalZone(value); break;
                }
            }
        }
    }
}
