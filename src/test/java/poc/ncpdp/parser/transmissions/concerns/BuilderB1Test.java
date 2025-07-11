package poc.ncpdp.parser.transmissions.concerns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import org.junit.Test;

import poc.ncpdp.data.transmissions.RequestDTO;
import poc.ncpdp.data.transmissions.ResponseDTO;
import poc.ncpdp.parser.transmissions.Request;
import poc.ncpdp.parser.transmissions.RequestHeader;

public class BuilderB1Test {
    @Test
    public void testBuild_B1_01_BillingRequest_UsingDTO() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_01.txt");

        // Parse the request
        RequestDTO requestDTO = Parser.parseRequestIntoDTO(requestContent);

        String rawRequest = Builder.buildRequest(requestDTO);

        System.out.println("requestContent: " + requestContent); 
        System.out.println("rawRequest: " + rawRequest);

        // check length of requestContent should match rawRequest
        assertEquals("Request content length should match raw request", requestContent.length(), rawRequest.length());
        assertEquals("Request content should match raw request", requestContent, rawRequest);

    }

    /**
     * This test builds a request using a full RequestDTO object and verifies that
     * the raw request is not null and can be parsed back into a Request object.
     */
    @Test
    public void testBuild_B1_UsingFullRequestDTO_01() throws Exception {
        
        RequestDTO requestDTO = MessageDTOProducer.produceFullRequestDTO();

        String rawRequest = Builder.buildRequest(requestDTO);

        // check length of requestContent should match rawRequest
        assertNotNull("rawRequest should not be null", rawRequest);
        
        // Parse the request
        Request request = Parser.parseRequest(rawRequest);

        // Verify the parsed request
        assertNotNull("Request should not be null", request);
        
        RequestHeader header = (RequestHeader) request.getHeader();
        assertNotNull("Header should not be null", header);

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

    @Test
    public void testBuild_Response_B1_01_UsingDTO() throws IOException {
        // Read and process the test file
        String responseContent = ParserTestHelper.readTestFile("response_b1_01.txt");

        // Parse the response
        ResponseDTO response = Parser.parseResponseIntoDTO(responseContent);
        String rawResponse = Builder.buildResponse(response);

        // check length of responseContent should match rawResponse
        assertEquals("Response content length should match raw response", responseContent.length(), rawResponse.length());
        // TODO Not checking the raw content because the response example has a 
        // flaw in it, where its not placing the fields in the correct order
        // assertEquals("Response content should match raw response", responseContent, rawResponse);
    }


}
