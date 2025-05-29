package poc.ncpdp.parser.transmissions.concerns;

import java.util.ArrayList;
import java.util.List;

import poc.ncpdp.parser.segments.*;
import poc.ncpdp.data.segments.*;
import poc.ncpdp.data.transmissions.RequestDTO;
import poc.ncpdp.data.transmissions.RequestHeaderDTO;
import poc.ncpdp.data.transmissions.TransmissionGroupDTO;
import poc.ncpdp.data.transmissions.TransactionGroupDTO;


public class MessageDTOProducer {

    public static RequestDTO produceFullRequestDTO() throws Exception {
        return produceFullRequestDTOWithEverySegment(null, null, null);
    }

    public static RequestDTO produceFullRequestDTOWithEverySegment(String bin, String transactionCode, String dateOfService) throws Exception {
        
        if (bin == null || bin.isEmpty()) {
            bin = "12345678"; // Default bin number
        }   
        if (transactionCode == null || transactionCode.isEmpty()) {
            transactionCode = "B1"; // Default transaction code
        }
        if (dateOfService == null || dateOfService.isEmpty()) {
            dateOfService = "20231001"; // Default date of service
        }
        
        RequestHeaderDTO headerDTO;
        
        // Create a RequestHeader object
        headerDTO = new RequestHeaderDTO(
            "12345678", // binNumber
            "D0",       // version
            "B1",       // transactionCode
            "1234567890", // processorControlNumber
            "1",        // transactionCount
            "1",       // serviceProviderIdQualifier
            "1234567890", // serviceProviderId
            "20231001", // dateOfService
            "654321" // software
        );
        
        // Create a TransmissionGroup object
        List<SegmentDTO> segments = new ArrayList<>();
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_PATIENT);
        patientDTO.setPatientIdQualifier("1");
        patientDTO.setPatientId("123456");
        patientDTO.setDateOfBirth("19800101");
        patientDTO.setPatientGenderCode("1");
        patientDTO.setPatientFirstName("John");
        patientDTO.setPatientLastName("Doe");
        patientDTO.setPatientStreetAddress("123 Main St");
        patientDTO.setPatientCity("Anytown");
        patientDTO.setPatientStateOrProvince("CA");
        patientDTO.setPatientZipPostalCode("90210");
        patientDTO.setPatientPhoneNumber("5551234567");
        patientDTO.setPatientEmailAddress("johndoe@email.com");
        patientDTO.setPlaceOfService("2");
        patientDTO.setEmployerId("1234567890");
        patientDTO.setSmokerNonSmokerCode("1");
        patientDTO.setPregnancyIndicator("0");
        patientDTO.setPatientResidence("2");
        segments.add(patientDTO);

