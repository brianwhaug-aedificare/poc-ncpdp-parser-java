package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseDurPpsDTO;

public class ResponseDurPps extends SegmentBase {
    private final ResponseDurPpsMapper mapper = new ResponseDurPpsMapper();
    private ResponseDurPpsDTO responseDurPpsDTO;

    public ResponseDurPps() {
        super();
        this.responseDurPpsDTO = new ResponseDurPpsDTO();
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("J6", "durPpsResponseCodeCounter");
        map.put("E4", "reasonForServiceCode");
        map.put("FS", "clinicalSignificanceCode");
        map.put("FT", "otherPharmacyIndicator");
        map.put("FV", "quantityOfPreviousFill");
        map.put("FU", "previousDateOfFill");
        map.put("FW", "databaseIndicator");
        map.put("FX", "otherPrescriberIndicator");
        map.put("FY", "durFreeTextMessage");
        map.put("NS", "durAdditionalText");
        return map;
    }

    public ResponseDurPpsDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponseDurPpsDTOFromMap(values, responseDurPpsDTO);
        setSegmentIdentification(responseDurPpsDTO);
        return this.responseDurPpsDTO;
    }

    private class ResponseDurPpsMapper {
        public void updateResponseDurPpsDTOFromMap(Map<String, Object> values, ResponseDurPpsDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "J6": dto.setDurPpsResponseCodeCounter(value); break;
                    case "E4": dto.setReasonForServiceCode(value); break;
                    case "FS": dto.setClinicalSignificanceCode(value); break;
                    case "FT": dto.setOtherPharmacyIndicator(value); break;
                    case "FV": dto.setQuantityOfPreviousFill(value); break;
                    case "FU": dto.setPreviousDateOfFill(value); break;
                    case "FW": dto.setDatabaseIndicator(value); break;
                    case "FX": dto.setOtherPrescriberIndicator(value); break;
                    case "FY": dto.setDurFreeTextMessage(value); break;
                    case "NS": dto.setDurAdditionalText(value); break;
                }
            }
        }
    }
}
