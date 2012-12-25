package calc;

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
        String[] inputSplittedByDelimitor = splitInputByDelimitor(numbersWithDelimiters);
        return calculateSum(inputSplittedByDelimitor);
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

    private int calculateSum(String[] inputSplittedByDelimitor) {
        int result = 0;
        for (String token : inputSplittedByDelimitor) {
            result += Integer.parseInt(token);
        }
        return result;
    }

    private String[] splitInputByDelimitor(String input) {
        return input.split(delimiter);
    }

    private boolean isInputEmpty(String input) {
        return input.length() == 0;
    }
}
