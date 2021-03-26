import model.RomanNumeral;

import java.util.List;

public class RomanCalculator implements Calculator {

    @Override
    public String calculate(String firstNumber, String secondNumber, String operation) {
        int firstValue = romanToArabic(firstNumber);
        int secondValue = romanToArabic(secondNumber);
        Operations operations = new Operations();
        return switch (operation) {
            case "+" -> arabicToRoman(operations.sum(firstValue, secondValue));
            case "-" -> arabicToRoman(operations.subtraction(firstValue, secondValue));
            case "*" -> arabicToRoman(operations.multiplication(firstValue, secondValue));
            default -> arabicToRoman(operations.division(firstValue, secondValue));
        };

    }

    private int romanToArabic(String number) {
        String romanNumeral = number.toUpperCase();
        int result = 0;
        List<RomanNumeral> romanList = RomanNumeral.getReverseSortedValues();
        int i = 0;
        while ((romanNumeral.length() > 0) && (i < romanList.size())) {
            RomanNumeral symbol = romanList.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else i++;
        }
        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(number + " cannot converted to a arabic numeral");
        }
        return result;
    }
    
    private String arabicToRoman(int number) {
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (number > 0 && i < romanNumerals.size()) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                stringBuilder.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else i++;
        }
        return stringBuilder.toString();
    }
}
