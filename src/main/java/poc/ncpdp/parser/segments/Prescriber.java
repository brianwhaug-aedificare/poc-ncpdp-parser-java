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

        private static final java.util.Map<String, java.util.function.Function<PrescriberDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("EZ", PrescriberDTO::getPrescriberIdQualifier);
            FIELD_GETTERS.put("DB", PrescriberDTO::getPrescriberId);
            FIELD_GETTERS.put("DR", PrescriberDTO::getPrescriberLastName);
            FIELD_GETTERS.put("PM", PrescriberDTO::getPrescriberPhoneNumber);
            FIELD_GETTERS.put("2E", PrescriberDTO::getPrimaryCareProviderIdQualifier);
            FIELD_GETTERS.put("DL", PrescriberDTO::getPrimaryCareProviderId);
            FIELD_GETTERS.put("4E", PrescriberDTO::getPrimaryCareProviderLastName);
            FIELD_GETTERS.put("2J", PrescriberDTO::getPrescriberFirstName);
            FIELD_GETTERS.put("2K", PrescriberDTO::getPrescriberStreetAddress);
            FIELD_GETTERS.put("2M", PrescriberDTO::getPrescriberCityAddress);
            FIELD_GETTERS.put("2N", PrescriberDTO::getPrescriberStateProvinceAddress);
            FIELD_GETTERS.put("2P", PrescriberDTO::getPrescriberZipPostalZone);
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
            FIELD_GETTERS.forEach((key, getter) -> {
                Object value = getter.apply(dto);
                if (value != null) {
                    values.put(key, value);
                }
            });
        }
    }
}
