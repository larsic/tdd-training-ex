package be.gfi.academy.tdd.exercise;

import be.gfi.academy.tdd.exercise.StringCalculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by BPCO on 17/06/2018.
 */
public class StringCalculatorTest {
    @Test(expected = RuntimeException.class)
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        StringCalculator.add("1,2");
    }

    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        Assert.assertTrue(true);
    }

    public final void whenNtonNumberIsUsedThenExceptionIsThrown() {
    }

}
