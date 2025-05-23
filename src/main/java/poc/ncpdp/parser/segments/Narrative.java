package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.NarrativeDTO;

public class Narrative extends SegmentBase {
    private final NarrativeMapper mapper = new NarrativeMapper();
    private NarrativeDTO narrativeDTO;

    public Narrative() {
        super();
        this.narrativeDTO = new NarrativeDTO();
    }

    public Narrative(NarrativeDTO narrativeDTO) {
        super();
        this.narrativeDTO = narrativeDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("BM", "narrativeMessage");
        return Collections.unmodifiableMap(map);
    }

    public NarrativeDTO setDTOValues(Map<String, Object> values) {
        mapper.updateNarrativeDTOFromMap(values, narrativeDTO);
        setSegmentIdentification(narrativeDTO);
        return this.narrativeDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromNarrativeDTO(narrativeDTO, values);
        return values;
    }

    private static class NarrativeMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<NarrativeDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("BM", NarrativeDTO::setNarrativeMessage);
        }

        public void updateNarrativeDTOFromMap(Map<String, Object> values, NarrativeDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<NarrativeDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromNarrativeDTO(NarrativeDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "BM", dto.getNarrativeMessage());
        }
    }
}
