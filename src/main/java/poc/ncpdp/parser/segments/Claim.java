package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java .util.function.Function;

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

        private static final Map<String, Function<ClaimDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("EM", ClaimDTO::getPrescriptionReferenceNumberQualifier);
            FIELD_GETTERS.put("D2", ClaimDTO::getPrescriptionReferenceNumber);
            FIELD_GETTERS.put("E1", ClaimDTO::getProductServiceIdQualifier);
            FIELD_GETTERS.put("D7", ClaimDTO::getProductServiceId);
            FIELD_GETTERS.put("EN", ClaimDTO::getAssociatedPrescriptionReferenceNumber);
            FIELD_GETTERS.put("EP", ClaimDTO::getAssociatedPrescriptionDate);
            FIELD_GETTERS.put("SE", ClaimDTO::getProcedureModifierCodeCount);
            FIELD_GETTERS.put("ER", ClaimDTO::getProcedureModifierCode);
            FIELD_GETTERS.put("E7", ClaimDTO::getQuantityDispensed);
            FIELD_GETTERS.put("D3", ClaimDTO::getFillNumber);
            FIELD_GETTERS.put("D5", ClaimDTO::getDaysSupply);
            FIELD_GETTERS.put("D6", ClaimDTO::getCompoundCode);
            FIELD_GETTERS.put("D8", ClaimDTO::getDispenseAsWrittenProductSelectionCode);
            FIELD_GETTERS.put("DE", ClaimDTO::getDatePrescriptionWritten);
            FIELD_GETTERS.put("DF", ClaimDTO::getNumberOfRefillsAuthorized);
            FIELD_GETTERS.put("DJ", ClaimDTO::getPrescriptionOriginCode);
            FIELD_GETTERS.put("NX", ClaimDTO::getSubmissionClarificationCodeCount);
            FIELD_GETTERS.put("DK", ClaimDTO::getSubmissionClarificationCode);
            FIELD_GETTERS.put("ET", ClaimDTO::getQuantityPrescribed);
            FIELD_GETTERS.put("C8", ClaimDTO::getOtherCoverageCode);
            FIELD_GETTERS.put("DT", ClaimDTO::getSpecialPackagingIndicator);
            FIELD_GETTERS.put("EJ", ClaimDTO::getOriginallyPrescribedIdQualifier);
            FIELD_GETTERS.put("EA", ClaimDTO::getOriginallyPrescribedCode);
            FIELD_GETTERS.put("EB", ClaimDTO::getOriginallyPrescribedQuantity);
            FIELD_GETTERS.put("CW", ClaimDTO::getAlternateId);
            FIELD_GETTERS.put("EK", ClaimDTO::getScheduledPrescriptionIdNumber);
            FIELD_GETTERS.put("28", ClaimDTO::getUnitOfMeasure);
            FIELD_GETTERS.put("DI", ClaimDTO::getLevelOfService);
            FIELD_GETTERS.put("EU", ClaimDTO::getPriorAuthorizationTypeCode);
            FIELD_GETTERS.put("EV", ClaimDTO::getPriorAuthorizationNumberSubmitted);
            FIELD_GETTERS.put("EW", ClaimDTO::getIntermediaryAuthorizationTypeId);
            FIELD_GETTERS.put("EX", ClaimDTO::getIntermediaryAuthorizationId);
            FIELD_GETTERS.put("HD", ClaimDTO::getDispensingStatus);
            FIELD_GETTERS.put("HF", ClaimDTO::getQuantityIntendedToBeDispensed);
            FIELD_GETTERS.put("HG", ClaimDTO::getDaysSupplyIntendedToBeDispensed);
            FIELD_GETTERS.put("NV", ClaimDTO::getDelayReasonCode);
            FIELD_GETTERS.put("K5", ClaimDTO::getTransactionReferenceNumber);
            FIELD_GETTERS.put("MT", ClaimDTO::getPatientAssignmentIndicator);
            FIELD_GETTERS.put("E2", ClaimDTO::getRouteOfAdministration);
            FIELD_GETTERS.put("G1", ClaimDTO::getCompoundType);
            FIELD_GETTERS.put("N4", ClaimDTO::getMedicadeIcn);
            FIELD_GETTERS.put("U7", ClaimDTO::getPharmacyServiceType);
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
            FIELD_GETTERS.forEach((key, getter) -> {
                Object value = getter.apply(dto);
                if (value != null) {
                    values.put(key, value);
                }
            });
        }
    }
}
