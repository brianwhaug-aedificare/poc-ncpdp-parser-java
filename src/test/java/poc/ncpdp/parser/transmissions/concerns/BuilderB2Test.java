package poc.ncpdp.parser.transmissions.concerns;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import poc.ncpdp.data.transmissions.RequestDTO;

public class BuilderB2Test {

    @Test
    public void testBuild_Request_B2_01_UsingDTO() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b2_01.txt");

        // Parse the request
        RequestDTO requestDTO = Parser.parseRequestIntoDTO(requestContent);

        String rawRequest = Builder.buildRequest(requestDTO);

        // check length of requestContent should match rawRequest
        assertEquals("Request content length should match raw request", requestContent.length(), rawRequest.length());
        assertEquals("Request content should match raw request", requestContent, rawRequest);

    }
}
