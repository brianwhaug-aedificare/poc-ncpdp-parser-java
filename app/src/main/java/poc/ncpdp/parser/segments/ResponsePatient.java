package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponsePatientDTO;

public class ResponsePatient extends SegmentBase {
    private final ResponsePatientMapper mapper = new ResponsePatientMapper();
    private ResponsePatientDTO responsePatientDTO;

    public ResponsePatient() {
        super();
        this.responsePatientDTO = new ResponsePatientDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("CA", "patientFirstName");
        map.put("CB", "patientLastName");
        map.put("C4", "dateOfBirth");
        return map;
    }

    public ResponsePatientDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponsePatientDTOFromMap(values, responsePatientDTO);
        setSegmentIdentification(responsePatientDTO);
        return this.responsePatientDTO;
    }

    private class ResponsePatientMapper {
        public void updateResponsePatientDTOFromMap(Map<String, Object> values, ResponsePatientDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "CA": dto.setPatientFirstName(value); break;
                    case "CB": dto.setPatientLastName(value); break;
                    case "C4": dto.setDateOfBirth(value); break;
                }
            }
        }
    }
}
