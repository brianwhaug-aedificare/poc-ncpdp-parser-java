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

        private static final Map<String, java.util.function.Function<ResponseDurPpsDTO, Object>> FIELD_GETTERS = Map.of(
            "J6", ResponseDurPpsDTO::getDurPpsResponseCodeCounter,
            "E4", ResponseDurPpsDTO::getReasonForServiceCode,
            "FS", ResponseDurPpsDTO::getClinicalSignificanceCode,
            "FT", ResponseDurPpsDTO::getOtherPharmacyIndicator,
            "FV", ResponseDurPpsDTO::getQuantityOfPreviousFill,
            "FU", ResponseDurPpsDTO::getPreviousDateOfFill,
            "FW", ResponseDurPpsDTO::getDatabaseIndicator,
            "FX", ResponseDurPpsDTO::getOtherPrescriberIndicator,
            "FY", ResponseDurPpsDTO::getDurFreeTextMessage,
            "NS", ResponseDurPpsDTO::getDurAdditionalText
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
            FIELD_GETTERS.forEach((key, getter) -> {
                Object value = getter.apply(dto);
                if (value != null) {
                    values.put(key, value);
                }
            });
        }
    }
}
