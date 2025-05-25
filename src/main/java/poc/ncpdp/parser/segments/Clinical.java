package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

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

        private static final Map<String, Function<ClinicalDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("VE", ClinicalDTO::getDiagnosisCodeCount);
            FIELD_GETTERS.put("WE", ClinicalDTO::getDiagnosisCodeQualifier);
            FIELD_GETTERS.put("DO", ClinicalDTO::getDiagnosisCode);
            FIELD_GETTERS.put("XE", ClinicalDTO::getClinicalInformationCounter);
            FIELD_GETTERS.put("ZE", ClinicalDTO::getMeasurementDate);
            FIELD_GETTERS.put("H1", ClinicalDTO::getMeasurementTime);
            FIELD_GETTERS.put("H2", ClinicalDTO::getMeasurementDimension);
            FIELD_GETTERS.put("H3", ClinicalDTO::getMeasurementUnit);
            FIELD_GETTERS.put("H4", ClinicalDTO::getMeasurementValue);
        }

        public void updateMapFromClinicalDTO(ClinicalDTO dto, Map<String, Object> values) {
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
