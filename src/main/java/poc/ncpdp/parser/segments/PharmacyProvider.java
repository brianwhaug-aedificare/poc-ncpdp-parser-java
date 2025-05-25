package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PharmacyProviderDTO;

public class PharmacyProvider extends SegmentBase {

    private final PharmacyProviderMapper mapper = new PharmacyProviderMapper();
    private PharmacyProviderDTO providerDTO;

    public PharmacyProvider() {
        super();
        this.providerDTO = new PharmacyProviderDTO();
    }

    public PharmacyProvider(PharmacyProviderDTO providerDTO) {
        super();
        this.providerDTO = providerDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("EY", "providerIdQualifier");
        map.put("E9", "providerId");
        return Collections.unmodifiableMap(map);
    }

    public PharmacyProviderDTO setDTOValues(Map<String, Object> values) {
        mapper.updateProviderDTOFromMap(values, providerDTO);
        setSegmentIdentification(providerDTO);
        return this.providerDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromProviderDTO(providerDTO, values);
        return values;
    }

    private static class PharmacyProviderMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<PharmacyProviderDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("EY", PharmacyProviderDTO::setProviderIdQualifier);
            FIELD_SETTERS.put("E9", PharmacyProviderDTO::setProviderId);
        }

        private static final java.util.Map<String, java.util.function.Function<PharmacyProviderDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("EY", PharmacyProviderDTO::getProviderIdQualifier);
            FIELD_GETTERS.put("E9", PharmacyProviderDTO::getProviderId);
        }

        public void updateProviderDTOFromMap(Map<String, Object> values, PharmacyProviderDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<PharmacyProviderDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromProviderDTO(PharmacyProviderDTO dto, Map<String, Object> values) {
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
