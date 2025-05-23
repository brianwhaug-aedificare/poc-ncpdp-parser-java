package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.DurPpsDTO;

public class DurPps extends SegmentBase {
    private final DurPpsMapper mapper = new DurPpsMapper();
    private DurPpsDTO durPpsDTO;

    public DurPps() {
        super();
        this.durPpsDTO = new DurPpsDTO();
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

    private class DurPpsMapper {
        public void updateDurPpsDTOFromMap(Map<String, Object> values, DurPpsDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "7E": dto.setDurPpsCodeCounter(value); break;
                    case "E4": dto.setReasonForServiceCode(value); break;
                    case "E5": dto.setProfessionalServiceCode(value); break;
                    case "E6": dto.setResultOfServiceCode(value); break;
                    case "8E": dto.setDurPpsLevelOfEffort(value); break;
                    case "J9": dto.setDurCoAgentIdQualifier(value); break;
                    case "H6": dto.setDurCoAgentId(value); break;
                }
            }
        }
    }
}
