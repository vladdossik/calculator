public class RomanCalculatorSupplier implements  CalculatorSupplier {
    @Override
    public String getType() {
        return "roman";
    }

    @Override
    public Calculator get() {
        return new RomanCalculator();
    }
}
