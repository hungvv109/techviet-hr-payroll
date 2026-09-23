public interface Taxable  {
    default double calculateTax(double gross) {
        return TaxCalculator.calculateTax(gross);
    }
}
