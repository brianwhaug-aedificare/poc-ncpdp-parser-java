package poc.ncpdp.parser.utils;

import java.util.HashMap;
import java.util.Map;

public class RejectionCodes {
    private static final Map<String, String> REJECTION_CODES = new HashMap<>();

    static {
        REJECTION_CODES.put("1", "MISSING_OR_INVALID_BIN");
        REJECTION_CODES.put("2", "MISSING_OR_INVALID_VERSION_NUMBER");
        REJECTION_CODES.put("3", "MISSING_OR_INVALID_TRANSACTION_CODE");
        REJECTION_CODES.put("4", "MISSING_OR_INVALID_PROCESSOR_CONTROL_NUMBER");
        REJECTION_CODES.put("5", "MISSING_OR_INVALID_PHARMACY_NUMBER");
        REJECTION_CODES.put("6", "MISSING_OR_INVALID_GROUP_NUMBER");
        REJECTION_CODES.put("7", "MISSING_OR_INVALID_CARDHOLDER_ID_NUMBER");
        REJECTION_CODES.put("8", "MISSING_OR_INVALID_PERSON_CODE");
        REJECTION_CODES.put("9", "MISSING_OR_INVALID_BIRTH_DATE");
        REJECTION_CODES.put("10", "MISSING_OR_INVALID_PATIENT_GENDER_CODE");
        REJECTION_CODES.put("11", "MISSING_OR_INVALID_PATIENT_RELATIONSHIP_CODE");
        REJECTION_CODES.put("12", "MISSING_OR_INVALID_PATIENT_LOCATION");
        REJECTION_CODES.put("13", "MISSING_OR_INVALID_OTHER_COVERAGE_CODE");
        REJECTION_CODES.put("14", "MISSING_OR_INVALID_ELIGIBILITY_CLARIFICATION_CODE");
        REJECTION_CODES.put("15", "MISSING_OR_INVALID_DATE_OF_SERVICE");
        REJECTION_CODES.put("16", "MISSING_OR_INVALID_PRESCRIPTION_SERVICE_REFERENCE_NUMBER");
        REJECTION_CODES.put("17", "MISSING_OR_INVALID_FILL_NUMBER");
        REJECTION_CODES.put("19", "MISSING_OR_INVALID_DAYS_SUPPLY");
        REJECTION_CODES.put("1C", "MISSING_OR_INVALID_SMOKER_NON_SMOKER_CODE");
        REJECTION_CODES.put("1E", "MISSING_OR_INVALID_PRESCRIBER_LOCATION_CODE");
        REJECTION_CODES.put("20", "MISSING_OR_INVALID_COMPOUND_CODE");
        REJECTION_CODES.put("21", "MISSING_OR_INVALID_PRODUCT_SERVICE_ID");
        REJECTION_CODES.put("22", "MISSING_OR_INVALID_DISPENSE_AS_WRITTEN_DAW_PRODUCT_SELECTION_CODE");
        REJECTION_CODES.put("23", "MISSING_OR_INVALID_INGREDIENT_COST_SUBMITTED");
        REJECTION_CODES.put("25", "MISSING_OR_INVALID_PRESCRIBER_ID");
        REJECTION_CODES.put("26", "MISSING_OR_INVALID_UNIT_OF_MEASURE");
        REJECTION_CODES.put("28", "MISSING_OR_INVALID_DATE_PRESCRIPTION_WRITTEN");
        REJECTION_CODES.put("29", "MISSING_OR_INVALID_NUMBER_REFILLS_AUTHORIZED");
        REJECTION_CODES.put("2C", "MISSING_OR_INVALID_PREGNANCY_INDICATOR");
        REJECTION_CODES.put("2E", "MISSING_OR_INVALID_PRIMARY_CARE_PROVIDER_ID_QUALIFIER");
        REJECTION_CODES.put("32", "MISSING_OR_INVALID_LEVEL_OF_SERVICE");
        REJECTION_CODES.put("33", "MISSING_OR_INVALID_PRESCRIPTION_ORIGIN_CODE");
        REJECTION_CODES.put("34", "MISSING_OR_INVALID_SUBMISSION_CLARIFICATION_CODE");
        REJECTION_CODES.put("35", "MISSING_OR_INVALID_PRIMARY_CARE_PROVIDER_ID");
        REJECTION_CODES.put("38", "MISSING_OR_INVALID_BASIS_OF_COST");
        REJECTION_CODES.put("39", "MISSING_OR_INVALID_DIAGNOSIS_CODE");
        REJECTION_CODES.put("3A", "MISSING_OR_INVALID_REQUEST_TYPE");
        REJECTION_CODES.put("3B", "MISSING_OR_INVALID_REQUEST_PERIOD_DATE_BEGIN");
        REJECTION_CODES.put("3C", "MISSING_OR_INVALID_REQUEST_PERIOD_DATE_END");
        REJECTION_CODES.put("3D", "MISSING_OR_INVALID_BASIS_OF_REQUEST");
        REJECTION_CODES.put("3E", "MISSING_OR_INVALID_AUTHORIZED_REPRESENTATIVE_FIRST_NAME");
        REJECTION_CODES.put("3F", "MISSING_OR_INVALID_AUTHORIZED_REPRESENTATIVE_LAST_NAME");
        REJECTION_CODES.put("3G", "MISSING_OR_INVALID_AUTHORIZED_REPRESENTATIVE_STREET_ADDRESS");
        REJECTION_CODES.put("3H", "MISSING_OR_INVALID_AUTHORIZED_REPRESENTATIVE_CITY_ADDRESS");
        REJECTION_CODES.put("3J", "MISSING_OR_INVALID_AUTHORIZED_REPRESENTATIVE_STATE_PROVINCE_ADDRESS");
        REJECTION_CODES.put("3K", "MISSING_OR_INVALID_AUTHORIZED_REPRESENTATIVE_ZIP_POSTAL_ZONE");
        REJECTION_CODES.put("3M", "MISSING_OR_INVALID_PRESCRIBER_PHONE_NUMBER");
        REJECTION_CODES.put("3N", "MISSING_OR_INVALID_PRIOR_AUTHORIZED_NUMBER_ASSIGNED");
        REJECTION_CODES.put("3P", "MISSING_OR_INVALID_AUTHORIZATION_NUMBER");
        REJECTION_CODES.put("3R", "PRIOR_AUTHORIZATION_NOT_REQUIRED");
        REJECTION_CODES.put("3S", "MISSING_OR_INVALID_PRIOR_AUTHORIZATION_SUPPORTING_DOCUMENTATION");
        REJECTION_CODES.put("3T", "ACTIVE_PRIOR_AUTHORIZATION_EXISTS_RESUBMIT_AT_EXPIRATION_OF_PRIOR_AUTHORIZATION");
        REJECTION_CODES.put("3W", "PRIOR_AUTHORIZATION_IN_PROCESS");
        REJECTION_CODES.put("3X", "AUTHORIZATION_NUMBER_NOT_FOUND");
        REJECTION_CODES.put("3Y", "PRIOR_AUTHORIZATION_DENIED");
        REJECTION_CODES.put("40", "PHARMACY_NOT_CONTRACTED_WITH_PLAN_ON_DATE_OF_SERVICE");
        REJECTION_CODES.put("41", "SUBMIT_BILL_TO_OTHER_PROCESSOR_OR_PRIMARY_PAYER");
        REJECTION_CODES.put("4C", "MISSING_OR_INVALID_COORDINATION_OF_BENEFITS_OTHER_PAYMENTS_COUNT");
        REJECTION_CODES.put("4E", "MISSING_OR_INVALID_PRIMARY_CARE_PROVIDER_LAST_NAME");
        REJECTION_CODES.put("50", "NON_MATCHED_PHARMACY_NUMBER");
        REJECTION_CODES.put("51", "NON_MATCHED_GROUP_ID");
        REJECTION_CODES.put("52", "NON_MATCHED_CARDHOLDER_ID");
        REJECTION_CODES.put("53", "NON_MATCHED_PERSON_CODE");
        REJECTION_CODES.put("54", "NON_MATCHED_PRODUCT_SERVICE_ID_NUMBER");
        REJECTION_CODES.put("55", "NON_MATCHED_PRODUCT_PACKAGE_SIZE");
        REJECTION_CODES.put("56", "NON_MATCHED_PRESCRIBER_ID");
        REJECTION_CODES.put("58", "NON_MATCHED_PRIMARY_PRESCRIBER");
        REJECTION_CODES.put("5C", "MISSING_OR_INVALID_OTHER_PAYER_COVERAGE_TYPE");
        REJECTION_CODES.put("5E", "MISSING_OR_INVALID_OTHER_PAYER_REJECT_COUNT");
        REJECTION_CODES.put("60", "PRODUCT_SERVICE_NOT_COVERED_FOR_PATIENT_AGE");
        REJECTION_CODES.put("61", "PRODUCT_SERVICE_NOT_COVERED_FOR_PATIENT_GENDER");
        REJECTION_CODES.put("62", "PATIENT_CARD_HOLDER_ID_NAME_MISMATCH");
        REJECTION_CODES.put("63", "INSTITUTIONALIZED_PATIENT_PRODUCT_SERVICE_ID_NOT_COVERED");
        REJECTION_CODES.put("64", "CLAIM_SUBMITTED_DOES_NOT_MATCH_PRIOR_AUTHORIZATION");
        REJECTION_CODES.put("65", "PATIENT_IS_NOT_COVERED");
        REJECTION_CODES.put("66", "PATIENT_AGE_EXCEEDS_MAXIMUM_AGE");
        REJECTION_CODES.put("67", "FILLED_BEFORE_COVERAGE_EFFECTIVE");
        REJECTION_CODES.put("68", "FILLED_AFTER_COVERAGE_EXPIRED");
        REJECTION_CODES.put("69", "FILLED_AFTER_COVERAGE_TERMINATED");
        REJECTION_CODES.put("6C", "MISSING_OR_INVALID_OTHER_PAYER_ID_QUALIFIER");
        REJECTION_CODES.put("6E", "MISSING_OR_INVALID_OTHER_PAYER_REJECT_CODE");
        REJECTION_CODES.put("70", "PRODUCT_SERVICE_NOT_COVERED");
        REJECTION_CODES.put("71", "PRESCRIBER_IS_NOT_COVERED");
        REJECTION_CODES.put("72", "PRIMARY_PRESCRIBER_IS_NOT_COVERED");
        REJECTION_CODES.put("73", "REFILLS_ARE_NOT_COVERED");
        REJECTION_CODES.put("74", "OTHER_CARRIER_PAYMENT_MEETS_OR_EXCEEDS_PAYABLE");
        REJECTION_CODES.put("75", "PRIOR_AUTHORIZATION_REQUIRED");
        REJECTION_CODES.put("76", "PLAN_LIMITATIONS_EXCEEDED");
        REJECTION_CODES.put("77", "DISCONTINUED_PRODUCT_SERVICE_ID_NUMBER");
        REJECTION_CODES.put("78", "COST_EXCEEDS_MAXIMUM");
        REJECTION_CODES.put("79", "REFILL_TOO_SOON");
        REJECTION_CODES.put("7C", "MISSING_OR_INVALID_OTHER_PAYER_ID");
        REJECTION_CODES.put("7E", "MISSING_OR_INVALID_DUR_PPS_CODE_COUNTER");
        REJECTION_CODES.put("80", "DRUG_DIAGNOSIS_MISMATCH");
        REJECTION_CODES.put("81", "CLAIM_TOO_OLD");
        REJECTION_CODES.put("82", "CLAIM_IS_POST_DATED");
        REJECTION_CODES.put("83", "DUPLICATE_PAID_CAPTURED_CLAIM");
        REJECTION_CODES.put("84", "CLAIM_HAS_NOT_BEEN_PAID_CAPTURED");
        REJECTION_CODES.put("85", "CLAIM_NOT_PROCESSED");
        REJECTION_CODES.put("86", "SUBMIT_MANUAL_REVERSAL");
        REJECTION_CODES.put("87", "REVERSAL_NOT_PROCESSED");
        REJECTION_CODES.put("88", "DUR_REJECT_ERROR");
        REJECTION_CODES.put("89", "REJECTED_CLAIM_FEES_PAID");
        REJECTION_CODES.put("8C", "MISSING_OR_INVALID_FACILITY_ID");
        REJECTION_CODES.put("8E", "MISSING_OR_INVALID_DUR_PPS_LEVEL_OF_EFFORT");
        REJECTION_CODES.put("90", "HOST_HUNG_UP");
        REJECTION_CODES.put("91", "HOST_RESPONSE_ERROR");
        REJECTION_CODES.put("92", "SYSTEM_UNAVAILABLE_HOST_UNAVAILABLE");
        REJECTION_CODES.put("95", "TIME_OUT");
        REJECTION_CODES.put("96", "SCHEDULED_DOWNTIME");
        REJECTION_CODES.put("97", "PAYER_UNAVAILABLE");
        REJECTION_CODES.put("98", "CONNECTION_TO_PAYER_IS_DOWN");
        REJECTION_CODES.put("99", "HOST_PROCESSING_ERROR");
        REJECTION_CODES.put("A9", "MISSING_OR_INVALID_TRANSACTION_COUNT");
        REJECTION_CODES.put("AA", "PATIENT_SPENDDOWN_NOT_MET");
        REJECTION_CODES.put("AB", "DATE_WRITTEN_IS_AFTER_DATE_FILLED");
        REJECTION_CODES.put("AC", "PRODUCT_NOT_COVERED_NON_PARTICIPATING_MANUFACTURER");
        REJECTION_CODES.put("AD", "BILLING_PROVIDER_NOT_ELIGIBLE_TO_BILL_THIS_CLAIM_TYPE");
        REJECTION_CODES.put("AE", "QMB_QUALIFIED_MEDICARE_BENEFICIARY_BILL_MEDICARE");
        REJECTION_CODES.put("AF", "PATIENT_ENROLLED_UNDER_MANAGED_CARE");
        REJECTION_CODES.put("AG", "DAYS_SUPPLY_LIMITATION_FOR_PRODUCT_SERVICE");
        REJECTION_CODES.put("AH", "UNIT_DOSE_PACKAGING_ONLY_PAYABLE_FOR_NURSING_HOME_RECIPIENTS");
        REJECTION_CODES.put("AJ", "GENERIC_DRUG_REQUIRED");
        REJECTION_CODES.put("AK", "MISSING_OR_INVALID_SOFTWARE_VENDOR_CERTIFICATION_ID");
        REJECTION_CODES.put("AM", "MISSING_OR_INVALID_SEGMENT_IDENTIFICATION");
        REJECTION_CODES.put("B2", "MISSING_OR_INVALID_SERVICE_PROVIDER_ID_QUALIFIER");
        REJECTION_CODES.put("BE", "MISSING_OR_INVALID_PROFESSIONAL_SERVICE_FEE_SUBMITTED");
        REJECTION_CODES.put("CA", "MISSING_OR_INVALID_PATIENT_FIRST_NAME");
        REJECTION_CODES.put("CB", "MISSING_OR_INVALID_PATIENT_LAST_NAME");
        REJECTION_CODES.put("CC", "MISSING_OR_INVALID_CARDHOLDER_FIRST_NAME");
        REJECTION_CODES.put("CD", "MISSING_OR_INVALID_CARDHOLDER_LAST_NAME");
        REJECTION_CODES.put("CE", "MISSING_OR_INVALID_HOME_PLAN");
        REJECTION_CODES.put("CF", "MISSING_OR_INVALID_EMPLOYER_NAME");
        REJECTION_CODES.put("CG", "MISSING_OR_INVALID_EMPLOYER_STREET_ADDRESS");
        REJECTION_CODES.put("CH", "MISSING_OR_INVALID_EMPLOYER_CITY_ADDRESS");
        REJECTION_CODES.put("CI", "MISSING_OR_INVALID_EMPLOYER_STATE_PROVINCE_ADDRESS");
        REJECTION_CODES.put("CJ", "MISSING_OR_INVALID_EMPLOYER_ZIP_POSTAL_ZONE");
        REJECTION_CODES.put("CK", "MISSING_OR_INVALID_EMPLOYER_PHONE_NUMBER");
        REJECTION_CODES.put("CL", "MISSING_OR_INVALID_EMPLOYER_CONTACT_NAME");
        REJECTION_CODES.put("CM", "MISSING_OR_INVALID_PATIENT_STREET_ADDRESS");
        REJECTION_CODES.put("CN", "MISSING_OR_INVALID_PATIENT_CITY_ADDRESS");
        REJECTION_CODES.put("CO", "MISSING_OR_INVALID_PATIENT_STATE_PROVINCE_ADDRESS");
        REJECTION_CODES.put("CP", "MISSING_OR_INVALID_PATIENT_ZIP_POSTAL_ZONE");
        REJECTION_CODES.put("CQ", "MISSING_OR_INVALID_PATIENT_PHONE_NUMBER");
        REJECTION_CODES.put("CR", "MISSING_OR_INVALID_CARRIER_ID");
        REJECTION_CODES.put("CW", "MISSING_OR_INVALID_ALTERNATE_ID");
        REJECTION_CODES.put("CX", "MISSING_OR_INVALID_PATIENT_ID_QUALIFIER");
        REJECTION_CODES.put("CY", "MISSING_OR_INVALID_PATIENT_ID");
        REJECTION_CODES.put("CZ", "MISSING_OR_INVALID_EMPLOYER_ID");
        REJECTION_CODES.put("DC", "MISSING_OR_INVALID_DISPENSING_FEE_SUBMITTED");
        REJECTION_CODES.put("DN", "MISSING_OR_INVALID_BASIS_OF_COST_DETERMINATION");
        REJECTION_CODES.put("DQ", "MISSING_OR_INVALID_USUAL_AND_CUSTOMARY_CHARGE");
        REJECTION_CODES.put("DR", "MISSING_OR_INVALID_PRESCRIBER_LAST_NAME");
        REJECTION_CODES.put("DT", "MISSING_OR_INVALID_UNIT_DOSE_INDICATOR");
        REJECTION_CODES.put("DU", "MISSING_OR_INVALID_GROSS_AMOUNT_DUE");
        REJECTION_CODES.put("DV", "MISSING_OR_INVALID_OTHER_PAYER_AMOUNT_PAID");
        REJECTION_CODES.put("DX", "MISSING_OR_INVALID_PATIENT_PAID_AMOUNT_SUBMITTED");
        REJECTION_CODES.put("DY", "MISSING_OR_INVALID_DATE_OF_INJURY");
        REJECTION_CODES.put("DZ", "MISSING_OR_INVALID_CLAIM_REFERENCE_ID");
        REJECTION_CODES.put("E1", "MISSING_OR_INVALID_PRODUCT_SERVICE_ID_QUALIFIER");
        REJECTION_CODES.put("E3", "MISSING_OR_INVALID_INCENTIVE_AMOUNT_SUBMITTED");
        REJECTION_CODES.put("E4", "MISSING_OR_INVALID_REASON_FOR_SERVICE_CODE");
        REJECTION_CODES.put("E5", "MISSING_OR_INVALID_PROFESSIONAL_SERVICE_CODE");
        REJECTION_CODES.put("E6", "MISSING_OR_INVALID_RESULT_OF_SERVICE_CODE");
        REJECTION_CODES.put("E7", "MISSING_OR_INVALID_QUANTITY_DISPENSED");
        REJECTION_CODES.put("E8", "MISSING_OR_INVALID_OTHER_PAYER_DATE");
        REJECTION_CODES.put("E9", "MISSING_OR_INVALID_PROVIDER_ID");
        REJECTION_CODES.put("EA", "MISSING_OR_INVALID_ORIGINALLY_PRESCRIBED_PRODUCT_SERVICE_CODE");
        REJECTION_CODES.put("EB", "MISSING_OR_INVALID_ORIGINALLY_PRESCRIBED_QUANTITY");
        REJECTION_CODES.put("EC", "MISSING_OR_INVALID_COMPOUND_INGREDIENT_COMPONENT_COUNT");
        REJECTION_CODES.put("ED", "MISSING_OR_INVALID_COMPOUND_INGREDIENT_QUANTITY");
        REJECTION_CODES.put("EE", "MISSING_OR_INVALID_COMPOUND_INGREDIENT_DRUG_COST");
        REJECTION_CODES.put("EF", "MISSING_OR_INVALID_COMPOUND_DOSAGE_FORM_DESCRIPTION_CODE");
        REJECTION_CODES.put("EG", "MISSING_OR_INVALID_COMPOUND_DISPENSING_UNIT_FORM_INDICATOR");
        REJECTION_CODES.put("EH", "MISSING_OR_INVALID_COMPOUND_ROUTE_OF_ADMINISTRATION");
        REJECTION_CODES.put("EJ", "MISSING_OR_INVALID_ORIGINALLY_PRESCRIBED_PRODUCT_SERVICE_ID_QUALIFIER"); 
        REJECTION_CODES.put("EK", "MISSING_OR_INVALID_SCHEDULED_PRESCRIPTION_ID_NUMBER");
        REJECTION_CODES.put("EM", "MISSING_OR_INVALID_PRESCRIPTION_SERVICE_REFERENCE_NUMBER_QUALIFIER");
        REJECTION_CODES.put("EN", "MISSING_OR_INVALID_ASSOCIATED_PRESCRIPTION_SERVICE_REFERENCE_NUMBER");
        REJECTION_CODES.put("EP", "MISSING_OR_INVALID_ASSOCIATED_PRESCRIPTION_SERVICE_DATE");
        REJECTION_CODES.put("ER", "MISSING_OR_INVALID_PROCEDURE_MODIFIER_CODE");
        REJECTION_CODES.put("ET", "MISSING_OR_INVALID_QUANTITY_PRESCRIBED");
        REJECTION_CODES.put("EU", "MISSING_OR_INVALID_PRIOR_AUTHORIZATION_TYPE_CODE");
        REJECTION_CODES.put("EV", "MISSING_OR_INVALID_PRIOR_AUTHORIZATION_NUMBER_SUBMITTED");
        REJECTION_CODES.put("EW", "MISSING_OR_INVALID_INTERMEDIARY_AUTHORIZATION_TYPE_ID");
        REJECTION_CODES.put("EX", "MISSING_OR_INVALID_INTERMEDIARY_AUTHORIZATION_ID");
        REJECTION_CODES.put("EY", "MISSING_OR_INVALID_PROVIDER_ID_QUALIFIER");
        REJECTION_CODES.put("EZ", "MISSING_OR_INVALID_PRESCRIBER_ID_QUALIFIER");
        REJECTION_CODES.put("FO", "MISSING_OR_INVALID_PLAN_ID");
        REJECTION_CODES.put("GE", "MISSING_OR_INVALID_PERCENTAGE_SALES_TAX_AMOUNT_SUBMITTED");
        REJECTION_CODES.put("H1", "MISSING_OR_INVALID_MEASUREMENT_TIME");
        REJECTION_CODES.put("H2", "MISSING_OR_INVALID_MEASUREMENT_DIMENSION");
        REJECTION_CODES.put("H3", "MISSING_OR_INVALID_MEASUREMENT_UNIT");
        REJECTION_CODES.put("H4", "MISSING_OR_INVALID_MEASUREMENT_VALUE");
        REJECTION_CODES.put("H5", "MISSING_OR_INVALID_PRIMARY_CARE_PROVIDER_LOCATION_CODE");
        REJECTION_CODES.put("H6", "MISSING_OR_INVALID_DUR_CO_AGENT_ID");
        REJECTION_CODES.put("H7", "MISSING_OR_INVALID_OTHER_AMOUNT_CLAIMED_SUBMITTED_COUNT");
        REJECTION_CODES.put("H8", "MISSING_OR_INVALID_OTHER_AMOUNT_CLAIMED_SUBMITTED_QUALIFIER");
        REJECTION_CODES.put("H9", "MISSING_OR_INVALID_OTHER_AMOUNT_CLAIMED_SUBMITTED");
        REJECTION_CODES.put("HA", "MISSING_OR_INVALID_FLAT_SALES_TAX_AMOUNT_SUBMITTED");
        REJECTION_CODES.put("HB", "MISSING_OR_INVALID_OTHER_PAYER_AMOUNT_PAID_COUNT");
        REJECTION_CODES.put("HC", "MISSING_OR_INVALID_OTHER_PAYER_AMOUNT_PAID_QUALIFIER");
        REJECTION_CODES.put("HD", "MISSING_OR_INVALID_DISPENSING_STATUS");
        REJECTION_CODES.put("HE", "MISSING_OR_INVALID_PERCENTAGE_SALES_TAX_RATE_SUBMITTED");
        REJECTION_CODES.put("HF", "MISSING_OR_INVALID_QUANTITY_INTENDED_TO_BE_DISPENSED");
        REJECTION_CODES.put("HG", "MISSING_OR_INVALID_DAYS_SUPPLY_INTENDED_TO_BE_DISPENSED");
        REJECTION_CODES.put("J9", "MISSING_OR_INVALID_DUR_CO_AGENT_ID_QUALIFIER");
        REJECTION_CODES.put("JE", "MISSING_OR_INVALID_PERCENTAGE_SALES_TAX_BASIS_SUBMITTED");
        REJECTION_CODES.put("KE", "MISSING_OR_INVALID_COUPON_TYPE");
        REJECTION_CODES.put("M1", "PATIENT_NOT_COVERED_IN_THIS_AID_CATEGORY");
        REJECTION_CODES.put("M2", "RECIPIENT_LOCKED_IN");
        REJECTION_CODES.put("M3", "HOST_PA_MC_ERROR");
        REJECTION_CODES.put("M4", "PRESCRIPTION_SERVICE_REFERENCE_NUMBER_TIME_LIMIT_EXCEEDED");
        REJECTION_CODES.put("M5", "REQUIRES_MANUAL_CLAIM");
        REJECTION_CODES.put("M6", "HOST_ELIGIBILITY_ERROR");
        REJECTION_CODES.put("M7", "HOST_DRUG_FILE_ERROR");
        REJECTION_CODES.put("M8", "HOST_PROVIDER_FILE_ERROR");
        REJECTION_CODES.put("ME", "MISSING_OR_INVALID_COUPON_NUMBER");
        REJECTION_CODES.put("MZ", "ERROR_OVERFLOW");
        REJECTION_CODES.put("NE", "MISSING_OR_INVALID_COUPON_VALUE_AMOUNT");
        REJECTION_CODES.put("NN", "TRANSACTION_REJECTED_AT_SWITCH_OR_INTERMEDIARY");
        REJECTION_CODES.put("P1", "ASSOCIATED_PRESCRIPTION_SERVICE_REFERENCE_NUMBER_NOT_FOUND");
        REJECTION_CODES.put("P2", "CLINICAL_INFORMATION_COUNTER_OUT_OF_SEQUENCE");
        REJECTION_CODES.put("P3", "COMPOUND_INGREDIENT_COMPONENT_COUNT_DOES_NOT_MATCH_NUMBER_OF_REPETITIONS");
        REJECTION_CODES.put("P4", "COORDINATION_OF_BENEFITS_OTHER_PAYMENTS_COUNT_DOES_NOT_MATCH_NUMBER_OF_REPETITIONS");
        REJECTION_CODES.put("P5", "COUPON_EXPIRED");
        REJECTION_CODES.put("P6", "DATE_OF_SERVICE_PRIOR_TO_DATE_OF_BIRTH");
        REJECTION_CODES.put("P7", "DIAGNOSIS_CODE_COUNT_DOES_NOT_MATCH_NUMBER_OF_REPETITIONS");
        REJECTION_CODES.put("P8", "DUR_PPS_CODE_COUNTER_OUT_OF_SEQUENCE");
        REJECTION_CODES.put("P9", "FIELD_IS_NON_REPEATABLE");
        REJECTION_CODES.put("PA", "PA_EXHAUSTED_NOT_RENEWABLE");
        REJECTION_CODES.put("PB", "INVALID_TRANSACTION_COUNT_FOR_THIS_TRANSACTION_CODE");
        REJECTION_CODES.put("PC", "MISSING_OR_INVALID_CLAIM_SEGMENT");
        REJECTION_CODES.put("PD", "MISSING_OR_INVALID_CLINICAL_SEGMENT");
        REJECTION_CODES.put("PE", "MISSING_OR_INVALID_COB_OTHER_PAYMENTS_SEGMENT");
        REJECTION_CODES.put("PF", "MISSING_OR_INVALID_COMPOUND_SEGMENT");
        REJECTION_CODES.put("PG", "MISSING_OR_INVALID_COUPON_SEGMENT");
        REJECTION_CODES.put("PH", "MISSING_OR_INVALID_DUR_PPS_SEGMENT");
        REJECTION_CODES.put("PJ", "MISSING_OR_INVALID_INSURANCE_SEGMENT");
        REJECTION_CODES.put("PK", "MISSING_OR_INVALID_PATIENT_SEGMENT");
        REJECTION_CODES.put("PM", "MISSING_OR_INVALID_PHARMACY_PROVIDER_SEGMENT");
        REJECTION_CODES.put("PN", "MISSING_OR_INVALID_PRESCRIBER_SEGMENT");
        REJECTION_CODES.put("PP", "MISSING_OR_INVALID_PRICING_SEGMENT");
        REJECTION_CODES.put("PR", "MISSING_OR_INVALID_PRIOR_AUTHORIZATION_SEGMENT");
        REJECTION_CODES.put("PS", "MISSING_OR_INVALID_TRANSACTION_HEADER_SEGMENT");
        REJECTION_CODES.put("PT", "MISSING_OR_INVALID_WORKERS_COMPENSATION_SEGMENT");
        REJECTION_CODES.put("PV", "NON_MATCHED_ASSOCIATED_PRESCRIPTION_SERVICE_DATE");
        REJECTION_CODES.put("PW", "NON_MATCHED_EMPLOYER_ID");
        REJECTION_CODES.put("PX", "NON_MATCHED_OTHER_PAYER_ID");
        REJECTION_CODES.put("PY", "NON_MATCHED_UNIT_FORM_ROUTE_OF_ADMINISTRATION");
        REJECTION_CODES.put("PZ", "NON_MATCHED_UNIT_OF_MEASURE_TO_PRODUCT_SERVICE_ID");
        REJECTION_CODES.put("R1", "OTHER_AMOUNT_CLAIMED_SUBMITTED_COUNT_DOES_NOT_MATCH_NUMBER_OF_REPETITIONS");
        REJECTION_CODES.put("R2", "OTHER_PAYER_REJECT_COUNT_DOES_NOT_MATCH_NUMBER_OF_REPETITIONS");
        REJECTION_CODES.put("R3", "PROCEDURE_MODIFIER_CODE_COUNT_DOES_NOT_MATCH_NUMBER_OF_REPETITIONS");
        REJECTION_CODES.put("R4", "PROCEDURE_MODIFIER_CODE_INVALID_FOR_PRODUCT_SERVICE_ID");
        REJECTION_CODES.put("R5", "PRODUCT_SERVICE_ID_MUST_BE_ZERO_WHEN_PRODUCT_SERVICE_ID_QUALIFIER_EQUALS_Ø6");
        REJECTION_CODES.put("R6", "PRODUCT_SERVICE_NOT_APPROPRIATE_FOR_THIS_LOCATION");
        REJECTION_CODES.put("R7", "REPEATING_SEGMENT_NOT_ALLOWED_IN_SAME_TRANSACTION");
        REJECTION_CODES.put("R8", "SYNTAX_ERROR");
        REJECTION_CODES.put("R9", "VALUE_IN_GROSS_AMOUNT_DUE_DOES_NOT_FOLLOW_PRICING_FORMULAE");
        REJECTION_CODES.put("RA", "PA_REVERSAL_OUT_OF_ORDER");
        REJECTION_CODES.put("RB", "MULTIPLE_PARTIALS_NOT_ALLOWED");
        REJECTION_CODES.put("RC", "DIFFERENT_DRUG_ENTITY_BETWEEN_PARTIAL_COMPLETION");
        REJECTION_CODES.put("RD", "MISMATCHED_CARDHOLDER_GROUP_ID_PARTIAL_TO_COMPLETION");
        REJECTION_CODES.put("RE", "MISSING_OR_INVALID_COMPOUND_PRODUCT_ID_QUALIFIER");
        REJECTION_CODES.put("RF", "IMPROPER_ORDER_OF_DISPENSING_STATUS_CODE_ON_PARTIAL_FILL_TRANSACTION");
        REJECTION_CODES.put("RG", "MISSING_OR_INVALID_ASSOCIATED_PRESCRIPTION_SERVICE_REFERENCE_NUMBER_ON_COMPLETION_TRANSACTION");
        REJECTION_CODES.put("RH", "MISSING_OR_INVALID_ASSOCIATED_PRESCRIPTION_SERVICE_DATE_ON_COMPLETION_TRANSACTION");
        REJECTION_CODES.put("RJ", "ASSOCIATED_PARTIAL_FILL_TRANSACTION_NOT_ON_FILE");
        REJECTION_CODES.put("RK", "PARTIAL_FILL_TRANSACTION_NOT_SUPPORTED");
        REJECTION_CODES.put("RM", "COMPLETION_TRANSACTION_NOT_PERMITTED_WITH_SAME_DATE_OF_SERVICE_AS_PARTIAL_TRANSACTION");
        REJECTION_CODES.put("RN", "PLAN_LIMITS_EXCEEDED_ON_INTENDED_PARTIAL_FILL_VALUES");
        REJECTION_CODES.put("RP", "OUT_OF_SEQUENCE_P_REVERSAL_ON_PARTIAL_FILL_TRANSACTION");
        REJECTION_CODES.put("RS", "MISSING_OR_INVALID_ASSOCIATED_PRESCRIPTION_SERVICE_DATE_ON_PARTIAL_TRANSACTION");
        REJECTION_CODES.put("RT", "MISSING_OR_INVALID_ASSOCIATED_PRESCRIPTION_SERVICE_REFERENCE_NUMBER_ON_PARTIAL_TRANSACTION");
        REJECTION_CODES.put("RU", "MANDATORY_DATA_ELEMENTS_MUST_OCCUR_BEFORE_OPTIONAL_DATA_ELEMENTS_IN_A_SEGMENT");
        REJECTION_CODES.put("SE", "MISSING_OR_INVALID_PROCEDURE_MODIFIER_CODE_COUNT");
        REJECTION_CODES.put("TE", "MISSING_OR_INVALID_COMPOUND_PRODUCT_ID");
        REJECTION_CODES.put("UE", "MISSING_OR_INVALID_COMPOUND_INGREDIENT_BASIS_OF_COST_DETERMINATION");
        REJECTION_CODES.put("VE", "MISSING_OR_INVALID_DIAGNOSIS_CODE_COUNT");
        REJECTION_CODES.put("WE", "MISSING_OR_INVALID_DIAGNOSIS_CODE_QUALIFIER");
        REJECTION_CODES.put("XE", "MISSING_OR_INVALID_CLINICAL_INFORMATION_COUNTER");
        REJECTION_CODES.put("ZE", "MISSING_OR_INVALID_MEASUREMENT_DATE");
    }

    public static String getCodeBySymbol(String symbol) {
        for (Map.Entry<String, String> entry : REJECTION_CODES.entrySet()) {
            if (entry.getValue().equals(symbol)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static String getSymbolByCode(String code) {
        return REJECTION_CODES.get(code);
    }
}
