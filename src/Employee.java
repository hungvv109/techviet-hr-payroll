public abstract class Employee implements Taxable {

  private String id; // ID0001, ID0100, ID0099
  private String name;
  private int hireYear;
  private double baseSalary;
  private int totalEmployee = 0;
  public static final double MIN_WAGE = 3_000_000;

  public Employee() {}

  public Employee(String id, String name, int hireYear) {
    this.id = id;
    this.name = name;
    this.hireYear = hireYear;
  }

  public Employee(String id, String name, int hireYear, double baseSalary) {
    this.id = id;
    this.name = name;
    this.hireYear = hireYear;
    this.baseSalary = baseSalary;
  }

  public String getId() {
    return id;
  }

  public boolean setId(String id) {
    id = id.trim();
    if (id.matches("^ID[0-9]{4}$")) {
      this.id = id;
      return true;
    }
    return false;
  }

  public String getName() {
    return name;
  }

  public boolean setName(String name) {
    name = name.trim();
    if (!name.isEmpty()) {
      this.name = name;
      return true;
    }
    return false;
  }

  public int getHireYear() {
    return hireYear;
  }

  public void setHireYear(int hireYear) {
    this.hireYear = hireYear;
  }

  public double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = Math.max(baseSalary, MIN_WAGE);
  }

  public int getTotalEmployee() {
    return totalEmployee;
  }

  public void setTotalEmployee(int totalEmployee) {
    this.totalEmployee = totalEmployee;
  }

  public abstract double calculateMonthlySalary();
}
