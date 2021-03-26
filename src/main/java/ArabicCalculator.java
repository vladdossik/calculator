public class ArabicCalculator implements Calculator {

    @Override
    public String calculate(String firstNumber, String secondNumber, String operation) {
        Operations operations = new Operations();
        int firstValue = Integer.parseInt(firstNumber);
        int secondValue = Integer.parseInt(secondNumber);
        return switch (operation) {
            case "+" -> String.valueOf(operations.sum(firstValue, secondValue));
            case "-" -> String.valueOf(operations.subtraction(firstValue, secondValue));
            case "*" -> String.valueOf(operations.multiplication(firstValue, secondValue));
            default -> String.valueOf(operations.division(firstValue, secondValue));
        };

    }
}

