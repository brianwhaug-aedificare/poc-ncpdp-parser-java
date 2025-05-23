package poc.ncpdp.parser.transmissions.concerns;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import poc.ncpdp.data.transmissions.RequestDTO;
import poc.ncpdp.data.transmissions.RequestHeaderDTO;
import poc.ncpdp.data.transmissions.ResponseDTO;
import poc.ncpdp.data.transmissions.ResponseHeaderDTO;
import poc.ncpdp.parser.segments.*;
import poc.ncpdp.parser.transmissions.Request;
import poc.ncpdp.parser.transmissions.RequestHeader;
import poc.ncpdp.parser.transmissions.Response;
import poc.ncpdp.parser.transmissions.ResponseHeader;
import poc.ncpdp.parser.transmissions.groups.TransactionGroup;
import poc.ncpdp.parser.transmissions.groups.TransmissionGroup;

public class ParserTest {
    
    @Test
    public void testParseB1_01_BillingRequest() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_01.txt");

        // Parse the request
        Request request = Parser.parseRequest(requestContent);

        // Verify the parsed request
        assertNotNull("Request should not be null", request);
        
        RequestHeader header = (RequestHeader) request.getHeader();
        assertNotNull("Header should not be null", header);

        // Verify header values
        assertEquals("610066", header.getBinNumber());
        assertEquals("D0", header.getVersion());
        assertEquals("B1", header.getTransactionCode());
        assertEquals("1234567890", header.getProcessorControlNumber());
        assertEquals("1", header.getTransactionCount());
        assertEquals("01", header.getServiceProviderIdQualifier());
        assertEquals("4563663bbbbbbbb", header.getServiceProviderId());
        assertEquals("20070915", header.getDateOfService());
        assertEquals("98765bbbbb", header.getSoftware());
        
        // Verify transmission structure
        assertNotNull("Transmission group should not be null", request.getTransmissionGroup());
        assertNotNull("Transaction groups should not be null", request.getTransactionGroups());
        assertFalse("Should have transaction groups", request.getTransactionGroups().isEmpty());
        
        // Interrogate the transmission group and segments
        TransmissionGroup transmissionGroup = request.getTransmissionGroup();
        List<SegmentBase> segments = transmissionGroup.getSegments();
        
        for (SegmentBase segment : segments) {
            System.out.println("TEST Examining segment: " + segment.getClass().getSimpleName());
            System.out.println("TEST Segment hash: " + segment.getHash());
            
            if (segment instanceof Patient) {
                Patient patientSegment = (Patient) segment;                
                // Verify some expected Patient fields
                assertEquals("Patient date of birth should match", "19620615", patientSegment.get("C4"));
                assertEquals("Patient first name should match", "JOSEPH", patientSegment.get("CA"));
                assertEquals("Patient last name should match", "SMITH", patientSegment.get("CB"));

            } else if (segment instanceof Insurance) {
                Insurance insuranceSegment = (Insurance) segment;
                // Verify some expected Insurance fields
                assertEquals("Insurance C2 should match", "987654321", insuranceSegment.get("C2"));
            }
        }
        
        // Interrogate the transaction groups and segments
        TransactionGroup transactionGroup = request.getTransactionGroups().get(0);
        assertNotNull("Transaction group should not be null", transactionGroup);
        
