package poc.ncpdp.parser.segments;

/**
 * Registry to ensure all segment classes are loaded and registered
 */
public class SegmentRegistry {
    
    public static void initializeAllSegments() {
        // Request Segments (01-19)
        SegmentBase.registerSegment(Patient.class, "01");
        SegmentBase.registerSegment(PharmacyProvider.class, "02");
        SegmentBase.registerSegment(Prescriber.class, "03");
        SegmentBase.registerSegment(Insurance.class, "04");
        SegmentBase.registerSegment(CoordOfBenefits.class, "05");
        SegmentBase.registerSegment(WorkersComp.class, "06");
        SegmentBase.registerSegment(Claim.class, "07");
        SegmentBase.registerSegment(DurPps.class, "08");
        SegmentBase.registerSegment(Coupon.class, "09");
        SegmentBase.registerSegment(Compound.class, "10");
        SegmentBase.registerSegment(Pricing.class, "11");
        SegmentBase.registerSegment(PriorAuth.class, "12");
        SegmentBase.registerSegment(Clinical.class, "13");
        SegmentBase.registerSegment(AdditionalDocumentation.class, "14");
        SegmentBase.registerSegment(Facility.class, "15");
        SegmentBase.registerSegment(Narrative.class, "16");

        // Response Segments (20-29)
        SegmentBase.registerSegment(ResponseMessage.class, "20");
        SegmentBase.registerSegment(ResponseStatus.class, "21");
        SegmentBase.registerSegment(ResponseClaim.class, "22");
        SegmentBase.registerSegment(ResponsePricing.class, "23");
        SegmentBase.registerSegment(ResponseDurPps.class, "24");
        SegmentBase.registerSegment(ResponseInsurance.class, "25");
        SegmentBase.registerSegment(ResponsePriorAuth.class, "26");
        SegmentBase.registerSegment(ResponseInsuranceAdditionalDocumentation.class, "27");
        SegmentBase.registerSegment(ResponseCoordOfBenefits.class, "28");
        SegmentBase.registerSegment(ResponsePatient.class, "29");
        
    }
}
