package calc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Klaus Bayrhammer
 */
public class StringCalculatorTest
{

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception
    {
        calculator = new StringCalculator();
    }

    @Test
    public void calculateEmptyResult() throws Exception
    {
        Assert.assertEquals(0, calculator.add(""));
    }

    @Test
    public void calculateSingleNumber() throws Exception
    {
        Assert.assertEquals(1, calculator.add("1"));
    }

    @Test
    public void calculateTwo_expectTwo() throws Exception
    {
        Assert.assertEquals(2, calculator.add("2"));
    }

    @Test
    public void calculateTwoToOne_expectThree() throws Exception
    {
        Assert.assertEquals(3, calculator.add("2,1"));
    }

    @Test
    public void calculateTwoToOneWithNewlines_expectThree() throws Exception
    {
        Assert.assertEquals(3, calculator.add("2\n1"));
    }

    @Test
    public void calculateTwoToOneWithCustomDelimiter_expectThree() throws Exception
    {
        Assert.assertEquals(3, calculator.add("//x\n2x1"));
    }
}
