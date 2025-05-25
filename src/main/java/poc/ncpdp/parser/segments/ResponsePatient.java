package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponsePatientDTO;

public class ResponsePatient extends SegmentBase {
    private final ResponsePatientMapper mapper = new ResponsePatientMapper();
    private ResponsePatientDTO responsePatientDTO;

    public ResponsePatient() {
        super();
        this.responsePatientDTO = new ResponsePatientDTO();
    }

    public ResponsePatient(ResponsePatientDTO responsePatientDTO) {
        super();
        this.responsePatientDTO = responsePatientDTO;
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

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponsePatientDTO(responsePatientDTO, values);
        return values;
    }

    private static class ResponsePatientMapper {
        private static final Map<String, java.util.function.BiConsumer<ResponsePatientDTO, String>> FIELD_SETTERS = Map.of(
            "CA", ResponsePatientDTO::setPatientFirstName,
            "CB", ResponsePatientDTO::setPatientLastName,
            "C4", ResponsePatientDTO::setDateOfBirth
        );

        private static final Map<String, java.util.function.Function<ResponsePatientDTO, Object>> FIELD_GETTERS = Map.of(
            "CA", ResponsePatientDTO::getPatientFirstName,
            "CB", ResponsePatientDTO::getPatientLastName,
            "C4", ResponsePatientDTO::getDateOfBirth
        );

        public void updateResponsePatientDTOFromMap(Map<String, Object> values, ResponsePatientDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<ResponsePatientDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponsePatientDTO(ResponsePatientDTO dto, Map<String, Object> values) {
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
