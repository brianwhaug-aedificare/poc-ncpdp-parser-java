package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import poc.ncpdp.data.segments.AdditionalDocumentationDTO;

public class AdditionalDocumentation extends SegmentBase {
    private final AdditionalDocumentationMapper mapper = new AdditionalDocumentationMapper();
    private AdditionalDocumentationDTO additionalDocumentationDTO;

    public AdditionalDocumentation() {
        super();
        this.additionalDocumentationDTO = new AdditionalDocumentationDTO();
    }

    public AdditionalDocumentation(AdditionalDocumentationDTO additionalDocumentationDTO) {
        super();
        this.additionalDocumentationDTO = additionalDocumentationDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("2Q", "additionalDocumentationTypeId");
        map.put("2V", "requestPeriodBeginDate");
        map.put("2W", "requestPeriodRecertRevisedDate");
        map.put("2U", "requestStatus");
        map.put("2S", "lengthOfNeedQualifier");
        map.put("2R", "lengthOfNeed");
        map.put("2T", "prescriberSupplierDateSigned");
        map.put("2X", "supportingDocumentation");
        map.put("2Z", "questionNumberLetterCount");
        map.put("4B", "questionNumberLetter");
        map.put("4D", "questionPercentResponse");
        map.put("4G", "questionDateResponse");
        map.put("4H", "questionDollarAmountResponse");
        map.put("4J", "questionNumericResponse");
        map.put("4K", "questionAlphanumericResponse");
        return Collections.unmodifiableMap(map);
    }

    public AdditionalDocumentationDTO setDTOValues(Map<String, Object> values) {
        mapper.updateAdditionalDocumentationDTOFromMap(values, additionalDocumentationDTO);
        setSegmentIdentification(additionalDocumentationDTO);
        return this.additionalDocumentationDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromAdditionalDocumentationDTO(additionalDocumentationDTO, values);
        return values;
    }

    private static class AdditionalDocumentationMapper {
        private static final Map<String, BiConsumer<AdditionalDocumentationDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new HashMap<>();
            FIELD_SETTERS.put("2Q", (dto, v) -> dto.setAdditionalDocumentationTypeId(v));
            FIELD_SETTERS.put("2V", (dto, v) -> dto.setRequestPeriodBeginDate(v));
            FIELD_SETTERS.put("2W", (dto, v) -> dto.setRequestPeriodRecertRevisedDate(v));
            FIELD_SETTERS.put("2U", (dto, v) -> dto.setRequestStatus(v));
            FIELD_SETTERS.put("2S", (dto, v) -> dto.setLengthOfNeedQualifier(v));
            FIELD_SETTERS.put("2R", (dto, v) -> dto.setLengthOfNeed(v));
            FIELD_SETTERS.put("2T", (dto, v) -> dto.setPrescriberSupplierDateSigned(v));
            FIELD_SETTERS.put("2X", (dto, v) -> dto.setSupportingDocumentation(v));
            FIELD_SETTERS.put("2Z", (dto, v) -> dto.setQuestionNumberLetterCount(v));
            FIELD_SETTERS.put("4B", (dto, v) -> dto.setQuestionNumberLetter(v));
            FIELD_SETTERS.put("4D", (dto, v) -> dto.setQuestionPercentResponse(v));
            FIELD_SETTERS.put("4G", (dto, v) -> dto.setQuestionDateResponse(v));
            FIELD_SETTERS.put("4H", (dto, v) -> dto.setQuestionDollarAmountResponse(v));
            FIELD_SETTERS.put("4J", (dto, v) -> dto.setQuestionNumericResponse(v));
            FIELD_SETTERS.put("4K", (dto, v) -> dto.setQuestionAlphanumericResponse(v));
        }

        private static final Map<String, java.util.function.Function<AdditionalDocumentationDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("2Q", AdditionalDocumentationDTO::getAdditionalDocumentationTypeId);
            FIELD_GETTERS.put("2V", AdditionalDocumentationDTO::getRequestPeriodBeginDate);
            FIELD_GETTERS.put("2W", AdditionalDocumentationDTO::getRequestPeriodRecertRevisedDate);
            FIELD_GETTERS.put("2U", AdditionalDocumentationDTO::getRequestStatus);
            FIELD_GETTERS.put("2S", AdditionalDocumentationDTO::getLengthOfNeedQualifier);
            FIELD_GETTERS.put("2R", AdditionalDocumentationDTO::getLengthOfNeed);
            FIELD_GETTERS.put("2T", AdditionalDocumentationDTO::getPrescriberSupplierDateSigned);
            FIELD_GETTERS.put("2X", AdditionalDocumentationDTO::getSupportingDocumentation);
            FIELD_GETTERS.put("2Z", AdditionalDocumentationDTO::getQuestionNumberLetterCount);
            FIELD_GETTERS.put("4B", AdditionalDocumentationDTO::getQuestionNumberLetter);
            FIELD_GETTERS.put("4D", AdditionalDocumentationDTO::getQuestionPercentResponse);
            FIELD_GETTERS.put("4G", AdditionalDocumentationDTO::getQuestionDateResponse);
            FIELD_GETTERS.put("4H", AdditionalDocumentationDTO::getQuestionDollarAmountResponse);
            FIELD_GETTERS.put("4J", AdditionalDocumentationDTO::getQuestionNumericResponse);
            FIELD_GETTERS.put("4K", AdditionalDocumentationDTO::getQuestionAlphanumericResponse);
        }

        public void updateAdditionalDocumentationDTOFromMap(Map<String, Object> values, AdditionalDocumentationDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<AdditionalDocumentationDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromAdditionalDocumentationDTO(AdditionalDocumentationDTO dto, Map<String, Object> values) {
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
