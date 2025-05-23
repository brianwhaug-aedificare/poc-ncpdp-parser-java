package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import poc.ncpdp.data.segments.WorkersCompDTO;

public class WorkersComp extends SegmentBase {
    private final WorkersCompMapper mapper = new WorkersCompMapper();
    private WorkersCompDTO workersCompDTO;

    public WorkersComp() {
        super();
        this.workersCompDTO = new WorkersCompDTO();
    }

    public WorkersComp(WorkersCompDTO workersCompDTO) {
        super();
        this.workersCompDTO = workersCompDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("DY", "dateOfInjury");
        map.put("CF", "employerName");
        map.put("CG", "employerStreetAddress");
        map.put("CH", "employerCityAddress");
        map.put("CI", "employerStateProvinceAddress");
        map.put("CJ", "employerZipPostalCode");
        map.put("CK", "employerPhoneNumber");
        map.put("CL", "employerContactName");
        map.put("CR", "carrierId");
        map.put("DZ", "claimReferenceId");
        map.put("TR", "billingEntityTypeIndicator");
        map.put("TS", "payToQualifier");
        map.put("TT", "payToId");
        map.put("TU", "payToName");
        map.put("TV", "payToStreetAddress");
        map.put("TW", "payToCityAddress");
        map.put("TX", "payToStateProvinceAddress");
        map.put("TY", "payToZipPostalZone");
        map.put("TZ", "genericEquivalentProductIdQualifier");
        map.put("UA", "genericEquivalentProductId");
        return Collections.unmodifiableMap(map);
    }

    public WorkersCompDTO setDTOValues(Map<String, Object> values) {
        mapper.updateWorkersCompDTOFromMap(values, workersCompDTO);
        setSegmentIdentification(workersCompDTO);
        return this.workersCompDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromWorkersCompDTO(workersCompDTO, values);
        return values;
    }

    private static class WorkersCompMapper {
        private static final Map<String, BiConsumer<WorkersCompDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new HashMap<>();
            FIELD_SETTERS.put("DY", (dto, v) -> dto.setDateOfInjury(v));
            FIELD_SETTERS.put("CF", (dto, v) -> dto.setEmployerName(v));
            FIELD_SETTERS.put("CG", (dto, v) -> dto.setEmployerStreetAddress(v));
            FIELD_SETTERS.put("CH", (dto, v) -> dto.setEmployerCityAddress(v));
            FIELD_SETTERS.put("CI", (dto, v) -> dto.setEmployerStateProvinceAddress(v));
            FIELD_SETTERS.put("CJ", (dto, v) -> dto.setEmployerZipPostalCode(v));
            FIELD_SETTERS.put("CK", (dto, v) -> dto.setEmployerPhoneNumber(v));
            FIELD_SETTERS.put("CL", (dto, v) -> dto.setEmployerContactName(v));
            FIELD_SETTERS.put("CR", (dto, v) -> dto.setCarrierId(v));
            FIELD_SETTERS.put("DZ", (dto, v) -> dto.setClaimReferenceId(v));
            FIELD_SETTERS.put("TR", (dto, v) -> dto.setBillingEntityTypeIndicator(v));
            FIELD_SETTERS.put("TS", (dto, v) -> dto.setPayToQualifier(v));
            FIELD_SETTERS.put("TT", (dto, v) -> dto.setPayToId(v));
            FIELD_SETTERS.put("TU", (dto, v) -> dto.setPayToName(v));
            FIELD_SETTERS.put("TV", (dto, v) -> dto.setPayToStreetAddress(v));
            FIELD_SETTERS.put("TW", (dto, v) -> dto.setPayToCityAddress(v));
            FIELD_SETTERS.put("TX", (dto, v) -> dto.setPayToStateProvinceAddress(v));
            FIELD_SETTERS.put("TY", (dto, v) -> dto.setPayToZipPostalZone(v));
            FIELD_SETTERS.put("TZ", (dto, v) -> dto.setGenericEquivalentProductIdQualifier(v));
            FIELD_SETTERS.put("UA", (dto, v) -> dto.setGenericEquivalentProductId(v));
        }

        public void updateWorkersCompDTOFromMap(Map<String, Object> values, WorkersCompDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<WorkersCompDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromWorkersCompDTO(WorkersCompDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "DY", dto.getDateOfInjury());
            putIfNotNull(values, "CF", dto.getEmployerName());
            putIfNotNull(values, "CG", dto.getEmployerStreetAddress());
            putIfNotNull(values, "CH", dto.getEmployerCityAddress());
            putIfNotNull(values, "CI", dto.getEmployerStateProvinceAddress());
            putIfNotNull(values, "CJ", dto.getEmployerZipPostalCode());
            putIfNotNull(values, "CK", dto.getEmployerPhoneNumber());
            putIfNotNull(values, "CL", dto.getEmployerContactName());
            putIfNotNull(values, "CR", dto.getCarrierId());
            putIfNotNull(values, "DZ", dto.getClaimReferenceId());
            putIfNotNull(values, "TR", dto.getBillingEntityTypeIndicator());
            putIfNotNull(values, "TS", dto.getPayToQualifier());
            putIfNotNull(values, "TT", dto.getPayToId());
            putIfNotNull(values, "TU", dto.getPayToName());
            putIfNotNull(values, "TV", dto.getPayToStreetAddress());
            putIfNotNull(values, "TW", dto.getPayToCityAddress());
            putIfNotNull(values, "TX", dto.getPayToStateProvinceAddress());
            putIfNotNull(values, "TY", dto.getPayToZipPostalZone());
            putIfNotNull(values, "TZ", dto.getGenericEquivalentProductIdQualifier());
            putIfNotNull(values, "UA", dto.getGenericEquivalentProductId());
        }
    }
}
