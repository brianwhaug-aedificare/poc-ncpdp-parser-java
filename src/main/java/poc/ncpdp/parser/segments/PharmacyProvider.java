package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PharmacyProviderDTO;

public class PharmacyProvider extends SegmentBase {

    private final PharmacyProviderMapper mapper = new PharmacyProviderMapper();
    private PharmacyProviderDTO providerDTO;

    public PharmacyProvider() {
        super();
        this.providerDTO = new PharmacyProviderDTO();
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

    private class PharmacyProviderMapper {
        public void updateProviderDTOFromMap(Map<String, Object> values, PharmacyProviderDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "EY":
                        dto.setProviderIdQualifier(value);
                        break;
                    case "E9":
                        dto.setProviderId(value);
                        break;
                }
            }
        }
    }
}
