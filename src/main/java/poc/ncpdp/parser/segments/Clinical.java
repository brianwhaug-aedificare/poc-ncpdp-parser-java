package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ClinicalDTO;

public class Clinical extends SegmentBase {
    private final ClinicalMapper mapper = new ClinicalMapper();
    private ClinicalDTO clinicalDTO;

    public Clinical() {
        super();
        this.clinicalDTO = new ClinicalDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("VE", "diagnosisCodeCount");
        map.put("WE", "diagnosisCodeQualifier");
        map.put("DO", "diagnosisCode");
        map.put("XE", "clinicalInformationCounter");
        map.put("ZE", "measurementDate");
        map.put("H1", "measurementTime");
        map.put("H2", "measurementDimension");
        map.put("H3", "measurementUnit");
        map.put("H4", "measurementValue");
        return Collections.unmodifiableMap(map);
    }

    public ClinicalDTO setDTOValues(Map<String, Object> values) {
        mapper.updateClinicalDTOFromMap(values, clinicalDTO);
        return this.clinicalDTO;
    }

    private class ClinicalMapper {
        public void updateClinicalDTOFromMap(Map<String, Object> values, ClinicalDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "VE": dto.setDiagnosisCodeCount(value); break;
                    case "WE": dto.setDiagnosisCodeQualifier(value); break;
                    case "DO": dto.setDiagnosisCode(value); break;
                    case "XE": dto.setClinicalInformationCounter(value); break;
                    case "ZE": dto.setMeasurementDate(value); break;
                    case "H1": dto.setMeasurementTime(value); break;
                    case "H2": dto.setMeasurementDimension(value); break;
                    case "H3": dto.setMeasurementUnit(value); break;
                    case "H4": dto.setMeasurementValue(value); break;
                }
            }
        }
    }
}
