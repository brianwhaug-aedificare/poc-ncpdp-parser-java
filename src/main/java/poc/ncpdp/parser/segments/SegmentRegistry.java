package poc.ncpdp.parser.segments;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Registry to ensure all segment classes are loaded and registered
 */
public class SegmentRegistry {
    
    public static final Map<String, String> segmentIdToSymbol = new HashMap<>();
    public static final Map<String, Class<? extends SegmentBase>> segmentIdToKlass = new HashMap<>();

     // Static initializer block to auto-initialize the registry
    static {
        initializeAllSegments();
    }
    
    public static void initializeAllSegments() {
        // Request Segments (01-19)
        registerSegment(Patient.class, "01");
        registerSegment(PharmacyProvider.class, "02");
        registerSegment(Prescriber.class, "03");
        registerSegment(Insurance.class, "04");
        registerSegment(CoordOfBenefits.class, "05");
        registerSegment(WorkersComp.class, "06");
        registerSegment(Claim.class, "07");
        registerSegment(DurPps.class, "08");
        registerSegment(Coupon.class, "09");
        registerSegment(Compound.class, "10");
        registerSegment(Pricing.class, "11");
        registerSegment(PriorAuth.class, "12");
        registerSegment(Clinical.class, "13");
        registerSegment(AdditionalDocumentation.class, "14");
        registerSegment(Facility.class, "15");
        registerSegment(Narrative.class, "16");

        // Response Segments (20-29)
        registerSegment(ResponseMessage.class, "20");
        registerSegment(ResponseStatus.class, "21");
        registerSegment(ResponseClaim.class, "22");
        registerSegment(ResponsePricing.class, "23");
        registerSegment(ResponseDurPps.class, "24");
        registerSegment(ResponseInsurance.class, "25");
        registerSegment(ResponsePriorAuth.class, "26");
        registerSegment(ResponseInsuranceAdditionalDocumentation.class, "27");
        registerSegment(ResponseCoordOfBenefits.class, "28");
        registerSegment(ResponsePatient.class, "29");
    }

    public static void registerSegment(Class<? extends SegmentBase> klass, String identifier) {
        segmentIdToKlass.put(identifier, klass);
        segmentIdToSymbol.put(identifier, getSymbol(klass));
    }

    public static String getSymbol(Class<?> klass) {
        String name = klass.getSimpleName();
        return name.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }
    
    public static Class<? extends SegmentBase> getKlassBySymbol(String sym) {
        String identifier = null;
        for (Map.Entry<String, String> entry : segmentIdToSymbol.entrySet()) {
            if (Objects.equals(entry.getValue(), sym)) {
                identifier = entry.getKey();
                break;
            }
        }
        return getKlassByIdentifier(identifier);
    }

    public static Class<? extends SegmentBase> getKlassByIdentifier(String identifier) {
        return segmentIdToKlass.getOrDefault(identifier, SegmentBase.class);
    }

    public static Class<? extends SegmentBase> segmentIdToKlass(String identifier) {
        return segmentIdToKlass.get(identifier);
    }

    public static String segmentIdByKlass(Class<? extends SegmentBase> klass) {
        for (Map.Entry<String, Class<? extends SegmentBase>> entry : segmentIdToKlass.entrySet()) {
            if (entry.getValue().equals(klass)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
