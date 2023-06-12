package ontotext.javacourse.exceptions.consolereader;

import org.codehaus.plexus.util.StringUtils;

import java.util.Scanner;

/**
 * The NumberReader class reads numbers in the 0-100 range and throws exception when the read number is outside the range.
 */
public class NumberReader {
    private NumberReader() throws IllegalAccessException {
        throw new IllegalAccessException("The NumberReader class is not meant to be instantiated");
    }

    /**
     * Reads number in the 0-100 range from console. If the given number is outside the given range
     * NumberOutsideOfRangeException is thrown.
     */
    public static void read() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (!StringUtils.isNumeric(input)) {
            throw new NumberOutsideOfRangeException("The given number is not in the 0-100 range.");
        }
    }
}
