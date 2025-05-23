package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import poc.ncpdp.data.segments.ClaimDTO;

public class Claim extends SegmentBase {
    private final ClaimMapper mapper = new ClaimMapper();
    private ClaimDTO claimDTO;

    public Claim() {
        super();
        this.claimDTO = new ClaimDTO();
    }

    public Claim(ClaimDTO claimDTO) {
        super();
        this.claimDTO = claimDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("EM", "prescriptionReferenceNumberQualifier");
        map.put("D2", "prescriptionReferenceNumber");
        map.put("E1", "productServiceIdQualifier");
        map.put("D7", "productServiceId");
        map.put("EN", "associatedPrescriptionReferenceNumber");
        map.put("EP", "associatedPrescriptionDate");
        map.put("SE", "procedureModifierCodeCount");
        map.put("ER", "procedureModifierCode");
        map.put("E7", "quantityDispensed");
        map.put("D3", "fillNumber");
        map.put("D5", "daysSupply");
        map.put("D6", "compoundCode");
        map.put("D8", "dispenseAsWrittenProductSelectionCode");
        map.put("DE", "datePrescriptionWritten");
        map.put("DF", "numberOfRefillsAuthorized");
        map.put("DJ", "prescriptionOriginCode");
        map.put("NX", "submissionClarificationCodeCount");
        map.put("DK", "submissionClarificationCode");
        map.put("ET", "quantityPrescribed");
        map.put("C8", "otherCoverageCode");
        map.put("DT", "specialPackagingIndicator");
        map.put("EJ", "originallyPrescribedIdQualifier");
        map.put("EA", "originallyPrescribedCode");
        map.put("EB", "originallyPrescribedQuantity");
        map.put("CW", "alternateId");
        map.put("EK", "scheduledPrescriptionIdNumber");
        map.put("28", "unitOfMeasure");
        map.put("DI", "levelOfService");
        map.put("EU", "priorAuthorizationTypeCode");
        map.put("EV", "priorAuthorizationNumberSubmitted");
        map.put("EW", "intermediaryAuthorizationTypeId");
        map.put("EX", "intermediaryAuthorizationId");
        map.put("HD", "dispensingStatus");
        map.put("HF", "quantityIntendedToBeDispensed");
        map.put("HG", "daysSupplyIntendedToBeDispensed");
        map.put("NV", "delayReasonCode");
        map.put("K5", "transactionReferenceNumber");
        map.put("MT", "patientAssignmentIndicator");
        map.put("E2", "routeOfAdministration");
        map.put("G1", "compoundType");
        map.put("N4", "medicadeIcn");
        map.put("U7", "pharmacyServiceType");
        return Collections.unmodifiableMap(map);
    }

    public ClaimDTO setDTOValues(Map<String, Object> values) {
        mapper.updateClaimDTOFromMap(values, claimDTO);
        setSegmentIdentification(claimDTO);
        return this.claimDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromClaimDTO(claimDTO, values);
        return values;
    }

    private static class ClaimMapper {
        private static final Map<String, BiConsumer<ClaimDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new HashMap<>();
            FIELD_SETTERS.put("EM", (dto, v) -> dto.setPrescriptionReferenceNumberQualifier(v));
            FIELD_SETTERS.put("D2", (dto, v) -> dto.setPrescriptionReferenceNumber(v));
            FIELD_SETTERS.put("E1", (dto, v) -> dto.setProductServiceIdQualifier(v));
            FIELD_SETTERS.put("D7", (dto, v) -> dto.setProductServiceId(v));
            FIELD_SETTERS.put("EN", (dto, v) -> dto.setAssociatedPrescriptionReferenceNumber(v));
            FIELD_SETTERS.put("EP", (dto, v) -> dto.setAssociatedPrescriptionDate(v));
            FIELD_SETTERS.put("SE", (dto, v) -> dto.setProcedureModifierCodeCount(v));
            FIELD_SETTERS.put("ER", (dto, v) -> dto.setProcedureModifierCode(v));
            FIELD_SETTERS.put("E7", (dto, v) -> dto.setQuantityDispensed(v));
            FIELD_SETTERS.put("D3", (dto, v) -> dto.setFillNumber(v));
            FIELD_SETTERS.put("D5", (dto, v) -> dto.setDaysSupply(v));
            FIELD_SETTERS.put("D6", (dto, v) -> dto.setCompoundCode(v));
            FIELD_SETTERS.put("D8", (dto, v) -> dto.setDispenseAsWrittenProductSelectionCode(v));
            FIELD_SETTERS.put("DE", (dto, v) -> dto.setDatePrescriptionWritten(v));
            FIELD_SETTERS.put("DF", (dto, v) -> dto.setNumberOfRefillsAuthorized(v));
            FIELD_SETTERS.put("DJ", (dto, v) -> dto.setPrescriptionOriginCode(v));
            FIELD_SETTERS.put("NX", (dto, v) -> dto.setSubmissionClarificationCodeCount(v));
            FIELD_SETTERS.put("DK", (dto, v) -> dto.setSubmissionClarificationCode(v));
            FIELD_SETTERS.put("ET", (dto, v) -> dto.setQuantityPrescribed(v));
            FIELD_SETTERS.put("C8", (dto, v) -> dto.setOtherCoverageCode(v));
            FIELD_SETTERS.put("DT", (dto, v) -> dto.setSpecialPackagingIndicator(v));
            FIELD_SETTERS.put("EJ", (dto, v) -> dto.setOriginallyPrescribedIdQualifier(v));
            FIELD_SETTERS.put("EA", (dto, v) -> dto.setOriginallyPrescribedCode(v));
            FIELD_SETTERS.put("EB", (dto, v) -> dto.setOriginallyPrescribedQuantity(v));
            FIELD_SETTERS.put("CW", (dto, v) -> dto.setAlternateId(v));
            FIELD_SETTERS.put("EK", (dto, v) -> dto.setScheduledPrescriptionIdNumber(v));
            FIELD_SETTERS.put("28", (dto, v) -> dto.setUnitOfMeasure(v));
            FIELD_SETTERS.put("DI", (dto, v) -> dto.setLevelOfService(v));
            FIELD_SETTERS.put("EU", (dto, v) -> dto.setPriorAuthorizationTypeCode(v));
            FIELD_SETTERS.put("EV", (dto, v) -> dto.setPriorAuthorizationNumberSubmitted(v));
            FIELD_SETTERS.put("EW", (dto, v) -> dto.setIntermediaryAuthorizationTypeId(v));
            FIELD_SETTERS.put("EX", (dto, v) -> dto.setIntermediaryAuthorizationId(v));
            FIELD_SETTERS.put("HD", (dto, v) -> dto.setDispensingStatus(v));
            FIELD_SETTERS.put("HF", (dto, v) -> dto.setQuantityIntendedToBeDispensed(v));
            FIELD_SETTERS.put("HG", (dto, v) -> dto.setDaysSupplyIntendedToBeDispensed(v));
            FIELD_SETTERS.put("NV", (dto, v) -> dto.setDelayReasonCode(v));
            FIELD_SETTERS.put("K5", (dto, v) -> dto.setTransactionReferenceNumber(v));
            FIELD_SETTERS.put("MT", (dto, v) -> dto.setPatientAssignmentIndicator(v));
            FIELD_SETTERS.put("E2", (dto, v) -> dto.setRouteOfAdministration(v));
            FIELD_SETTERS.put("G1", (dto, v) -> dto.setCompoundType(v));
            FIELD_SETTERS.put("N4", (dto, v) -> dto.setMedicadeIcn(v));
            FIELD_SETTERS.put("U7", (dto, v) -> dto.setPharmacyServiceType(v));
        }

