public class Manager extends FullTimeEmployee {
    private double teamSaleTarget;
    private double actualTeamSales;

    public double getTeamSaleTarget() {
        return teamSaleTarget;
    }

    public void setTeamSaleTarget(double teamSaleTarget) {
        this.teamSaleTarget = teamSaleTarget;
    }

    public double getActualTeamSales() {
        return actualTeamSales;
    }

    public void setActualTeamSales(double actualTeamSales) {
        this.actualTeamSales = actualTeamSales;
    }

    @Override
    public double calculateMonthlySalary() {
        return super.calculateMonthlySalary() + (actualTeamSales > teamSaleTarget ? actualTeamSales * 0.05 : 0);
    }
}
