package poc.ncpdp.parser.transmissions.concerns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import poc.ncpdp.parser.transmissions.Request;
import poc.ncpdp.parser.transmissions.RequestHeader;

public class ParserN1Test {

    @Test
    public void testParseN1_01() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_n1_01.txt");

        // Parse the request
        Request request = Parser.parseRequest(requestContent);

        // Verify the parsed request
        assertNotNull("Request should not be null", request);

        RequestHeader header = (RequestHeader) request.getHeader();
        assertNotNull("Header should not be null", header);

        assertEquals("610066", header.getBinNumber());
        assertEquals("D0", header.getVersion());
        assertEquals("N1", header.getTransactionCode());
        assertEquals("1234567890", header.getProcessorControlNumber());
        assertEquals("1", header.getTransactionCount());
        assertEquals("07", header.getServiceProviderIdQualifier());
        assertEquals("4563663bbbbbbbb", header.getServiceProviderId());
        assertEquals("20070915", header.getDateOfService());
        assertEquals("98765bbbbb", header.getSoftware());

    }
}
