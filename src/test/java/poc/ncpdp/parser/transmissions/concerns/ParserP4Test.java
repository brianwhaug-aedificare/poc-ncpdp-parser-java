package poc.ncpdp.parser.transmissions.concerns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import poc.ncpdp.parser.transmissions.Request;
import poc.ncpdp.parser.transmissions.RequestHeader;
import poc.ncpdp.parser.transmissions.Response;
import poc.ncpdp.parser.transmissions.ResponseHeader;

public class ParserP4Test {

    @Test
    public void testParseP4_Request_01() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_p4_01.txt");

        // Parse the request
        Request request = Parser.parseRequest(requestContent);

        // Verify the parsed request
        assertNotNull("Request should not be null", request);

        RequestHeader header = (RequestHeader) request.getHeader();
        assertNotNull("Header should not be null", header);

        assertEquals("610066", header.getBinNumber());
        assertEquals("D0", header.getVersion());
        assertEquals("P4", header.getTransactionCode());
        assertEquals("1234567890", header.getProcessorControlNumber());
        assertEquals("1", header.getTransactionCount());
        assertEquals("01", header.getServiceProviderIdQualifier());
        assertEquals("4563663bbbbbbbb", header.getServiceProviderId());
        assertEquals("20070915", header.getDateOfService());
        assertEquals("bbbbbbbbbb", header.getSoftware());

    }

    @Test
    public void testParseP4_Response_01() throws IOException {
        // Read and process the test file
        String responseContent = ParserTestHelper.readTestFile("response_p4_01.txt");

        // Parse the response
        Response response = Parser.parseResponse(responseContent);

        // Verify the parsed response
        assertNotNull("Response should not be null", response);

        ResponseHeader header = (ResponseHeader) response.getHeader();
        assertNotNull("Header should not be null", header);

        assertEquals("D0", header.getVersion());
        assertEquals("P4", header.getTransactionCode());
                
    }
}
