import java.util.HashMap;
import java.util.Map;

public enum CalculatorFactory {
    INSTANCE();
    private final Map<String, CalculatorSupplier> suppliers;

    CalculatorFactory() {
        suppliers = new HashMap<>();
        register(new ArabicCalculatorSupplier());
        register(new RomanCalculatorSupplier());
    }

    public void register(CalculatorSupplier supplier) {
        suppliers.put(supplier.getType(), supplier);
    }

    public Calculator get(String type) {
        if (suppliers.containsKey(type)) {
            return suppliers.get(type).get();
        }
        throw new IllegalArgumentException("calculator with type " + type + " not registered");
    }

    public static CalculatorFactory getInstance() {
        return INSTANCE;
    }
}
