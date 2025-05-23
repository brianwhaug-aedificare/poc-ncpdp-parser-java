package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdditionalDocumentationDTO extends SegmentDTO {
    private String additionalDocumentationTypeId;
    private String requestPeriodBeginDate;
    private String requestPeriodRecertRevisedDate;
    private String requestStatus;
    private String lengthOfNeedQualifier;
    private String lengthOfNeed;
    private String prescriberSupplierDateSigned;
    private String supportingDocumentation;
    private String questionNumberLetterCount;
    private String questionNumberLetter;
    private String questionPercentResponse;
    private String questionDateResponse;
    private String questionDollarAmountResponse;
    private String questionNumericResponse;
    private String questionAlphanumericResponse;
}
