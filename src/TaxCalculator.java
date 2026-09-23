/**
 * Tính thuế TNCN theo phương pháp luỹ tiến từng phần:
 * mỗi phần thu nhập rơi vào bậc nào thì chỉ phần đó chịu thuế suất của bậc đó,
 * không phải áp 1 mức thuế duy nhất cho toàn bộ lương.
 *
 * Bậc 1: <= 5,000,000đ           -> 0%
 * Bậc 2: 5,000,000 - 10,000,000  -> 5%  (chỉ tính trên phần vượt 5tr)
 * Bậc 3: 10,000,000 - 20,000,000 -> 10% (chỉ tính trên phần vượt 10tr)
 * Bậc 4: > 20,000,000            -> 15% (chỉ tính trên phần vượt 20tr)
 */
public class TaxCalculator {

    private static final double BRACKET_1 = 5_000_000;
    private static final double BRACKET_2 = 10_000_000;
    private static final double BRACKET_3 = 20_000_000;

    private static final double RATE_2 = 0.05;
    private static final double RATE_3 = 0.10;
    private static final double RATE_4 = 0.15;

    public static double calculateTax(double grossSalary) {
        if (grossSalary <= 0) {
            return 0;
        }

        double tax = 0;

        double taxableAtRate2 = Math.min(grossSalary, BRACKET_2) - BRACKET_1;
        if (taxableAtRate2 > 0) {
            tax += taxableAtRate2 * RATE_2;
        }

        double taxableAtRate3 = Math.min(grossSalary, BRACKET_3) - BRACKET_2;
        if (taxableAtRate3 > 0) {
            tax += taxableAtRate3 * RATE_3;
        }

        double taxableAtRate4 = grossSalary - BRACKET_3;
        if (taxableAtRate4 > 0) {
            tax += taxableAtRate4 * RATE_4;
        }

        return tax;
    }
}