public class FullTimeEmployee extends Employee {
    private double monthlyBonus;

    public double getMonthlyBonus() { return monthlyBonus; }

    public void setMonthlyBonus(double monthlyBonus) { this.monthlyBonus = monthlyBonus; }

    @Override
    public double calculateMonthlySalary() {
        return super.getBaseSalary() + monthlyBonus;
    }
}
