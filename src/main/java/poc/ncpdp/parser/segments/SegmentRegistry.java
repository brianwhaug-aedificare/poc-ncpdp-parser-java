package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import poc.ncpdp.data.segments.AdditionalDocumentationDTO;
import poc.ncpdp.data.segments.ClaimDTO;
import poc.ncpdp.data.segments.ClinicalDTO;
import poc.ncpdp.data.segments.CompoundDTO;
import poc.ncpdp.data.segments.CoordOfBenefitsDTO;
import poc.ncpdp.data.segments.CouponDTO;
import poc.ncpdp.data.segments.DurPpsDTO;
import poc.ncpdp.data.segments.FacilityDTO;
import poc.ncpdp.data.segments.InsuranceDTO;
import poc.ncpdp.data.segments.NarrativeDTO;
import poc.ncpdp.data.segments.PatientDTO;
import poc.ncpdp.data.segments.PharmacyProviderDTO;
import poc.ncpdp.data.segments.PrescriberDTO;
import poc.ncpdp.data.segments.PricingDTO;
import poc.ncpdp.data.segments.PriorAuthDTO;
import poc.ncpdp.data.segments.ResponseClaimDTO;
import poc.ncpdp.data.segments.ResponseCoordOfBenefitsDTO;
import poc.ncpdp.data.segments.ResponseDurPpsDTO;
import poc.ncpdp.data.segments.ResponseInsuranceAdditionalDocumentationDTO;
import poc.ncpdp.data.segments.ResponseInsuranceDTO;
import poc.ncpdp.data.segments.ResponseMessageDTO;
import poc.ncpdp.data.segments.ResponsePatientDTO;
import poc.ncpdp.data.segments.ResponsePricingDTO;
import poc.ncpdp.data.segments.ResponsePriorAuthDTO;
import poc.ncpdp.data.segments.ResponseStatusDTO;
import poc.ncpdp.data.segments.SegmentDTO;
import poc.ncpdp.data.segments.WorkersCompDTO;


/**
 * Registry to ensure all segment classes are loaded and registered
 */
public class SegmentRegistry {
    
    public static final String SEGMENT_PATIENT = "01";
    public static final String SEGMENT_PHARMACY_PROVIDER = "02";
    public static final String SEGMENT_PRESCRIBER = "03";
    public static final String SEGMENT_INSURANCE = "04";
    public static final String SEGMENT_COORD_OF_BENEFITS = "05";
    public static final String SEGMENT_WORKERS_COMP = "06";
    public static final String SEGMENT_CLAIM = "07";
    public static final String SEGMENT_DUR_PPS = "08";
    public static final String SEGMENT_COUPON = "09";
    public static final String SEGMENT_COMPOUND = "10";
    public static final String SEGMENT_PRICING = "11";
    public static final String SEGMENT_PRIOR_AUTH = "12";
    public static final String SEGMENT_CLINICAL = "13";
    public static final String SEGMENT_ADDITIONAL_DOCUMENTATION = "14";
    public static final String SEGMENT_FACILITY = "15";
    public static final String SEGMENT_NARRATIVE = "16";
    public static final String SEGMENT_RESPONSE_MESSAGE = "20";
    public static final String SEGMENT_RESPONSE_STATUS = "21";
    public static final String SEGMENT_RESPONSE_CLAIM = "22";
    public static final String SEGMENT_RESPONSE_PRICING = "23";
    public static final String SEGMENT_RESPONSE_DUR_PPS = "24";
    public static final String SEGMENT_RESPONSE_INSURANCE = "25";
    public static final String SEGMENT_RESPONSE_PRIOR_AUTH = "26";
    public static final String SEGMENT_RESPONSE_INSURANCE_ADDITIONAL_DOCUMENTATION = "27";
    public static final String SEGMENT_RESPONSE_COORD_OF_BENEFITS = "28";
    public static final String SEGMENT_RESPONSE_PATIENT = "29";

    private static final Map<String, Supplier<SegmentBase>> domainMap = new HashMap<>();
    private static final Map<String, Function<SegmentDTO, SegmentDTOBuilder>> builderMap = new HashMap<>();

