package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.PatientDTO;

public class Patient extends SegmentBase {

    private final PatientMapper mapper = new PatientMapper();
    private PatientDTO patientDTO;

    public Patient() {
        super();
        this.patientDTO = new PatientDTO();
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

    public class PatientMapper {
        public void updatePatientDTOFromMap(Map<String, Object> values, PatientDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "CX":
                        dto.setPatientIdQualifier(value);
                        break;
                    case "CY":
                        dto.setPatientId(value);
                        break;
                    case "C4":
                        dto.setDateOfBirth(value);
                        break;
                    case "C5":
                        dto.setPatientGenderCode(value);
                        break;
                    case "CA":
                        dto.setPatientFirstName(value);
                        break;
                    case "CB":
                        dto.setPatientLastName(value);
                        break;
                    case "CM":
                        dto.setPatientStreetAddress(value);
                        break;
                    case "CN":
                        dto.setPatientCity(value);
                        break;
                    case "CO":
                        dto.setPatientStateOrProvince(value);
                        break;
                    case "CP":
                        dto.setPatientZipPostalCode(value);
                        break;
                    case "CQ":
                        dto.setPatientPhoneNumber(value);
                        break;
                    case "C7":
                        dto.setPlaceOfService(value);
                        break;
                    case "CZ":
                        dto.setEmployerId(value);
                        break;
                    case "1C":
                        dto.setSmokerNonSmokerCode(value);
                        break;
                    case "2C":
                        dto.setPregnancyIndicator(value);
                        break;
                    case "HN":
                        dto.setPatientEmailAddress(value);
                        break;
                    case "4X":
                        dto.setPatientResidence(value);
                        break;

                }
            }
        }
    }
}
