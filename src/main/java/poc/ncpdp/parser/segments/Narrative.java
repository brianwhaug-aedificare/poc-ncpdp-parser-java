package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.NarrativeDTO;

public class Narrative extends SegmentBase {
    private final NarrativeMapper mapper = new NarrativeMapper();
    private NarrativeDTO narrativeDTO;

    public Narrative() {
        super();
        this.narrativeDTO = new NarrativeDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("BM", "narrativeMessage");
        return Collections.unmodifiableMap(map);
    }

    public NarrativeDTO setDTOValues(Map<String, Object> values) {
        mapper.updateNarrativeDTOFromMap(values, narrativeDTO);
        return this.narrativeDTO;
    }

    private class NarrativeMapper {
        public void updateNarrativeDTOFromMap(Map<String, Object> values, NarrativeDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "BM": dto.setNarrativeMessage(value); break;
                }
            }
        }
    }
}
