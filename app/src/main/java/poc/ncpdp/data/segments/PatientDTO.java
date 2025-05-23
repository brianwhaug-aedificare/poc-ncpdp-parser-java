package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PatientDTO extends SegmentDTO {
    private String patientIdQualifier;
    private String patientId;
    private String dateOfBirth;
    private String patientGenderCode;
    private String patientFirstName;
    private String patientLastName;
    private String patientStreetAddress;
    private String patientCity;
    private String patientStateOrProvince;
    private String patientZipPostalCode;
    private String patientPhoneNumber;
    private String placeOfService;
    private String employerId;
    private String smokerNonSmokerCode;
    private String pregnancyIndicator;
    private String patientEmailAddress;
    private String patientResidence;
}