        public void updateClaimDTOFromMap(Map<String, Object> values, ClaimDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<ClaimDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromClaimDTO(ClaimDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            putIfNotNull(values, "EM", dto.getPrescriptionReferenceNumberQualifier());
            putIfNotNull(values, "D2", dto.getPrescriptionReferenceNumber());
            putIfNotNull(values, "E1", dto.getProductServiceIdQualifier());
            putIfNotNull(values, "D7", dto.getProductServiceId());
            putIfNotNull(values, "EN", dto.getAssociatedPrescriptionReferenceNumber());
            putIfNotNull(values, "EP", dto.getAssociatedPrescriptionDate());
            putIfNotNull(values, "SE", dto.getProcedureModifierCodeCount());
            putIfNotNull(values, "ER", dto.getProcedureModifierCode());
            putIfNotNull(values, "E7", dto.getQuantityDispensed());
            putIfNotNull(values, "D3", dto.getFillNumber());
            putIfNotNull(values, "D5", dto.getDaysSupply());
            putIfNotNull(values, "D6", dto.getCompoundCode());
            putIfNotNull(values, "D8", dto.getDispenseAsWrittenProductSelectionCode());
            putIfNotNull(values, "DE", dto.getDatePrescriptionWritten());
            putIfNotNull(values, "DF", dto.getNumberOfRefillsAuthorized());
            putIfNotNull(values, "DJ", dto.getPrescriptionOriginCode());
            putIfNotNull(values, "NX", dto.getSubmissionClarificationCodeCount());
            putIfNotNull(values, "DK", dto.getSubmissionClarificationCode());
            putIfNotNull(values, "ET", dto.getQuantityPrescribed());
            putIfNotNull(values, "C8", dto.getOtherCoverageCode());
            putIfNotNull(values, "DT", dto.getSpecialPackagingIndicator());
            putIfNotNull(values, "EJ", dto.getOriginallyPrescribedIdQualifier());
            putIfNotNull(values, "EA", dto.getOriginallyPrescribedCode());
            putIfNotNull(values, "EB", dto.getOriginallyPrescribedQuantity());
            putIfNotNull(values, "CW", dto.getAlternateId());
            putIfNotNull(values, "EK", dto.getScheduledPrescriptionIdNumber());
            putIfNotNull(values, "28", dto.getUnitOfMeasure());
            putIfNotNull(values, "DI", dto.getLevelOfService());
            putIfNotNull(values, "EU", dto.getPriorAuthorizationTypeCode());
            putIfNotNull(values, "EV", dto.getPriorAuthorizationNumberSubmitted());
            putIfNotNull(values, "EW", dto.getIntermediaryAuthorizationTypeId());
            putIfNotNull(values, "EX", dto.getIntermediaryAuthorizationId());
            putIfNotNull(values, "HD", dto.getDispensingStatus());
            putIfNotNull(values, "HF", dto.getQuantityIntendedToBeDispensed());
            putIfNotNull(values, "HG", dto.getDaysSupplyIntendedToBeDispensed());
            putIfNotNull(values, "NV", dto.getDelayReasonCode());
            putIfNotNull(values, "K5", dto.getTransactionReferenceNumber());
            putIfNotNull(values, "MT", dto.getPatientAssignmentIndicator());
            putIfNotNull(values, "E2", dto.getRouteOfAdministration());
            putIfNotNull(values, "G1", dto.getCompoundType());
            putIfNotNull(values, "N4", dto.getMedicadeIcn());
            putIfNotNull(values, "U7", dto.getPharmacyServiceType());
        }
    }
}
