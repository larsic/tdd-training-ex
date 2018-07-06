package be.gfi.academy.tdd.solution;

import be.gfi.academy.tdd.solution.StringCalculatorSolution;
import org.junit.*;
/**
 * Created by BPCO on 17/06/2018.
 */
public class StringCalculatorSolutionTest {
    /*
    @Test(expected = RuntimeException.class)
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        StringCalculatorSolution.add("1,2,3");
    }
    */

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculatorSolution.add(",","1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculatorSolution.add(",","1,X");
    }

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        Assert.assertEquals(0, StringCalculatorSolution.add(",", ""));
    }

    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        Assert.assertEquals(3, StringCalculatorSolution.add(",","3"));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        Assert.assertEquals(3+6, StringCalculatorSolution.add(",", "3,6"));
    }

    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15+18+46+33, StringCalculatorSolution.add(",","3,6,15,18,46,33"));
    }

    @Test
    public final void whenDifferentDelimitersOneAtaTime(){
        Assert.assertEquals(3+6+15+18+46+33,StringCalculatorSolution.add(";","3;6;15;18;46;33"));
    }

    @Test
    public final void whenNewLine(){
        Assert.assertEquals(3+6+15+18+46+33, StringCalculatorSolution.add(";","3;6n15;18;46n33"));
    }

    @Test
    public final void whenNegativeNumbers(){
        RuntimeException exception = null;
        try {
            StringCalculatorSolution.add(",","3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }

    @Test
    public final void whenNumbersBiggerThan1000(){
        Assert.assertEquals(3+6, StringCalculatorSolution.add(",","3,1000,1001,6,1234"));
    }

    @Test
    public final void whenDelimterWithAnyLength(){
        Assert.assertEquals(1+2+3, StringCalculatorSolution.add("--","n1--2--3"));
    }

    @Test
    public final void whenMultipleDelimeters(){
        Assert.assertEquals(1+2+3, StringCalculatorSolution.add("[-][%]","n1-2%3"));
        Assert.assertEquals(1+2+3, StringCalculatorSolution.add("[-][%%]","n1-2%%3"));
    }
}
