package poc.ncpdp.parser.transmissions.concerns;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * Helper class for parsing NCPDP test files
 */
public class ParserTestHelper {
    private static final String TEST_RESOURCES_PATH = "src/test/resources/";
    
    /**
     * Reads a test file and converts special tokens to their proper character representations
     * @param fileName The name of the file in the test/resources directory
     * @return The processed content of the file
     */
    public static String readTestFile(String fileName) throws IOException {
        Path path = getTestFilePath(fileName);
        String content = Files.readString(path);
        content = convertSpecialCharacters(content);
        if (!isAscii(content)) {
            throw new IllegalArgumentException("File contains non-ASCII characters");
        } else {
            return convertSpecialCharacters(content);
        }
    }

    public static boolean isAscii(String input) {
        return StandardCharsets.US_ASCII.newEncoder().canEncode(input);
    }

    /**
     * Creates a test file path relative to the test/resources directory
     * @param fileName The name of the file
     * @return The full path to the test file
     */
    private static Path getTestFilePath(String fileName) {
        return Paths.get(TEST_RESOURCES_PATH + fileName);
    }

    /**
     * Converts NCPDP special characters to their actual representations
     * @param content The raw file content
     * @return The processed content with special characters converted
     */
    private static String convertSpecialCharacters(String content) {
        return content
            .replaceAll(Pattern.quote("<1E>"), "\u001E") // Record Separator
            .replaceAll(Pattern.quote("<1D>"), "\u001D") // Group Separator
            .replaceAll(Pattern.quote("<1C>"), "\u001C") // Field Separator
            .replaceAll("Ø", "0");                   // Convert Ø to 0
    }
}
