package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.DurPpsDTO;

public class DurPps extends SegmentBase {
    private final DurPpsMapper mapper = new DurPpsMapper();
    private DurPpsDTO durPpsDTO;

    public DurPps() {
        super();
        this.durPpsDTO = new DurPpsDTO();
    }

    public DurPps(DurPpsDTO durPpsDTO) {
        super();
        this.durPpsDTO = durPpsDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("7E", "durPpsCodeCounter");
        map.put("E4", "reasonForServiceCode");
        map.put("E5", "professionalServiceCode");
        map.put("E6", "resultOfServiceCode");
        map.put("8E", "durPpsLevelOfEffort");
        map.put("J9", "durCoAgentIdQualifier");
        map.put("H6", "durCoAgentId");
        return Collections.unmodifiableMap(map);
    }

    public DurPpsDTO setDTOValues(Map<String, Object> values) {
        mapper.updateDurPpsDTOFromMap(values, durPpsDTO);
        setSegmentIdentification(durPpsDTO);
        return this.durPpsDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromDurPpsDTO(durPpsDTO, values);
        return values;
    }

    private static class DurPpsMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<DurPpsDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("7E", DurPpsDTO::setDurPpsCodeCounter);
            FIELD_SETTERS.put("E4", DurPpsDTO::setReasonForServiceCode);
            FIELD_SETTERS.put("E5", DurPpsDTO::setProfessionalServiceCode);
            FIELD_SETTERS.put("E6", DurPpsDTO::setResultOfServiceCode);
            FIELD_SETTERS.put("8E", DurPpsDTO::setDurPpsLevelOfEffort);
            FIELD_SETTERS.put("J9", DurPpsDTO::setDurCoAgentIdQualifier);
            FIELD_SETTERS.put("H6", DurPpsDTO::setDurCoAgentId);
        }

        public void updateDurPpsDTOFromMap(Map<String, Object> values, DurPpsDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<DurPpsDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromDurPpsDTO(DurPpsDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "7E", dto.getDurPpsCodeCounter());
            putIfNotNull(values, "E4", dto.getReasonForServiceCode());
            putIfNotNull(values, "E5", dto.getProfessionalServiceCode());
            putIfNotNull(values, "E6", dto.getResultOfServiceCode());
            putIfNotNull(values, "8E", dto.getDurPpsLevelOfEffort());
            putIfNotNull(values, "J9", dto.getDurCoAgentIdQualifier());
            putIfNotNull(values, "H6", dto.getDurCoAgentId());
        }
    }
}
