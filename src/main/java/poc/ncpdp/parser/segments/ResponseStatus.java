package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import poc.ncpdp.data.segments.ResponseStatusDTO;

public class ResponseStatus extends SegmentBase {
    private final ResponseStatusMapper mapper = new ResponseStatusMapper();
    private ResponseStatusDTO responseStatusDTO;

    public ResponseStatus() {
        super();
        this.responseStatusDTO = new ResponseStatusDTO();
    }

    public ResponseStatus(ResponseStatusDTO responseStatusDTO) {
        super();
        this.responseStatusDTO = responseStatusDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("AN", "response_status");
        map.put("F3", "authorization_number");
        map.put("FA", "reject_count");
        map.put("FB", "reject_code");
        map.put("4F", "reject_field_occurrence_indicator");
        map.put("5F", "approved_message_code_count");
        map.put("6F", "approved_message_code");
        map.put("UF", "additional_message_information_count");
        map.put("UH", "additional_message_information_qualifier");
        map.put("FQ", "additional_message_information");
        map.put("UG", "additional_message_information_continuity");
        map.put("7F", "help_desk_phone_number_qualifier");
        map.put("8F", "help_desk_phone_number");
        map.put("K5", "transaction_reference_number");
        map.put("A7", "internal_control_number");
        map.put("MA", "url");
        return Collections.unmodifiableMap(map);
    }

    public ResponseStatusDTO setDTOValues(Map<String, Object> values) {
        mapper.updateResponseStatusDTOFromMap(values, responseStatusDTO);
        setSegmentIdentification(responseStatusDTO);
        return this.responseStatusDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromResponseStatusDTO(responseStatusDTO, values);
        return values;
    }

    private static class ResponseStatusMapper {
        private static final Map<String, BiConsumer<ResponseStatusDTO, String>> FIELD_SETTERS = Map.ofEntries(
                Map.entry("AN", ResponseStatusDTO::setResponseStatus),
                Map.entry("F3", ResponseStatusDTO::setAuthorizationNumber),
                Map.entry("FA", ResponseStatusDTO::setRejectCount),
                Map.entry("FB", ResponseStatusDTO::setRejectCode),
                Map.entry("4F", ResponseStatusDTO::setRejectFieldOccurrenceIndicator),
                Map.entry("5F", ResponseStatusDTO::setApprovedMessageCodeCount),
                Map.entry("6F", ResponseStatusDTO::setApprovedMessageCode),
                Map.entry("UF", ResponseStatusDTO::setAdditionalMessageInformationCount),
                Map.entry("UH", ResponseStatusDTO::setAdditionalMessageInformationQualifier),
                Map.entry("FQ", ResponseStatusDTO::setAdditionalMessageInformation),
                Map.entry("UG", ResponseStatusDTO::setAdditionalMessageInformationContinuity),
                Map.entry("7F", ResponseStatusDTO::setHelpDeskPhoneNumberQualifier),
                Map.entry("8F", ResponseStatusDTO::setHelpDeskPhoneNumber),
                Map.entry("K5", ResponseStatusDTO::setTransactionReferenceNumber),
                Map.entry("A7", ResponseStatusDTO::setInternalControlNumber),
                Map.entry("MA", ResponseStatusDTO::setUrl));

        private static final Map<String, Function<ResponseStatusDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("AN", ResponseStatusDTO::getResponseStatus);
            FIELD_GETTERS.put("F3", ResponseStatusDTO::getAuthorizationNumber);
            FIELD_GETTERS.put("FA", ResponseStatusDTO::getRejectCount);
            FIELD_GETTERS.put("FB", ResponseStatusDTO::getRejectCode);
            FIELD_GETTERS.put("4F", ResponseStatusDTO::getRejectFieldOccurrenceIndicator);
            FIELD_GETTERS.put("5F", ResponseStatusDTO::getApprovedMessageCodeCount);
            FIELD_GETTERS.put("6F", ResponseStatusDTO::getApprovedMessageCode);
            FIELD_GETTERS.put("UF", ResponseStatusDTO::getAdditionalMessageInformationCount);
            FIELD_GETTERS.put("UH", ResponseStatusDTO::getAdditionalMessageInformationQualifier);
            FIELD_GETTERS.put("FQ", ResponseStatusDTO::getAdditionalMessageInformation);
            FIELD_GETTERS.put("UG", ResponseStatusDTO::getAdditionalMessageInformationContinuity);
            FIELD_GETTERS.put("7F", ResponseStatusDTO::getHelpDeskPhoneNumberQualifier);
            FIELD_GETTERS.put("8F", ResponseStatusDTO::getHelpDeskPhoneNumber);
            FIELD_GETTERS.put("K5", ResponseStatusDTO::getTransactionReferenceNumber);
            FIELD_GETTERS.put("A7", ResponseStatusDTO::getInternalControlNumber);
            FIELD_GETTERS.put("MA", ResponseStatusDTO::getUrl);
        }

        public void updateResponseStatusDTOFromMap(Map<String, Object> values, ResponseStatusDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<ResponseStatusDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromResponseStatusDTO(ResponseStatusDTO dto, Map<String, Object> values) {
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