        List<SegmentBase> transactionSegments = transactionGroup.getSegments();
        assertFalse("Transaction group should have segments", transactionSegments.isEmpty());
        for (SegmentBase segment : transactionSegments) {
            System.out.println("TEST Examining segment: " + segment.getClass().getSimpleName());
            System.out.println("TEST Segment hash: " + segment.getHash());

            if (segment instanceof Claim) {
                Claim claimSegment = (Claim) segment;                
                // Verify some expected Patient fields
                assertEquals("Claim D7 should match", "00006094268", claimSegment.get("D7"));
                assertEquals("Claim DE should match", "20070915", claimSegment.get("DE"));
                assertEquals("Claim D2 should match", "1234567", claimSegment.get("D2"));
            } else if (segment instanceof Prescriber) {
                Prescriber prescriberSegment = (Prescriber) segment;
                // Verify some expected Insurance fields
                assertEquals("Insurance C2 should match", "WRIGHT", prescriberSegment.get("4E"));
            }
        }
    }

    @Test
    public void testParseB1_02_BillingRequest() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_02.txt");

        // Parse the request
        Request request = Parser.parseRequest(requestContent);

        // Verify the parsed request
        assertNotNull("Request should not be null", request);
        
        // Verify header values
        RequestHeader header = (RequestHeader) request.getHeader();
        assertNotNull("Header should not be null", header);
        assertEquals("484848", header.getBinNumber());
        assertEquals("D0", header.getVersion());
        assertEquals("B1", header.getTransactionCode());
        assertEquals("5678901234", header.getProcessorControlNumber());
        assertEquals("1", header.getTransactionCount());
        assertEquals("01", header.getServiceProviderIdQualifier());
        assertEquals("4563663bbbbbbbb", header.getServiceProviderId());
        assertEquals("20070915", header.getDateOfService());
        assertEquals("98765bbbbb", header.getSoftware());

        // Interrogate the transmission group and segments
        TransmissionGroup transmissionGroup = request.getTransmissionGroup();
        List<SegmentBase> segments = transmissionGroup.getSegments();
        
        for (SegmentBase segment : segments) {
            System.out.println("TEST Examining TransmissionGroup segment: " + segment.getClass().getSimpleName());
            System.out.println("TEST Segment hash: " + segment.getHash());

        }
        
        System.out.println("TEST Examining TransactionGroup size: " + request.getTransactionGroups().size());
        
        // Interrogate the transaction groups and segments
        TransactionGroup transactionGroup = request.getTransactionGroups().get(0);
        assertNotNull("Transaction group should not be null", transactionGroup);
        
        List<SegmentBase> transactionSegments = transactionGroup.getSegments();
        assertFalse("Transaction group should have segments", transactionSegments.isEmpty());
        for (SegmentBase segment : transactionSegments) {
            System.out.println("TEST Examining TransactionGroup segment: " + segment.getClass().getSimpleName());
            System.out.println("TEST Segment hash: " + segment.getHash());

            if (segment instanceof Pricing) {
                Pricing claimSegment = (Pricing) segment;   
                assertEquals("Pricing ingredient cost submitted should match", "557{", claimSegment.get("D9"));
            }
        }
    }

    @Test
    public void testParseB1_Response_01() throws IOException {
        // Read and process the test file
        String responseContent = ParserTestHelper.readTestFile("response_b1_01.txt");

        // Parse the request
        Response response = Parser.parseResponse(responseContent);

        // Verify the parsed request
        assertNotNull("Response should not be null", response);
        
        ResponseHeader header = (ResponseHeader) response.getHeader();
        assertNotNull("Header should not be null", header);
        assertEquals("D0", header.getVersion());
        assertEquals("B1", header.getTransactionCode());
        assertEquals("1", header.getTransactionCount());
        assertEquals("20070915", header.getDateOfService());
        
        // Interrogate the transmission group and segments
        TransmissionGroup transmissionGroup = response.getTransmissionGroup();
        List<SegmentBase> segments = transmissionGroup.getSegments();
        
        for (SegmentBase segment : segments) {
            System.out.println("TEST Examining TransmissionGroup segment: " + segment.getClass().getSimpleName());
            System.out.println("TEST Segment hash: " + segment.getHash());

        }
        
        System.out.println("TEST Examining TransactionGroup size: " + response.getTransactionGroups().size());
        
        // Interrogate the transaction groups and segments
        TransactionGroup transactionGroup = response.getTransactionGroups().get(0);
        assertNotNull("Transaction group should not be null", transactionGroup);
        
        List<SegmentBase> transactionSegments = transactionGroup.getSegments();
        assertFalse("Transaction group should have segments", transactionSegments.isEmpty());
        for (SegmentBase segment : transactionSegments) {
            System.out.println("TEST Examining TransactionGroup segment: " + segment.getClass().getSimpleName());
            System.out.println("TEST Segment hash: " + segment.getHash());

        }
    }

    @Test
    public void testParseB1_01_BillingRequest_UsingDTO() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_01.txt");

        // Parse the request
        RequestDTO requestDTO = Parser.parseRequestIntoDTO(requestContent);

        // Verify the parsed request
        assertNotNull("Request should not be null", requestDTO);
        
        // Verify header values
        RequestHeaderDTO header = requestDTO.getRequestHeader();
        assertNotNull("Header should not be null", header);
        assertEquals("610066", header.getBinNumber());
        assertEquals("D0", header.getVersion());
        assertEquals("B1", header.getTransactionCode());
        assertEquals("1234567890", header.getProcessorControlNumber());
        assertEquals("1", header.getTransactionCount());
        assertEquals("01", header.getServiceProviderIdQualifier());
        assertEquals("4563663bbbbbbbb", header.getServiceProviderId());
        assertEquals("20070915", header.getDateOfService());
        assertEquals("98765bbbbb", header.getSoftware());

        // Verify transmission structure
        assertNotNull("Transmission group should not be null", requestDTO.getTransmissionGroup());
        assertNotNull("Transaction groups should not be null", requestDTO.getTransactionGroups());
        assertFalse("Should have transaction groups", requestDTO.getTransactionGroups().isEmpty());
        
        // Interrogate the transmission group and segments
        
    }

    @Test
    public void testParseB1_02_BillingRequest_UsingDTO() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_02.txt");

        // Parse the request
        RequestDTO requestDTO = Parser.parseRequestIntoDTO(requestContent);

        // Verify the parsed request
        assertNotNull("Request should not be null", requestDTO);

        RequestHeaderDTO requestHeader = requestDTO.getRequestHeader();
        // Verify header values
        assertNotNull("Header should not be null", requestHeader);
        assertEquals("484848", requestHeader.getBinNumber());
        assertEquals("D0", requestHeader.getVersion());
        assertEquals("B1", requestHeader.getTransactionCode());
        assertEquals("5678901234", requestHeader.getProcessorControlNumber());
        assertEquals("1", requestHeader.getTransactionCount());
        assertEquals("01", requestHeader.getServiceProviderIdQualifier());
        assertEquals("4563663bbbbbbbb", requestHeader.getServiceProviderId());
        assertEquals("20070915", requestHeader.getDateOfService());
        assertEquals("98765bbbbb", requestHeader.getSoftware());

    }

    @Test
    public void testParseB1_Response_01_UsingDTO() throws IOException {
        // Read and process the test file
        String responseContent = ParserTestHelper.readTestFile("response_b1_01.txt");

        // Parse the request
        ResponseDTO response = Parser.parseResponseIntoDTO(responseContent);

        // Verify the parsed request
        assertNotNull("Response should not be null", response);
        
        // Verify header values
        ResponseHeaderDTO header = response.getResponseHeader();
        assertEquals("D0", header.getVersion());
        assertEquals("B1", header.getTransactionCode());
        assertEquals("1", header.getTransactionCount());
        assertEquals("20070915", header.getDateOfService());
        
    }

    @Test
    public void testBuild_B1_01_BillingRequest_UsingDTO() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_01.txt");

        // Parse the request
        RequestDTO requestDTO = Parser.parseRequestIntoDTO(requestContent);

        String rawRequest = Builder.buildRequest(requestDTO);

        // check length of requestContent should match rawRequest
        assertEquals("Request content length should match raw request", requestContent.length(), rawRequest.length());
        assertEquals("Request content should match raw request", requestContent, rawRequest);
        
    }
    
    @Test
    public void testBuild_B1_02_BillingRequest_UsingDTO() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_02.txt");

        // Parse the request
        RequestDTO requestDTO = Parser.parseRequestIntoDTO(requestContent);

        String rawRequest = Builder.buildRequest(requestDTO);

        // check length of requestContent should match rawRequest
        assertEquals("Request content length should match raw request", requestContent.length(), rawRequest.length());
        assertEquals("Request content should match raw request", requestContent, rawRequest);
        
    }
}
