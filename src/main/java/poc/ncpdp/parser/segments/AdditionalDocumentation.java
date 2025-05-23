package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.AdditionalDocumentationDTO;

public class AdditionalDocumentation extends SegmentBase {
    private final AdditionalDocumentationMapper mapper = new AdditionalDocumentationMapper();
    private AdditionalDocumentationDTO additionalDocumentationDTO;

    public AdditionalDocumentation() {
        super();
        this.additionalDocumentationDTO = new AdditionalDocumentationDTO();
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

    private class AdditionalDocumentationMapper {
        public void updateAdditionalDocumentationDTOFromMap(Map<String, Object> values, AdditionalDocumentationDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "2Q": dto.setAdditionalDocumentationTypeId(value); break;
                    case "2V": dto.setRequestPeriodBeginDate(value); break;
                    case "2W": dto.setRequestPeriodRecertRevisedDate(value); break;
                    case "2U": dto.setRequestStatus(value); break;
                    case "2S": dto.setLengthOfNeedQualifier(value); break;
                    case "2R": dto.setLengthOfNeed(value); break;
                    case "2T": dto.setPrescriberSupplierDateSigned(value); break;
                    case "2X": dto.setSupportingDocumentation(value); break;
                    case "2Z": dto.setQuestionNumberLetterCount(value); break;
                    case "4B": dto.setQuestionNumberLetter(value); break;
                    case "4D": dto.setQuestionPercentResponse(value); break;
                    case "4G": dto.setQuestionDateResponse(value); break;
                    case "4H": dto.setQuestionDollarAmountResponse(value); break;
                    case "4J": dto.setQuestionNumericResponse(value); break;
                    case "4K": dto.setQuestionAlphanumericResponse(value); break;
                }
            }
        }
    }
}
