import java.util.function.Supplier;

public interface CalculatorSupplier extends Supplier<Calculator> {
    String getType();
}
