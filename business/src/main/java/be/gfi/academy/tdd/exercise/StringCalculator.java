package be.gfi.academy.tdd.exercise;

import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * Created by BPCO on 17/06/2018.
 * Class to perform calculations with strings
 */
public class StringCalculator {
    /**
     * Method to calculate the sum of numbers in a given string
     */
    public static final int add(String numbers, String delimiter){

        if(numbers.equals("")) {
            return 0;
        } else{
            numbers = numbers.replace("n", delimiter);
        }

        if(delimiter.contains("[")) delimiter = createDelimiter(delimiter);


        String[] numbersArray = numbers.split(delimiter);

        int[] parsedNumbers = getArrayOfParsedNumbers(numbersArray);


        checkForNegativeNumbers(parsedNumbers);

        return (int)  Arrays.stream(parsedNumbers)
                            .filter(i -> i <= 1000)
                            .sum();
    }


    public static String createDelimiter(String delimiter) {

        delimiter = delimiter.replaceAll("\\]", "");
        delimiter = delimiter.replaceAll("\\[", "|");
        delimiter = "[" + delimiter.substring(1) + "]+";

        return delimiter;
    }


    private static int[] getArrayOfParsedNumbers(String[] numbersArray) {
        return Arrays.stream(numbersArray)
                                    .mapToInt(StringCalculator::parseOrThrow)
                                    .toArray();
    }


    public static int parseOrThrow(String number) {

        try {
            return Integer.parseInt(number);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }


    public static void checkForNegativeNumbers(int [] numbersArray) {

        String negativeNumbers = Arrays.stream(numbersArray)
                                       .filter(i -> i < 0)
                                       .mapToObj(s -> String.valueOf(s))
                                       .collect(Collectors.joining(","));

        if(negativeNumbers.length() > 0) throw new RuntimeException(negativeNumbers);
    }
}

