package poc.ncpdp.parser.transmissions.concerns;

import java.util.ArrayList;
import java.util.List;

import poc.ncpdp.data.segments.SegmentDTO;
import poc.ncpdp.data.transmissions.RequestDTO;
import poc.ncpdp.data.transmissions.RequestHeaderDTO;
import poc.ncpdp.data.transmissions.ResponseDTO;
import poc.ncpdp.data.transmissions.ResponseHeaderDTO;
import poc.ncpdp.data.transmissions.TransactionGroupDTO;
import poc.ncpdp.data.transmissions.TransmissionGroupDTO;
import poc.ncpdp.parser.Constants;
import poc.ncpdp.parser.segments.SegmentBase;
import poc.ncpdp.parser.transmissions.Request;
import poc.ncpdp.parser.transmissions.RequestHeader;
import poc.ncpdp.parser.transmissions.RequestHeaderSchema;
import poc.ncpdp.parser.transmissions.Response;
import poc.ncpdp.parser.transmissions.ResponseHeader;
import poc.ncpdp.parser.transmissions.ResponseHeaderSchema;
import poc.ncpdp.parser.transmissions.groups.TransmissionGroup;
import poc.ncpdp.parser.transmissions.groups.TransactionGroup;
import poc.ncpdp.parser.transmissions.groups.GroupBase;

public interface Parser {
    /**
     * Parses a request transmission string as an ASCII (7 bit) request
     */
    static Request parseRequest(String rawString) {
        RequestHeader header = new RequestHeader(rawString);
        ParseResult result = parseTransmission(rawString, RequestHeaderSchema.getHeaderLength());
        return new Request(header, result.transmissionGroup(),
                result.transactionGroups(), new ArrayList<>());
    }

    /**
     * Parses a response transmission string as an ASCII (7 bit) response
     */
    static Response parseResponse(String rawString) {
        ResponseHeader header = new ResponseHeader(rawString);
        ParseResult result = parseTransmission(rawString, ResponseHeaderSchema.getHeaderLength());
        return new Response(header, result.transmissionGroup(),
                result.transactionGroups(), new ArrayList<>());
    }

    /**
     * Parses a request transmission string into a RequestHeader.
     * For highest performance, this method should be used
     * when only the header is needed without parsing the entire transmission.
     */
    static RequestHeader parseRequestHeader(String rawString) {
        return new RequestHeader(rawString);
    }
    
    /**
     * Parses a response transmission string into a ResponseHeader.
     * For highest performance, this method should be used
     * when only the header is needed without parsing the entire transmission.
     */
    static ResponseHeader parseResponseHeader(String rawString) {
        return new ResponseHeader(rawString);
    }

    static RequestDTO parseRequestIntoDTO(String rawString) {
        RequestHeader header = new RequestHeader(rawString);
        ParseResult result = parseTransmission(rawString, RequestHeaderSchema.getHeaderLength());

        RequestHeaderDTO headerDTO = new RequestHeaderDTO(header.getBinNumber(), header.getVersion(),
                header.getTransactionCode(),
                header.getProcessorControlNumber(), header.getTransactionCount(),
                header.getServiceProviderIdQualifier(), header.getServiceProviderId(),
                header.getDateOfService(), header.getSoftware());
        TransmissionGroupDTO transmissionGroupDTO = new TransmissionGroupDTO(
                result.transmissionGroup().getSegmentDTOs());

        List<TransactionGroupDTO> transactionGroupDTOs = new ArrayList<>();
        result.transactionGroups().forEach(transactionGroup -> {
            TransactionGroupDTO transactionGroupDTO = new TransactionGroupDTO(transactionGroup.getSegmentDTOs());
            transactionGroupDTOs.add(transactionGroupDTO);
        });
        return new RequestDTO(headerDTO, transmissionGroupDTO, transactionGroupDTOs);
    }

    static ResponseDTO parseResponseIntoDTO(String rawString) {
        ResponseHeader header = new ResponseHeader(rawString);
        ParseResult result = parseTransmission(rawString, ResponseHeaderSchema.getHeaderLength());
        ResponseHeaderDTO headerDTO = new ResponseHeaderDTO(header.getVersion(), header.getTransactionCode(),
                header.getTransactionCount(), header.getHeaderResponseStatus(), header.getServiceProviderIdQualifier(),
                header.getServiceProviderId(), header.getDateOfService());

        TransmissionGroupDTO transmissionGroupDTO = new TransmissionGroupDTO(
                result.transmissionGroup().getSegmentDTOs());

        List<TransactionGroupDTO> transactionGroupDTOs = new ArrayList<>();
        result.transactionGroups().forEach(transactionGroup -> {
            TransactionGroupDTO transactionGroupDTO = new TransactionGroupDTO(transactionGroup.getSegmentDTOs());
            transactionGroupDTOs.add(transactionGroupDTO);
        });
        return new ResponseDTO(headerDTO, transmissionGroupDTO, transactionGroupDTOs);
    }

    /**
     * Helper record to hold parsed transmission components
     */
    record ParseResult(
            TransmissionGroup transmissionGroup,
            List<TransactionGroup> transactionGroups) {
    }

    /**
     * Common parsing logic for both request and response transmissions
     */
    private static ParseResult parseTransmission(String rawString, int headerLength) {
        String bodyString = rawString.substring(headerLength);

        // Split the body into transmission and transaction groups
        String[] rawGroups = bodyString.split(Constants.GROUP_SEPARATOR);
        String rawTransmissionGroup = rawGroups.length > 0 ? rawGroups[0] : "";
        List<String> rawTransactionGroups = new ArrayList<>();
        for (int i = 1; i < rawGroups.length; i++) {
            rawTransactionGroups.add(rawGroups[i]);
        }

        // Parse the transmission group
        GroupBase transmissionGroupBase = GroupBase.parse(rawTransmissionGroup, Constants.SEGMENT_SEPARATOR);
        List<SegmentBase> transmissionSegments = transmissionGroupBase.getSegments();
        List<SegmentDTO> transmissionDTOs = transmissionGroupBase.getSegmentDTOs();
        TransmissionGroup transmissionGroup = new TransmissionGroup(transmissionSegments, transmissionDTOs);

        // Parse all transaction groups
        List<TransactionGroup> transactionGroups = new ArrayList<>();
        for (String rawTransactionGroup : rawTransactionGroups) {
            GroupBase transactionGroupBase = GroupBase.parse(rawTransactionGroup, Constants.SEGMENT_SEPARATOR);
            List<SegmentBase> transactionSegments = transactionGroupBase.getSegments();
            List<SegmentDTO> transactionDTOs = transactionGroupBase.getSegmentDTOs();
            transactionGroups.add(new TransactionGroup(transactionSegments, transactionDTOs));
        }

        return new ParseResult(transmissionGroup, transactionGroups);
    }
}
