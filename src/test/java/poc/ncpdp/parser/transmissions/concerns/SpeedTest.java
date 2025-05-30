package poc.ncpdp.parser.transmissions.concerns;

import java.io.IOException;

import org.junit.Test;

import poc.ncpdp.data.transmissions.RequestDTO;
import poc.ncpdp.parser.transmissions.Request;
import poc.ncpdp.parser.transmissions.RequestHeader;

public class SpeedTest {

    @Test
    public void testSpeedOf_RequestParser() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_01.txt");

        long startTime = System.nanoTime();

        // Parse the request
        Request request = Parser.parseRequest(requestContent);
        
        long endTime = System.nanoTime();
        long durationNanos = endTime - startTime;
        double durationMillis = durationNanos / 1_000_000.0;
        System.out.println("parseRequest(String) completed in: " + durationMillis + " ms (" + durationNanos + " ns)");

        // reset start time for next test
        startTime = System.nanoTime();

        // Parse the request
        RequestHeader requestHeader = Parser.parseRequestHeader(requestContent);
        
        endTime = System.nanoTime();
        durationNanos = endTime - startTime;
        durationMillis = durationNanos / 1_000_000.0;
        System.out.println("parseRequestHeader(String) completed in: " + durationMillis + " ms (" + durationNanos + " ns)");

        // reset start time for next test
        startTime = System.nanoTime();

        // Parse the request
        RequestDTO requestDTO = Parser.parseRequestIntoDTO(requestContent);
        
        endTime = System.nanoTime();
        durationNanos = endTime - startTime;
        durationMillis = durationNanos / 1_000_000.0;
        System.out.println("parseRequestIntoDTO(String) completed in: " + durationMillis + " ms (" + durationNanos + " ns)");
    }

    @Test
    public void testSpeedOf_RequestParserInDifferentOrder() throws IOException {
        // Read and process the test file
        String requestContent = ParserTestHelper.readTestFile("request_b1_billing_01.txt");

        long startTime = System.nanoTime();

        // Parse the request
        RequestHeader requestHeader = Parser.parseRequestHeader(requestContent);

        long endTime = System.nanoTime();
        long durationNanos = endTime - startTime;
        double durationMillis = durationNanos / 1_000_000.0;
        System.out.println("parseRequestHeader(String) completed in: " + durationMillis + " ms (" + durationNanos + " ns)");
        
        // reset start time for next test
        startTime = System.nanoTime();

        // Parse the request
        Request request = Parser.parseRequest(requestContent);        
        
        endTime = System.nanoTime();
        durationNanos = endTime - startTime;
        durationMillis = durationNanos / 1_000_000.0;
        System.out.println("parseRequest(String) completed in: " + durationMillis + " ms (" + durationNanos + " ns)");

        // reset start time for next test
        startTime = System.nanoTime();

        // Parse the request
        RequestDTO requestDTO = Parser.parseRequestIntoDTO(requestContent);
        
        endTime = System.nanoTime();
        durationNanos = endTime - startTime;
        durationMillis = durationNanos / 1_000_000.0;
        System.out.println("parseRequestIntoDTO(String) completed in: " + durationMillis + " ms (" + durationNanos + " ns)");

    }


}
