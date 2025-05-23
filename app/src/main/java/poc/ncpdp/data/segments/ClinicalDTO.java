package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClinicalDTO extends SegmentDTO {
    private String diagnosisCodeCount;
    private String diagnosisCodeQualifier;
    private String diagnosisCode;
    private String clinicalInformationCounter;
    private String measurementDate;
    private String measurementTime;
    private String measurementDimension;
    private String measurementUnit;
    private String measurementValue;
}
