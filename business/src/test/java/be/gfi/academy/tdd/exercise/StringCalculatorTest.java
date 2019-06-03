package be.gfi.academy.tdd.exercise;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by BPCO on 17/06/2018.
 */
public class StringCalculatorTest {

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {

        StringCalculator.add("1,2", ",");
        Assert.assertTrue(true);
    }

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,a", ",");
    }

    @Test
    public final void whenStringISEmptyReturn0() {
        Assert.assertEquals(0, StringCalculator.add("", ","));
    }

    @Test
    public final void checkSumWithOneNumber() {
        Assert.assertEquals(5, StringCalculator.add("5", "%"));
    }

    @Test
    public final void checkSumWithTwoNumbers() {
        Assert.assertEquals(17, StringCalculator.add("5,12", ","));
    }

    @Test
    public final void checkSumWithLotsOfNumbers() {
        Assert.assertEquals(110, StringCalculator.add("5,12,8,5,70,2,3,4,1", ","));
    }

    @Test
    public final void chooseDelimiter() {
        Assert.assertEquals(1022, StringCalculator.add("345///566///111", "///"));
    }

    @Test
    public final void handleNewLines() {
        Assert.assertEquals(21, StringCalculator.add("1/2n3/4n5n6", "/"));
    }

    @Test(expected = RuntimeException.class)
    public final void negativeNumbersThrowAnException() {
        StringCalculator.add("-1", ",");
    }

    @Test
    public final void negativeNumbersThrowAnExceptionWithSpecificMessage() {
        try {
            StringCalculator.add("-1,2,-3", ",");
        } catch (Exception e){
            Assert.assertEquals(e.getMessage(),"-1,-3");
        }
    }

    @Test
    public final void numbersBiggerThan1000ShouldBeIgnored() {
        ;
        Assert.assertEquals(2000, StringCalculator.add("1000,1001,999,2000,1", ","));
    }

    @Test
    public final void multipleDelimitersTested() {

        Assert.assertEquals(100, StringCalculator.add("20,30%40,%10", "[,][%]"));
    }


//    @Test(expected = RuntimeException.class)
//    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//
//        StringCalculator.add("1,2,3");
//    }

}
