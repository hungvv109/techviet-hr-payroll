public class PartTimeEmployee extends Employee {
    private int hourlyRate;
    private int hoursWorkedThisMonth;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorkedThisMonth() {
        return hoursWorkedThisMonth;
    }

    public void setHoursWorkedThisMonth(int hoursWorkedThisMonth) {
        this.hoursWorkedThisMonth = hoursWorkedThisMonth;
    }

    @Override
    public double calculateMonthlySalary() {
        if (hoursWorkedThisMonth <= 160) {
            return hoursWorkedThisMonth * hourlyRate;
        }
        return 160 * hourlyRate + (hoursWorkedThisMonth-160) * hourlyRate * 1.5;
    }
}
