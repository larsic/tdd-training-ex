package be.gfi.academy.tdd.solution;

/**
 * Created by BPCO on 17/06/2018.
 */
public class StringCalculatorSolution {
    /**
     * Method to calculate the sum of numbers in a given string
     */
    public static final int add(String delimiter, String numbers){
        String[] numbersArray = getNumbersArray(delimiter,numbers);
        String negatives = "";
        int result = 0;

        if(!"".equals(numbers)){
            for (String number : numbersArray) {
                if(number.length() > 0) {
                    Integer num = Integer.parseInt(number);
                    if (num < 0) {
                        if (negatives.length() > 0) {
                            negatives += ", ";
                        }
                        negatives += num;
                    } else if (num < 1000) {
                        result += Integer.parseInt(number);
                    }
                }
            }
        }

        if(negatives.length() > 0){
            throw new RuntimeException("Negatives not allowed: [" + negatives + "]");
        }

        return result;
    }

    /**
     * Splits de numbers for the given delimiters
     * @param delimiter - the delimiters
     * @param numbers - the numbers
     * @return an array with the numbers
     */
    private static String[] getNumbersArray(String delimiter, String numbers){
        String[] delimiterArray = delimiter.split("]\\[");
        String splitExpression = "";

        for(int i=0; i<delimiterArray.length;i++){
            if(!splitExpression.equals("")){
                splitExpression += "|";
            }

            splitExpression += delimiterArray[i].replaceAll("\\[|\\]","");
        }

        splitExpression += "|n";

        return  numbers.split(splitExpression);
    }
}
