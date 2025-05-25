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
        private static final Map<String, java.util.function.Function<WorkersCompDTO, Object>> FIELD_GETTERS;
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

            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("DY", WorkersCompDTO::getDateOfInjury);
            FIELD_GETTERS.put("CF", WorkersCompDTO::getEmployerName);
            FIELD_GETTERS.put("CG", WorkersCompDTO::getEmployerStreetAddress);
            FIELD_GETTERS.put("CH", WorkersCompDTO::getEmployerCityAddress);
            FIELD_GETTERS.put("CI", WorkersCompDTO::getEmployerStateProvinceAddress);
            FIELD_GETTERS.put("CJ", WorkersCompDTO::getEmployerZipPostalCode);
            FIELD_GETTERS.put("CK", WorkersCompDTO::getEmployerPhoneNumber);
            FIELD_GETTERS.put("CL", WorkersCompDTO::getEmployerContactName);
            FIELD_GETTERS.put("CR", WorkersCompDTO::getCarrierId);
            FIELD_GETTERS.put("DZ", WorkersCompDTO::getClaimReferenceId);
            FIELD_GETTERS.put("TR", WorkersCompDTO::getBillingEntityTypeIndicator);
            FIELD_GETTERS.put("TS", WorkersCompDTO::getPayToQualifier);
            FIELD_GETTERS.put("TT", WorkersCompDTO::getPayToId);
            FIELD_GETTERS.put("TU", WorkersCompDTO::getPayToName);
            FIELD_GETTERS.put("TV", WorkersCompDTO::getPayToStreetAddress);
            FIELD_GETTERS.put("TW", WorkersCompDTO::getPayToCityAddress);
            FIELD_GETTERS.put("TX", WorkersCompDTO::getPayToStateProvinceAddress);
            FIELD_GETTERS.put("TY", WorkersCompDTO::getPayToZipPostalZone);
            FIELD_GETTERS.put("TZ", WorkersCompDTO::getGenericEquivalentProductIdQualifier);
            FIELD_GETTERS.put("UA", WorkersCompDTO::getGenericEquivalentProductId);
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
            FIELD_GETTERS.forEach((key, getter) -> {
                Object value = getter.apply(dto);
                if (value != null) {
                    values.put(key, value);
                }
            });
        }
    }
}
