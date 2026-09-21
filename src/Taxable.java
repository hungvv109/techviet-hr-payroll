public interface Taxable  {
    default double calculateTax(double gross) {
        if (gross <= 5_000_000) return gross;
        else if (gross <= 10_000_000) return gross*0.05;
        else if (gross <= 20_000_000) return gross*0.1;
        return gross*0.15;
    }
}
