package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PrescriberDTO;

public class Prescriber extends SegmentBase {

    private final PrescriberMapper mapper = new PrescriberMapper();
    private PrescriberDTO prescriberDTO;

    public Prescriber() {
        super();
        this.prescriberDTO = new PrescriberDTO();
    }

    public Prescriber(PrescriberDTO prescriberDTO) {
        super();
        this.prescriberDTO = prescriberDTO;
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

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromPrescriberDTO(prescriberDTO, values);
        return values;
    }

    private static class PrescriberMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<PrescriberDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("EZ", PrescriberDTO::setPrescriberIdQualifier);
            FIELD_SETTERS.put("DB", PrescriberDTO::setPrescriberId);
            FIELD_SETTERS.put("DR", PrescriberDTO::setPrescriberLastName);
            FIELD_SETTERS.put("PM", PrescriberDTO::setPrescriberPhoneNumber);
            FIELD_SETTERS.put("2E", PrescriberDTO::setPrimaryCareProviderIdQualifier);
            FIELD_SETTERS.put("DL", PrescriberDTO::setPrimaryCareProviderId);
            FIELD_SETTERS.put("4E", PrescriberDTO::setPrimaryCareProviderLastName);
            FIELD_SETTERS.put("2J", PrescriberDTO::setPrescriberFirstName);
            FIELD_SETTERS.put("2K", PrescriberDTO::setPrescriberStreetAddress);
            FIELD_SETTERS.put("2M", PrescriberDTO::setPrescriberCityAddress);
            FIELD_SETTERS.put("2N", PrescriberDTO::setPrescriberStateProvinceAddress);
            FIELD_SETTERS.put("2P", PrescriberDTO::setPrescriberZipPostalZone);
        }

        public void updatePrescriberDTOFromMap(Map<String, Object> values, PrescriberDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<PrescriberDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromPrescriberDTO(PrescriberDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "EZ", dto.getPrescriberIdQualifier());
            putIfNotNull(values, "DB", dto.getPrescriberId());
            putIfNotNull(values, "DR", dto.getPrescriberLastName());
            putIfNotNull(values, "PM", dto.getPrescriberPhoneNumber());
            putIfNotNull(values, "2E", dto.getPrimaryCareProviderIdQualifier());
            putIfNotNull(values, "DL", dto.getPrimaryCareProviderId());
            putIfNotNull(values, "4E", dto.getPrimaryCareProviderLastName());
            putIfNotNull(values, "2J", dto.getPrescriberFirstName());
            putIfNotNull(values, "2K", dto.getPrescriberStreetAddress());
            putIfNotNull(values, "2M", dto.getPrescriberCityAddress());
            putIfNotNull(values, "2N", dto.getPrescriberStateProvinceAddress());
            putIfNotNull(values, "2P", dto.getPrescriberZipPostalZone());
        }

        private void putIfNotNull(Map<String, Object> map, String key, Object value) {
            if (value != null) {
                map.put(key, value);
            }
        }
    }
}
