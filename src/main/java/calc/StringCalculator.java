package calc;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Klaus Bayrhammer
 */
public class StringCalculator {
    private String delimiter = "[,\n]";
    private String numbersWithDelimiters;

    public int add(String input) {
        if (isInputEmpty(input)) {
            return 0;
        }
        if (hasCustomDelimiter(input)) {
            parseDelimiterAndFindLineWithNumbersAndDelimiters(input);
        } else {
            numbersWithDelimiters = input;
        }
        String[] inputSplittedByDelimiter = splitInputByDelimiter(numbersWithDelimiters);
        return calculateSum(inputSplittedByDelimiter);
    }

    private void parseDelimiterAndFindLineWithNumbersAndDelimiters(String input) {
        parseDelimiter(input);
        findLineWithNumbersAndDelimiters(input);
    }

    private void findLineWithNumbersAndDelimiters(String input) {
        int firstNewLine = input.indexOf("\n");
        numbersWithDelimiters = input.substring(firstNewLine + 1);
    }

    private void parseDelimiter(String input) {
        delimiter = String.valueOf(input.charAt(2));
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private int calculateSum(String[] inputSplittedByDelimiter) {
        int result = 0;
        List<String> negativeTokens = new ArrayList<String>();

        for (String token : inputSplittedByDelimiter) {
            Integer valueAsInteger = Integer.parseInt(token);
            if (valueAsInteger < 0) {
                negativeTokens.add(token);
            }
            result += valueAsInteger;
        }
        if (negativeTokens.size() > 0) {
            throw new IllegalArgumentException(String.format("negatives not allowed (%s)", StringUtils.join(negativeTokens, ",")));
        }
        return result;
    }

    private String[] splitInputByDelimiter(String input) {
        return input.split(delimiter);
    }

    private boolean isInputEmpty(String input) {
        return input.length() == 0;
    }
}