        InsuranceDTO insuranceDTO = new InsuranceDTO();
        insuranceDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_INSURANCE);
        insuranceDTO.setCardholderId("123456");
        insuranceDTO.setCardholderFirstName("Jane");
        insuranceDTO.setCardholderLastName("Doe");
        insuranceDTO.setHomePlan("HomePlan1");
        insuranceDTO.setPlanId("Plan123");
        insuranceDTO.setEligibilityClarificationCode("01");
        insuranceDTO.setGroupId("Group123");
        insuranceDTO.setPersonCode("01");
        insuranceDTO.setPatientRelationshipCode("01");
        insuranceDTO.setOtherPayerBinNumber("123456");
        insuranceDTO.setOtherPayerProcessorControlNumber("1234567890");
        insuranceDTO.setOtherPayerCardholderId("987654");
        insuranceDTO.setOtherPayerGroupId("Group987");
        insuranceDTO.setMedigapId("Medigap123");
        insuranceDTO.setMedicaidIndicator("0");
        insuranceDTO.setProviderAcceptAssignmentIndicator("1");
        insuranceDTO.setCmsPartDDefinedQualifiedFacility("0");
        insuranceDTO.setMedicaidIdNumber("Medicaid123");
        insuranceDTO.setMedicaidAgencyNumber("Agency123");
        segments.add(insuranceDTO);
        
        TransmissionGroupDTO transmissionGroupDTO = new TransmissionGroupDTO(segments);

        // now build all the segments of the 1 transaction group
        // "pharmacy_provider",
        // "prescriber",
        // "coord_of_benefits",
        // "workers_comp",
        // "claim",
        // "dur_pps",
        // "coupon",
        // "compound",
        // "pricing",
        // "prior_auth",
        // "clinical",
        // "additional_documentation",
        // "facility",
        // "narrative",
        // "response_status",
        // "response_claim",
        // "response_pricing",
        // "response_dur_pps",
        // "response_prior_auth",
        // "response_additional_documentation",
        // "response_coord_of_benefits"


        List<SegmentDTO> transactionSegments = new ArrayList<>();

        PharmacyProviderDTO pharmacyProviderDTO = new PharmacyProviderDTO();
        pharmacyProviderDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_PHARMACY_PROVIDER);
        pharmacyProviderDTO.setProviderIdQualifier("01");
        pharmacyProviderDTO.setProviderId("9876543210");
        
        PrescriberDTO prescriberDTO = new PrescriberDTO();
        prescriberDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_PRESCRIBER);
        prescriberDTO.setPrescriberIdQualifier("02");
        prescriberDTO.setPrescriberId("1122334455");
        prescriberDTO.setPrescriberLastName("Smith");
        prescriberDTO.setPrescriberFirstName("Alice");
        prescriberDTO.setPrescriberPhoneNumber("5551122334");
        
        CoordOfBenefitsDTO coordOfBenefitsDTO = new CoordOfBenefitsDTO();
        coordOfBenefitsDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_COORD_OF_BENEFITS);
        coordOfBenefitsDTO.setOtherPayerIdQualifier("02");
        coordOfBenefitsDTO.setOtherPayerId("OPID123");
        coordOfBenefitsDTO.setOtherPayerDate("20240527");
        coordOfBenefitsDTO.setOtherPayerAmountPaidCount("2");
        coordOfBenefitsDTO.setOtherPayerAmountPaidQualifier("03");
        coordOfBenefitsDTO.setOtherPayerAmountPaid("150.00");
        coordOfBenefitsDTO.setOtherPayerRejectCount("1");
        coordOfBenefitsDTO.setOtherPayerRejectCode("04");
        coordOfBenefitsDTO.setOtherPayerCoverageType("A");
        
        WorkersCompDTO workersCompDTO = new WorkersCompDTO();
        workersCompDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_WORKERS_COMP);
        workersCompDTO.setDateOfInjury("20231212");
        workersCompDTO.setEmployerName("Test Employer");
        workersCompDTO.setEmployerStreetAddress("789 Employer Rd");
        workersCompDTO.setEmployerCityAddress("Employertown");
        workersCompDTO.setEmployerStateProvinceAddress("NY");
        workersCompDTO.setEmployerZipPostalCode("10001");
        workersCompDTO.setEmployerPhoneNumber("5553334444");
        workersCompDTO.setEmployerContactName("Bob Manager");
        workersCompDTO.setCarrierId("CARRIER123");
        workersCompDTO.setClaimReferenceId("CLAIM456");
        workersCompDTO.setBillingEntityTypeIndicator("1");
        workersCompDTO.setPayToQualifier("08");
        workersCompDTO.setPayToId("PAYTOID");
        workersCompDTO.setPayToName("Payee Name");
        workersCompDTO.setPayToStreetAddress("123 Payee St");
        workersCompDTO.setPayToCityAddress("Payeetown");
        workersCompDTO.setPayToStateProvinceAddress("CA");
        workersCompDTO.setPayToZipPostalZone("90211");
        workersCompDTO.setGenericEquivalentProductIdQualifier("09");
        workersCompDTO.setGenericEquivalentProductId("GENPRODID");
        
        ClaimDTO claimDTO = new ClaimDTO();
        claimDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_CLAIM);
        claimDTO.setPrescriptionReferenceNumberQualifier("10");
        claimDTO.setPrescriptionReferenceNumber("RX123456");
        claimDTO.setProductServiceIdQualifier("11");
        claimDTO.setProductServiceId("PROD789");
        claimDTO.setAssociatedPrescriptionReferenceNumber("RX654321");
        claimDTO.setAssociatedPrescriptionDate("20240115");
        claimDTO.setProcedureModifierCodeCount("1");
        claimDTO.setProcedureModifierCode("MOD1");
        claimDTO.setQuantityDispensed("30");
        claimDTO.setFillNumber("2");
        claimDTO.setDaysSupply("15");
        claimDTO.setCompoundCode("0");
        claimDTO.setDispenseAsWrittenProductSelectionCode("1");
        claimDTO.setDatePrescriptionWritten("20240110");
        claimDTO.setNumberOfRefillsAuthorized("3");
        claimDTO.setPrescriptionOriginCode("12");
        claimDTO.setSubmissionClarificationCodeCount("1");
        claimDTO.setSubmissionClarificationCode("SC1");
        claimDTO.setQuantityPrescribed("60");
        claimDTO.setOtherCoverageCode("13");
        claimDTO.setSpecialPackagingIndicator("0");
        claimDTO.setOriginallyPrescribedIdQualifier("14");
        claimDTO.setOriginallyPrescribedCode("OPC1");
        claimDTO.setOriginallyPrescribedQuantity("90");
        claimDTO.setAlternateId("ALTID");
        claimDTO.setScheduledPrescriptionIdNumber("SPID1");
        claimDTO.setUnitOfMeasure("TAB");
        claimDTO.setLevelOfService("15");
        claimDTO.setPriorAuthorizationTypeCode("16");
        claimDTO.setPriorAuthorizationNumberSubmitted("PA123");
        claimDTO.setIntermediaryAuthorizationTypeId("17");
        claimDTO.setIntermediaryAuthorizationId("IAID1");
        claimDTO.setDispensingStatus("18");
        claimDTO.setQuantityIntendedToBeDispensed("120");
        claimDTO.setDaysSupplyIntendedToBeDispensed("60");
        claimDTO.setDelayReasonCode("19");
        claimDTO.setTransactionReferenceNumber("TRN1");
        claimDTO.setPatientAssignmentIndicator("20");
        claimDTO.setRouteOfAdministration("21");
        claimDTO.setCompoundType("22");
        claimDTO.setMedicadeIcn("MICN1");
        claimDTO.setPharmacyServiceType("23");

        DurPpsDTO durPpsDTO = new DurPpsDTO();
        durPpsDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_DUR_PPS);
        durPpsDTO.setDurPpsCodeCounter("1");
        durPpsDTO.setReasonForServiceCode("A");
        durPpsDTO.setProfessionalServiceCode("B");
        durPpsDTO.setResultOfServiceCode("C");
        durPpsDTO.setDurPpsLevelOfEffort("D");
        durPpsDTO.setDurCoAgentIdQualifier("E");
        durPpsDTO.setDurCoAgentId("F");
        
        CouponDTO couponDTO = new CouponDTO();
        couponDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_COUPON);
        couponDTO.setCouponType("A");
        couponDTO.setCouponNumber("COUP123");
        couponDTO.setCouponValueAmount("5000");

        CompoundDTO compoundDTO = new CompoundDTO();
        compoundDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_COMPOUND);
        compoundDTO.setCompoundDosageFormDescriptionCode("A");
        compoundDTO.setCompoundDispensingUnitFormIndicator("1");
        compoundDTO.setCompoundIngredientComponentCount("3");
        compoundDTO.setCompoundProductIdQualifier("A");
        compoundDTO.setCompoundProductId("PROD123");
        compoundDTO.setCompoundIngredientQuantity("10.00");
        compoundDTO.setCompoundIngredientDrugCost("50.00");
        compoundDTO.setCompoundIngredientBasisOfCostDetermination("B");
        compoundDTO.setCompoundIngredientModifierCodeCount("2");
        compoundDTO.setCompoundIngredientModifierCode("MOD123");
        
        PricingDTO pricingDTO = new PricingDTO();
        pricingDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_PRICING);
        pricingDTO.setIngredientCostSubmitted("1000");
        pricingDTO.setDispensingFeeSubmitted("5000");
        pricingDTO.setPatientPaidAmountSubmitted("1ØØ{");
        pricingDTO.setIncentiveAmountSubmitted("1ØØ{");
        pricingDTO.setProfessionalServiceFeeSubmitted("50{");
        pricingDTO.setOtherAmountClaimedSubmittedCount("1");
        pricingDTO.setOtherAmountClaimedSubmittedQualifier("1");
        pricingDTO.setOtherAmountClaimedSubmitted("1500{");
        pricingDTO.setGrossAmountDue("12000{");
        pricingDTO.setBasisOfCostDetermination("G");

        PriorAuthDTO priorAuthDTO = new PriorAuthDTO();
        priorAuthDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_PRIOR_AUTH);
        priorAuthDTO.setPriorAuthorizationProcessedDate("20231001");
        priorAuthDTO.setPriorAuthorizationEffectiveDate("20231002");
        priorAuthDTO.setPriorAuthorizationExpirationDate("20231031");
        priorAuthDTO.setPriorAuthorizationQuantity("30");
        priorAuthDTO.setPriorAuthorizationDollarsAuthorized("1500");
        priorAuthDTO.setPriorAuthorizationNumberOfRefillsAuthorized("2");
        priorAuthDTO.setPriorAuthorizationQuantityAccumulated("15");
        priorAuthDTO.setPriorAuthorizationNumberAssigned("PA123456");

        ClinicalDTO clinicalDTO = new ClinicalDTO();
        clinicalDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_CLINICAL);
        clinicalDTO.setDiagnosisCodeCount("1");
        clinicalDTO.setDiagnosisCodeQualifier("A");
        clinicalDTO.setDiagnosisCode("D123");
        clinicalDTO.setClinicalInformationCounter("1");
        clinicalDTO.setMeasurementDate("20240527");
        clinicalDTO.setMeasurementTime("1200");
        clinicalDTO.setMeasurementDimension("cm");
        clinicalDTO.setMeasurementUnit("mg");
        clinicalDTO.setMeasurementValue("100.00");
        
        AdditionalDocumentationDTO additionalDocumentationDTO = new AdditionalDocumentationDTO();
        additionalDocumentationDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_ADDITIONAL_DOCUMENTATION);
        additionalDocumentationDTO.setAdditionalDocumentationTypeId("AD123");
        additionalDocumentationDTO.setRequestPeriodBeginDate("20240501");
        additionalDocumentationDTO.setRequestPeriodRecertRevisedDate("20240515");
        additionalDocumentationDTO.setRequestStatus("Pending");
        additionalDocumentationDTO.setLengthOfNeedQualifier("LON123");
        additionalDocumentationDTO.setLengthOfNeed("12 months");
        additionalDocumentationDTO.setPrescriberSupplierDateSigned("20240520");
        additionalDocumentationDTO.setSupportingDocumentation("Supporting docs here");
        additionalDocumentationDTO.setQuestionNumberLetterCount("2");
        additionalDocumentationDTO.setQuestionNumberLetter("Q1");
        additionalDocumentationDTO.setQuestionPercentResponse("75%");
        additionalDocumentationDTO.setQuestionDateResponse("20240525");
        additionalDocumentationDTO.setQuestionDollarAmountResponse("100.00");
        additionalDocumentationDTO.setQuestionNumericResponse("50");
        additionalDocumentationDTO.setQuestionAlphanumericResponse("Response123");

        FacilityDTO facilityDTO = new FacilityDTO();
        facilityDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_FACILITY);
        facilityDTO.setFacilityId("FAC123");
        facilityDTO.setFacilityName("Test Facility");
        facilityDTO.setFacilityStreetAddress("456 Facility Ave");
        facilityDTO.setFacilityCityAddress("Facility City");
        facilityDTO.setFacilityStateProvinceAddress("TX");
        facilityDTO.setFacilityZipPostalZone("75001");
            
        NarrativeDTO narrativeDTO = new NarrativeDTO();
        narrativeDTO.setSegmentIdentification(SegmentRegistry.SEGMENT_NARRATIVE);
        narrativeDTO.setNarrativeMessage("This is a test narrative for the NCPDP parser.");

        transactionSegments.add(pharmacyProviderDTO);
        transactionSegments.add(prescriberDTO);
        transactionSegments.add(coordOfBenefitsDTO);
        transactionSegments.add(workersCompDTO);
        transactionSegments.add(claimDTO);
        transactionSegments.add(durPpsDTO);
        transactionSegments.add(couponDTO);
        transactionSegments.add(compoundDTO);
        transactionSegments.add(pricingDTO);
        transactionSegments.add(priorAuthDTO);
        transactionSegments.add(clinicalDTO);
        transactionSegments.add(additionalDocumentationDTO);
        transactionSegments.add(facilityDTO);
        transactionSegments.add(narrativeDTO);

        TransactionGroupDTO transactionGroupDTO = new TransactionGroupDTO(transactionSegments);

        List<TransactionGroupDTO> transactionGroupDTOs = new ArrayList<>();
        transactionGroupDTOs.add(transactionGroupDTO);

        RequestDTO request = new RequestDTO(headerDTO, transmissionGroupDTO, transactionGroupDTOs);

        return request;
    }
}
