import java.util.Scanner;

public class CalculatorApp {
    public static boolean checkArabic(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter mathematical expression");
        Scanner scanner = new Scanner(System.in);
        String[] inputText = scanner.nextLine().split(" ");

        if (inputText.length != 3) {
            throw new IllegalArgumentException("Invalid expression");
        }
        Calculator calculator;

        if (checkArabic(inputText[0]) && checkArabic(inputText[2]) && checkArabic(inputText[0]) == checkArabic(inputText[2])) {
            calculator = CalculatorFactory.getInstance().get("arabic");
        } else if (!checkArabic(inputText[0]) && !checkArabic(inputText[2]) && checkArabic(inputText[0]) == checkArabic(inputText[2])) {
            calculator = CalculatorFactory.getInstance().get("roman");
        } else {
            throw new IllegalArgumentException("Invalid expression");
        }
        System.out.println(calculator.calculate(inputText[0], inputText[2], inputText[1]));
    }

}
