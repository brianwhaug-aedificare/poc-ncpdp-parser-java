package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PrescriberDTO;

public class Prescriber extends SegmentBase {

    private final PrescriberMapper mapper = new PrescriberMapper();
    private PrescriberDTO prescriberDTO;

    public Prescriber() {
        super();
        this.prescriberDTO = new PrescriberDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("EZ", "prescriberIdQualifier");
        map.put("DB", "prescriberId");
        map.put("DR", "prescriberLastName");
        map.put("PM", "prescriberPhoneNumber");
        map.put("2E", "primaryCareProviderIdQualifier");
        map.put("DL", "primaryCareProviderId");
        map.put("4E", "primaryCareProviderLastName");
        map.put("2J", "prescriberFirstName");
        map.put("2K", "prescriberStreetAddress");
        map.put("2M", "prescriberCityAddress");
        map.put("2N", "prescriberStateProvinceAddress");
        map.put("2P", "prescriberZipPostalZone");
        return Collections.unmodifiableMap(map);
    }

    public PrescriberDTO setDTOValues(Map<String, Object> values) {
        mapper.updatePrescriberDTOFromMap(values, prescriberDTO);
        setSegmentIdentification(prescriberDTO);
        return this.prescriberDTO;
    }

    private class PrescriberMapper {
        public void updatePrescriberDTOFromMap(Map<String, Object> values, PrescriberDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "EZ": dto.setPrescriberIdQualifier(value); break;
                    case "DB": dto.setPrescriberId(value); break;
                    case "DR": dto.setPrescriberLastName(value); break;
                    case "PM": dto.setPrescriberPhoneNumber(value); break;
                    case "2E": dto.setPrimaryCareProviderIdQualifier(value); break;
                    case "DL": dto.setPrimaryCareProviderId(value); break;
                    case "4E": dto.setPrimaryCareProviderLastName(value); break;
                    case "2J": dto.setPrescriberFirstName(value); break;
                    case "2K": dto.setPrescriberStreetAddress(value); break;
                    case "2M": dto.setPrescriberCityAddress(value); break;
                    case "2N": dto.setPrescriberStateProvinceAddress(value); break;
                    case "2P": dto.setPrescriberZipPostalZone(value); break;
                }
            }
        }
    }
}
