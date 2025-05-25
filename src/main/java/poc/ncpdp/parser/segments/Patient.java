package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PatientDTO;

public class Patient extends SegmentBase {

    private final PatientMapper mapper = new PatientMapper();
    private PatientDTO patientDTO;

    public Patient() {
        super();
        this.patientDTO = new PatientDTO();
    }

    public Patient(PatientDTO patientDTO) {
        super();
        this.patientDTO = patientDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("CX", "patientIdQualifier");
        map.put("CY", "patientId");
        map.put("C4", "dateOfBirth");
        map.put("C5", "patientGenderCode");
        map.put("CA", "patientFirstName");
        map.put("CB", "patientLastName");
        map.put("CM", "patientStreetAddress");
        map.put("CN", "patientCity");
        map.put("CO", "patientStateOrProvince");
        map.put("CP", "patientZipPostalCode");
        map.put("CQ", "patientPhoneNumber");
        map.put("C7", "placeOfService");
        map.put("CZ", "employerId");
        map.put("1C", "smokerNonSmokerCode");
        map.put("2C", "pregnancyIndicator");
        map.put("HN", "patientEmailAddress");
        map.put("4X", "patientResidence");
        return Collections.unmodifiableMap(map);
    }

    public PatientDTO setDTOValues(Map<String, Object> values) {
        mapper.updatePatientDTOFromMap(values, patientDTO);
        setSegmentIdentification(patientDTO);
        return this.patientDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromPatientDTO(patientDTO, values);
        return values;
    }

    private static class PatientMapper {
        private static final java.util.Map<String, java.util.function.BiConsumer<PatientDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new java.util.HashMap<>();
            FIELD_SETTERS.put("CX", PatientDTO::setPatientIdQualifier);
            FIELD_SETTERS.put("CY", PatientDTO::setPatientId);
            FIELD_SETTERS.put("C4", PatientDTO::setDateOfBirth);
            FIELD_SETTERS.put("C5", PatientDTO::setPatientGenderCode);
            FIELD_SETTERS.put("CA", PatientDTO::setPatientFirstName);
            FIELD_SETTERS.put("CB", PatientDTO::setPatientLastName);
            FIELD_SETTERS.put("CM", PatientDTO::setPatientStreetAddress);
            FIELD_SETTERS.put("CN", PatientDTO::setPatientCity);
            FIELD_SETTERS.put("CO", PatientDTO::setPatientStateOrProvince);
            FIELD_SETTERS.put("CP", PatientDTO::setPatientZipPostalCode);
            FIELD_SETTERS.put("CQ", PatientDTO::setPatientPhoneNumber);
            FIELD_SETTERS.put("C7", PatientDTO::setPlaceOfService);
            FIELD_SETTERS.put("CZ", PatientDTO::setEmployerId);
            FIELD_SETTERS.put("1C", PatientDTO::setSmokerNonSmokerCode);
            FIELD_SETTERS.put("2C", PatientDTO::setPregnancyIndicator);
            FIELD_SETTERS.put("HN", PatientDTO::setPatientEmailAddress);
            FIELD_SETTERS.put("4X", PatientDTO::setPatientResidence);
        }

        private static final java.util.Map<String, java.util.function.Function<PatientDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new java.util.LinkedHashMap<>();
            FIELD_GETTERS.put("CX", PatientDTO::getPatientIdQualifier);
            FIELD_GETTERS.put("CY", PatientDTO::getPatientId);
            FIELD_GETTERS.put("C4", PatientDTO::getDateOfBirth);
            FIELD_GETTERS.put("C5", PatientDTO::getPatientGenderCode);
            FIELD_GETTERS.put("CA", PatientDTO::getPatientFirstName);
            FIELD_GETTERS.put("CB", PatientDTO::getPatientLastName);
            FIELD_GETTERS.put("CM", PatientDTO::getPatientStreetAddress);
            FIELD_GETTERS.put("CN", PatientDTO::getPatientCity);
            FIELD_GETTERS.put("CO", PatientDTO::getPatientStateOrProvince);
            FIELD_GETTERS.put("CP", PatientDTO::getPatientZipPostalCode);
            FIELD_GETTERS.put("CQ", PatientDTO::getPatientPhoneNumber);
            FIELD_GETTERS.put("C7", PatientDTO::getPlaceOfService);
            FIELD_GETTERS.put("CZ", PatientDTO::getEmployerId);
            FIELD_GETTERS.put("1C", PatientDTO::getSmokerNonSmokerCode);
            FIELD_GETTERS.put("2C", PatientDTO::getPregnancyIndicator);
            FIELD_GETTERS.put("HN", PatientDTO::getPatientEmailAddress);
            FIELD_GETTERS.put("4X", PatientDTO::getPatientResidence);
        }

        public void updatePatientDTOFromMap(Map<String, Object> values, PatientDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<PatientDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromPatientDTO(PatientDTO dto, Map<String, Object> values) {
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
