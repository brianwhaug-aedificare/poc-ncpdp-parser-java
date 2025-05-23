package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.ClaimDTO;

public class Claim extends SegmentBase {
    private final ClaimMapper mapper = new ClaimMapper();
    private ClaimDTO claimDTO;

    public Claim() {
        super();
        this.claimDTO = new ClaimDTO();
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

    private class ClaimMapper {
        public void updateClaimDTOFromMap(Map<String, Object> values, ClaimDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "EM": dto.setPrescriptionReferenceNumberQualifier(value); break;
                    case "D2": dto.setPrescriptionReferenceNumber(value); break;
                    case "E1": dto.setProductServiceIdQualifier(value); break;
                    case "D7": dto.setProductServiceId(value); break;
                    case "EN": dto.setAssociatedPrescriptionReferenceNumber(value); break;
                    case "EP": dto.setAssociatedPrescriptionDate(value); break;
                    case "SE": dto.setProcedureModifierCodeCount(value); break;
                    case "ER": dto.setProcedureModifierCode(value); break;
                    case "E7": dto.setQuantityDispensed(value); break;
                    case "D3": dto.setFillNumber(value); break;
                    case "D5": dto.setDaysSupply(value); break;
                    case "D6": dto.setCompoundCode(value); break;
                    case "D8": dto.setDispenseAsWrittenProductSelectionCode(value); break;
                    case "DE": dto.setDatePrescriptionWritten(value); break;
                    case "DF": dto.setNumberOfRefillsAuthorized(value); break;
                    case "DJ": dto.setPrescriptionOriginCode(value); break;
                    case "NX": dto.setSubmissionClarificationCodeCount(value); break;
                    case "DK": dto.setSubmissionClarificationCode(value); break;
                    case "ET": dto.setQuantityPrescribed(value); break;
                    case "C8": dto.setOtherCoverageCode(value); break;
                    case "DT": dto.setSpecialPackagingIndicator(value); break;
                    case "EJ": dto.setOriginallyPrescribedIdQualifier(value); break;
                    case "EA": dto.setOriginallyPrescribedCode(value); break;
                    case "EB": dto.setOriginallyPrescribedQuantity(value); break;
                    case "CW": dto.setAlternateId(value); break;
                    case "EK": dto.setScheduledPrescriptionIdNumber(value); break;
                    case "28": dto.setUnitOfMeasure(value); break;
                    case "DI": dto.setLevelOfService(value); break;
                    case "EU": dto.setPriorAuthorizationTypeCode(value); break;
                    case "EV": dto.setPriorAuthorizationNumberSubmitted(value); break;
                    case "EW": dto.setIntermediaryAuthorizationTypeId(value); break;
                    case "EX": dto.setIntermediaryAuthorizationId(value); break;
                    case "HD": dto.setDispensingStatus(value); break;
                    case "HF": dto.setQuantityIntendedToBeDispensed(value); break;
                    case "HG": dto.setDaysSupplyIntendedToBeDispensed(value); break;
                    case "NV": dto.setDelayReasonCode(value); break;
                    case "K5": dto.setTransactionReferenceNumber(value); break;
                    case "MT": dto.setPatientAssignmentIndicator(value); break;
                    case "E2": dto.setRouteOfAdministration(value); break;
                    case "G1": dto.setCompoundType(value); break;
                    case "N4": dto.setMedicadeIcn(value); break;
                    case "U7": dto.setPharmacyServiceType(value); break;
                }
            }
        }
    }
}
