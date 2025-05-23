package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.WorkersCompDTO;

public class WorkersComp extends SegmentBase {

    private final WorkersCompMapper mapper = new WorkersCompMapper();
    private WorkersCompDTO workersCompDTO;

    public WorkersComp() {
        super();
        this.workersCompDTO = new WorkersCompDTO();
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

    private class WorkersCompMapper {
        public void updateWorkersCompDTOFromMap(Map<String, Object> values, WorkersCompDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "DY": dto.setDateOfInjury(value); break;
                    case "CF": dto.setEmployerName(value); break;
                    case "CG": dto.setEmployerStreetAddress(value); break;
                    case "CH": dto.setEmployerCityAddress(value); break;
                    case "CI": dto.setEmployerStateProvinceAddress(value); break;
                    case "CJ": dto.setEmployerZipPostalCode(value); break;
                    case "CK": dto.setEmployerPhoneNumber(value); break;
                    case "CL": dto.setEmployerContactName(value); break;
                    case "CR": dto.setCarrierId(value); break;
                    case "DZ": dto.setClaimReferenceId(value); break;
                    case "TR": dto.setBillingEntityTypeIndicator(value); break;
                    case "TS": dto.setPayToQualifier(value); break;
                    case "TT": dto.setPayToId(value); break;
                    case "TU": dto.setPayToName(value); break;
                    case "TV": dto.setPayToStreetAddress(value); break;
                    case "TW": dto.setPayToCityAddress(value); break;
                    case "TX": dto.setPayToStateProvinceAddress(value); break;
                    case "TY": dto.setPayToZipPostalZone(value); break;
                    case "TZ": dto.setGenericEquivalentProductIdQualifier(value); break;
                    case "UA": dto.setGenericEquivalentProductId(value); break;
                }
            }
        }
    }
}
