package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import poc.ncpdp.data.segments.ClinicalDTO;

public class Clinical extends SegmentBase {
    private final ClinicalMapper mapper = new ClinicalMapper();
    private ClinicalDTO clinicalDTO;

    public Clinical() {
        super();
        this.clinicalDTO = new ClinicalDTO();
    }

    public Clinical(ClinicalDTO clinicalDTO) {
        super();
        this.clinicalDTO = clinicalDTO;
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
        setSegmentIdentification(clinicalDTO);
        return this.clinicalDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromClinicalDTO(clinicalDTO, values);
        return values;
    }

    private static class ClinicalMapper {
        private static final Map<String, BiConsumer<ClinicalDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new HashMap<>();
            FIELD_SETTERS.put("VE", (dto, v) -> dto.setDiagnosisCodeCount(v));
            FIELD_SETTERS.put("WE", (dto, v) -> dto.setDiagnosisCodeQualifier(v));
            FIELD_SETTERS.put("DO", (dto, v) -> dto.setDiagnosisCode(v));
            FIELD_SETTERS.put("XE", (dto, v) -> dto.setClinicalInformationCounter(v));
            FIELD_SETTERS.put("ZE", (dto, v) -> dto.setMeasurementDate(v));
            FIELD_SETTERS.put("H1", (dto, v) -> dto.setMeasurementTime(v));
            FIELD_SETTERS.put("H2", (dto, v) -> dto.setMeasurementDimension(v));
            FIELD_SETTERS.put("H3", (dto, v) -> dto.setMeasurementUnit(v));
            FIELD_SETTERS.put("H4", (dto, v) -> dto.setMeasurementValue(v));
        }

        public void updateClinicalDTOFromMap(Map<String, Object> values, ClinicalDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<ClinicalDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromClinicalDTO(ClinicalDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "VE", dto.getDiagnosisCodeCount());
            putIfNotNull(values, "WE", dto.getDiagnosisCodeQualifier());
            putIfNotNull(values, "DO", dto.getDiagnosisCode());
            putIfNotNull(values, "XE", dto.getClinicalInformationCounter());
            putIfNotNull(values, "ZE", dto.getMeasurementDate());
            putIfNotNull(values, "H1", dto.getMeasurementTime());
            putIfNotNull(values, "H2", dto.getMeasurementDimension());
            putIfNotNull(values, "H3", dto.getMeasurementUnit());
            putIfNotNull(values, "H4", dto.getMeasurementValue());
        }
    }
}
