package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResponsePatientDTO extends SegmentDTO {
    private String patientFirstName;
    private String patientLastName;
    private String dateOfBirth;
}
