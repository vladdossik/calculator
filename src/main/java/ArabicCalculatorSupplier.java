public class ArabicCalculatorSupplier implements CalculatorSupplier {
    @Override
    public String getType() {
        return "arabic";
    }

    @Override
    public Calculator get() {
        return new ArabicCalculator();
    }
}