    static {

        domainMap.put(SEGMENT_PATIENT, Patient::new);
        domainMap.put(SEGMENT_PHARMACY_PROVIDER, PharmacyProvider::new);
        domainMap.put(SEGMENT_PRESCRIBER, Prescriber::new);
        domainMap.put(SEGMENT_INSURANCE, Insurance::new);
        domainMap.put(SEGMENT_COORD_OF_BENEFITS, CoordOfBenefits::new);
        domainMap.put(SEGMENT_WORKERS_COMP, WorkersComp::new);
        domainMap.put(SEGMENT_CLAIM, Claim::new);
        domainMap.put(SEGMENT_DUR_PPS, DurPps::new);
        domainMap.put(SEGMENT_COUPON, Coupon::new);
        domainMap.put(SEGMENT_COMPOUND, Compound::new);
        domainMap.put(SEGMENT_PRICING, Pricing::new);
        domainMap.put(SEGMENT_PRIOR_AUTH, PriorAuth::new);
        domainMap.put(SEGMENT_CLINICAL, Clinical::new);
        domainMap.put(SEGMENT_ADDITIONAL_DOCUMENTATION, AdditionalDocumentation::new);
        domainMap.put(SEGMENT_FACILITY, Facility::new);
        domainMap.put(SEGMENT_NARRATIVE, Narrative::new);
        domainMap.put(SEGMENT_RESPONSE_MESSAGE, ResponseMessage::new);
        domainMap.put(SEGMENT_RESPONSE_STATUS, ResponseStatus::new);
        domainMap.put(SEGMENT_RESPONSE_CLAIM, ResponseClaim::new);
        domainMap.put(SEGMENT_RESPONSE_PRICING, ResponsePricing::new);
        domainMap.put(SEGMENT_RESPONSE_DUR_PPS, ResponseDurPps::new);
        domainMap.put(SEGMENT_RESPONSE_INSURANCE, ResponseInsurance::new);
        domainMap.put(SEGMENT_RESPONSE_PRIOR_AUTH, ResponsePriorAuth::new);
        domainMap.put(SEGMENT_RESPONSE_INSURANCE_ADDITIONAL_DOCUMENTATION, ResponseInsuranceAdditionalDocumentation::new);
        domainMap.put(SEGMENT_RESPONSE_COORD_OF_BENEFITS, ResponseCoordOfBenefits::new);
        domainMap.put(SEGMENT_RESPONSE_PATIENT, ResponsePatient::new);
    
        builderMap.put(SEGMENT_PATIENT, dto -> new Patient((PatientDTO) dto));
        builderMap.put(SEGMENT_PHARMACY_PROVIDER, dto -> new PharmacyProvider((PharmacyProviderDTO) dto));
        builderMap.put(SEGMENT_PRESCRIBER, dto -> new Prescriber((PrescriberDTO) dto));
        builderMap.put(SEGMENT_INSURANCE, dto -> new Insurance((InsuranceDTO) dto));
        builderMap.put(SEGMENT_COORD_OF_BENEFITS, dto -> new CoordOfBenefits((CoordOfBenefitsDTO) dto));
        builderMap.put(SEGMENT_WORKERS_COMP, dto -> new WorkersComp((WorkersCompDTO) dto));
        builderMap.put(SEGMENT_CLAIM, dto -> new Claim((ClaimDTO) dto));
        builderMap.put(SEGMENT_DUR_PPS, dto -> new DurPps((DurPpsDTO) dto));
        builderMap.put(SEGMENT_COUPON, dto -> new Coupon((CouponDTO) dto));
        builderMap.put(SEGMENT_COMPOUND, dto -> new Compound((CompoundDTO) dto));
        builderMap.put(SEGMENT_PRICING, dto -> new Pricing((PricingDTO) dto));
        builderMap.put(SEGMENT_PRIOR_AUTH, dto -> new PriorAuth((PriorAuthDTO) dto));
        builderMap.put(SEGMENT_CLINICAL, dto -> new Clinical((ClinicalDTO) dto));
        builderMap.put(SEGMENT_ADDITIONAL_DOCUMENTATION, dto -> new AdditionalDocumentation((AdditionalDocumentationDTO) dto));
        builderMap.put(SEGMENT_FACILITY, dto -> new Facility((FacilityDTO) dto));
        builderMap.put(SEGMENT_NARRATIVE, dto -> new Narrative((NarrativeDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_MESSAGE, dto -> new ResponseMessage((ResponseMessageDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_STATUS, dto -> new ResponseStatus((ResponseStatusDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_CLAIM, dto -> new ResponseClaim((ResponseClaimDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_PRICING, dto -> new ResponsePricing((ResponsePricingDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_DUR_PPS, dto -> new ResponseDurPps((ResponseDurPpsDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_INSURANCE, dto -> new ResponseInsurance((ResponseInsuranceDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_PRIOR_AUTH, dto -> new ResponsePriorAuth((ResponsePriorAuthDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_INSURANCE_ADDITIONAL_DOCUMENTATION, dto -> new ResponseInsuranceAdditionalDocumentation((ResponseInsuranceAdditionalDocumentationDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_COORD_OF_BENEFITS, dto -> new ResponseCoordOfBenefits((ResponseCoordOfBenefitsDTO) dto));
        builderMap.put(SEGMENT_RESPONSE_PATIENT, dto -> new ResponsePatient((ResponsePatientDTO) dto));
    }

    public static SegmentBase getSegment(String segmentIdentifier) {
        Supplier<SegmentBase> supplier = domainMap.get(segmentIdentifier);
        if (supplier == null) {
            throw new IllegalArgumentException("No segment found for identifier: " + segmentIdentifier);
        }
        return supplier.get();
    }

    public static SegmentDTOBuilder getBuilder(SegmentDTO segmentDTO) {
        String segmentIdentification = segmentDTO.getSegmentIdentification();
        Function<SegmentDTO, SegmentDTOBuilder> builderFunction = builderMap.get(segmentIdentification);
        if (builderFunction == null) {
            throw new IllegalArgumentException("No builder found for segment identification: " + segmentIdentification);
        }
        return builderFunction.apply(segmentDTO);
    }
}
