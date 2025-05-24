package poc.ncpdp.parser.transmissions.concerns;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import poc.ncpdp.parser.transmissions.Response;
import poc.ncpdp.parser.transmissions.ResponseHeader;

public class ParserP2Test {

    @Test
    public void testParseP2_01() throws IOException {
        // Read and process the test file
        String responseContent = ParserTestHelper.readTestFile("response_p2_01.txt");

        // Parse the Response
        Response response = Parser.parseResponse(responseContent);

        // Verify the parsed request
        assertNotNull("Request should not be null", response);

        ResponseHeader header = (ResponseHeader) response.getHeader();
        assertNotNull("Header should not be null", header);


    }
}
