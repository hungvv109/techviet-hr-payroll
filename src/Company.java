import java.util.ArrayList;
import java.util.Comparator;

class Company {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public double getTotalPayroll() {
        double sum = 0;

        if (employeeList.isEmpty()) return sum;

        for (Employee employee : employeeList) {
            sum += employee.calculateMonthlySalary();
        }

        return sum;
    }

    public Employee getHighestPaidEmployee() {
        double max_salary = Double.MIN_VALUE;
        Employee highestEmpl = null;

        for (Employee employee : employeeList) {
            if (employee.calculateMonthlySalary() > max_salary) {
                highestEmpl = employee;
            }
        }

        return highestEmpl;
    }

    public void exportPayrollReport() {
        double totalGross = 0;
        double totalTax = 0;
        double totalNet = 0;

        String line = "-".repeat(97);

        System.out.println("=".repeat(97));
        System.out.println("BÁO CÁO LƯƠNG THÁNG - TechViet");
        System.out.println("=".repeat(97));
        System.out.printf("%-6s %-20s %-14s %15s %15s %15s%n",
                "ID", "Họ tên", "Loại NV", "Lương gộp", "Thuế TNCN", "Thực lĩnh");
        System.out.println(line);

        for (Employee e : employeeList) {
            double gross = e.calculateMonthlySalary();
            double tax = TaxCalculator.calculateTax(gross);
            double net = gross - tax;

            totalGross += gross;
            totalTax += tax;
            totalNet += net;

            String type = e.getClass().getSimpleName();

            System.out.printf("%-6s %-20s %-14s %,15.0f %,15.0f %,15.0f%n",
                    e.getId(), e.getName(), type, gross, tax, net);
        }

        System.out.println(line);
        System.out.printf("%-6s %-20s %-14s %,15.0f %,15.0f %,15.0f%n",
                "", "TỔNG CỘNG", "", totalGross, totalTax, totalNet);
        System.out.println("=".repeat(97));
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        employee.setTotalEmployee(employee.getTotalEmployee() + 1);
    }

    public void showAllEmployees() {
        for (Employee employee : employeeList) {
            double gross = employee.calculateMonthlySalary();
            System.out.printf("%-6s %-20s %-14s %,15.0f %,15.0f %,15.0f%n",
                    employee.getId(), employee.getName(), employee.getClass(),
                    gross, employee.calculateTax(gross),
                    gross - employee.calculateTax(gross));
        }
    }

    public void showEmployee(Employee employee) {
        double gross = employee.calculateMonthlySalary();
        System.out.printf("%-6s %-20s %-14s %,15.0f %,15.0f %,15.0f%n",
                employee.getId(), employee.getName(), employee.getClass(),
                gross, employee.calculateTax(gross),
                gross - employee.calculateTax(gross));
    }

    public Employee findById(String id) {
        for (Employee e : employeeList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void sortEmployeeById() {
        employeeList.sort(Comparator.comparing(Employee::getId));
        showAllEmployees();
    }

    public void sortEmployeeBySalary() {
        employeeList.sort(Comparator.comparingDouble(Employee::calculateMonthlySalary));
        showAllEmployees();
    }

    public void removeEmployeeById(String id) {
        boolean removed = employeeList.removeIf(e -> e.getId().equals(id));
        if (removed) {
            System.out.println("Remove success!");
        } else {
            System.out.println("Remove is not success. Please check ID again!");
        }
    }
}