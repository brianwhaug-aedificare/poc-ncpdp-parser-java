package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ResponseDurPpsDTO;

public class ResponseDurPps extends SegmentBase {
    private final ResponseDurPpsMapper mapper = new ResponseDurPpsMapper();
    private ResponseDurPpsDTO responseDurPpsDTO;

    public ResponseDurPps() {
        super();
        this.responseDurPpsDTO = new ResponseDurPpsDTO();
    }

    public ResponseDurPps(ResponseDurPpsDTO responseDurPpsDTO) {
        super();
        this.responseDurPpsDTO = responseDurPpsDTO;
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

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponseDurPpsDTO(responseDurPpsDTO, values);
        return values;
    }

    private static class ResponseDurPpsMapper {
        private static final Map<String, java.util.function.BiConsumer<ResponseDurPpsDTO, String>> FIELD_SETTERS = Map.of(
            "J6", ResponseDurPpsDTO::setDurPpsResponseCodeCounter,
            "E4", ResponseDurPpsDTO::setReasonForServiceCode,
            "FS", ResponseDurPpsDTO::setClinicalSignificanceCode,
            "FT", ResponseDurPpsDTO::setOtherPharmacyIndicator,
            "FV", ResponseDurPpsDTO::setQuantityOfPreviousFill,
            "FU", ResponseDurPpsDTO::setPreviousDateOfFill,
            "FW", ResponseDurPpsDTO::setDatabaseIndicator,
            "FX", ResponseDurPpsDTO::setOtherPrescriberIndicator,
            "FY", ResponseDurPpsDTO::setDurFreeTextMessage,
            "NS", ResponseDurPpsDTO::setDurAdditionalText
        );

        public void updateResponseDurPpsDTOFromMap(Map<String, Object> values, ResponseDurPpsDTO dto) {
            values.forEach((key, value) -> {
                java.util.function.BiConsumer<ResponseDurPpsDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponseDurPpsDTO(ResponseDurPpsDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "J6", dto.getDurPpsResponseCodeCounter());
            putIfNotNull(values, "E4", dto.getReasonForServiceCode());
            putIfNotNull(values, "FS", dto.getClinicalSignificanceCode());
            putIfNotNull(values, "FT", dto.getOtherPharmacyIndicator());
            putIfNotNull(values, "FV", dto.getQuantityOfPreviousFill());
            putIfNotNull(values, "FU", dto.getPreviousDateOfFill());
            putIfNotNull(values, "FW", dto.getDatabaseIndicator());
            putIfNotNull(values, "FX", dto.getOtherPrescriberIndicator());
            putIfNotNull(values, "FY", dto.getDurFreeTextMessage());
            putIfNotNull(values, "NS", dto.getDurAdditionalText());
        }
    }
}
