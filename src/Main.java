import java.util.Scanner;
/*
- xu ly enter sai id
- Xu ly trung id
- Xy lys nhap sai year
- check if input string -> error
 */
public class Main {
    public static void main(String[] args) {
        Company techViet = new Company();
        Scanner scanner = new Scanner(System.in);
        int input = 1;

        while (input > 0) {

            System.out.println("""
                    ╔══════════════════════Tech Viet payroll program════════════════════════╗
                    ║ 1. Add new employee.                                                  ║
                    ║ 2. Customize salary.                                                  ║
                    ║ 3. Show employee list.                                                ║
                    ║ 4. Calculate all company salary.                                      ║
                    ║ 5. Find highest salary employee.                                      ║
                    ║ 6. Sort by salary in descending order.                                ║
                    ║ 7. Export salary report (have tax).                                   ║
                    ║ 8. Remove the employee by ID.                                         ║
                    ║ 0. Exit                                                               ║
                    ╚═══════════════════════════════════════════════════════════════════════╝
                    """);

            System.out.print("Please enter your feature: ");
            input = scanner.nextInt();

            while (input < 0 || input > 8) {
                System.out.println("""
                        Invalid number!
                        Please enter again!""");
                input = scanner.nextInt();
            }

            // Add new employee
            switch (input) {
                case 0:
                    break;
                case 1:
                    System.out.print("""
                            Which type employee do you want?
                            1. Full-time Employee - Normal.
                            2. Full-time Employee - Manager.
                            3. Part-time Employee.
                            0. Exit
                            Please enter:""");

                    int sub_input = scanner.nextInt();

                    while (sub_input < 0 || sub_input > 3) {
                        System.out.println("""
                                Invalid number!
                                Enter again!
                                Please enter:\s""");
                        sub_input = scanner.nextInt();
                    }

                    switch (sub_input) {
                        case 0:
                            break;
                        case 1:
                            Employee ft_employee = new FullTimeEmployee();
                            while (true) {
                                System.out.print("Enter ID (Form: IDxxxx): ");
                                String id = scanner.nextLine();

                                if (ft_employee.setId(id)) {
                                    System.out.println("Valid ID!");
                                    break;
                                }
                                System.out.println("Invalid ID! Please enter again.");
                            }
                            scanner.nextLine();

                            while (true) {
                                System.out.print("Enter name: ");
                                String name = scanner.nextLine();

                                if (ft_employee.setName(name)) {
                                    System.out.println("Valid Name!");
                                    break;
                                }
                                System.out.println("Invalid Name! Please enter again.");
                            }

                            System.out.print("Hire year of the employee: ");
                            ft_employee.setHireYear(scanner.nextInt());

                            System.out.print("Base salary of the employee: ");
                            ft_employee.setBaseSalary(scanner.nextDouble());

                            techViet.addEmployee(ft_employee);
                            System.out.println("Add employee success!");
                            break;
                        case 2:
                            Employee manager = new Manager();
                            while (true) {
                                System.out.print("Enter ID (Form: IDxxxx): ");
                                String id = scanner.nextLine();

                                if (manager.setId(id)) {
                                    System.out.println("Valid ID!");
                                    break;
                                }
                                System.out.println("Invalid ID! Please enter again.");
                            }
                            scanner.nextLine();

                            while (true) {
                                System.out.print("Enter name: ");
                                String name = scanner.nextLine();

                                if (manager.setName(name)) {
                                    System.out.println("Valid Name!");
                                    break;
                                }
                                System.out.println("Invalid Name! Please enter again.");
                            }

                            System.out.print("Hire year of the employee: ");
                            manager.setHireYear(scanner.nextInt());

                            System.out.print("Base salary of the employee: ");
                            manager.setBaseSalary(scanner.nextDouble());

                            techViet.addEmployee(manager);
                            System.out.println("Add employee success!");
                            break;
                        case 3:
                            PartTimeEmployee pt_employee = new PartTimeEmployee();
                            while (true) {
                                System.out.print("Enter ID (Form: IDxxxx): ");
                                String id = scanner.nextLine();

                                if (pt_employee.setId(id)) {
                                    System.out.println("Valid ID!");
                                    break;
                                }
                                System.out.println("Invalid ID! Please enter again.");
                            }
                            scanner.nextLine();

                            while (true) {
                                System.out.print("Enter name: ");
                                String name = scanner.nextLine();

                                if (pt_employee.setName(name)) {
                                    System.out.println("Valid Name!");
                                    break;
                                }
                                System.out.println("Invalid Name! Please enter again.");
                            }

                            System.out.print("Hire year of the employee: ");
                            pt_employee.setHireYear(scanner.nextInt());

                            System.out.println("Hourly Rate = " + pt_employee.getHourlyRate() + "vnd");
                            System.out.print("Hours worked this month: ");
                            pt_employee.setHoursWorkedThisMonth(scanner.nextInt());

                            techViet.addEmployee(pt_employee);
                            System.out.println("Add employee success!");
                            break;
                    }
                    break;

                // Customize salary
                case 2:
                    System.out.print("Please enter your ID you want to edit: "); // Form: IDxxxx
                    String enter_id = scanner.next();
                    scanner.nextLine();

                    Employee e = techViet.findById(enter_id);
                    FullTimeEmployee ft_e = new FullTimeEmployee();
                    PartTimeEmployee pt_e = new PartTimeEmployee();
                    Manager m = new Manager();

                    if (e == null) {
                        System.out.println("Please check ID again!");
                    } else {
                        if (e.equals(ft_e)) {
                            System.out.println("This is a Full-time Employee!");
                            System.out.print("Replace monthly bonus from " + ft_e.getMonthlyBonus() + " to: ");
                            ft_e.setMonthlyBonus(scanner.nextDouble());
                            System.out.println("Success!");
                        } else if (e.equals(pt_e)) {
                            System.out.println("This is a Part-time Employee!");
                            System.out.print("Replace hourly rate from " + pt_e.getHourlyRate() + " to: ");
                            pt_e.setHourlyRate(scanner.nextInt());
                            System.out.print("Replace Hours worked this month from " + pt_e.getHoursWorkedThisMonth() + " to: ");
                            pt_e.setHoursWorkedThisMonth(scanner.nextInt());
                            System.out.println("Success!");
                        } else {
                            System.out.println("This is a Manger!");
                            System.out.print("Replace team sales target from " + m.getTeamSaleTarget() + " to: ");
                            m.setTeamSaleTarget(scanner.nextDouble());
                            System.out.print("Replace actual team sales from " + m.getActualTeamSales() + " to: ");
                            m.setActualTeamSales(scanner.nextDouble());
                            System.out.println("Success!");
                        }
                    }

                    break;

                // Show employee list in TechViet
                case 3:
                    techViet.sortEmployeeById();
                    break;

                // Calculate all company salary
                case 4:
                    System.out.println("TechViet salary: " + techViet.getTotalPayroll());
                    break;

                // Find highest salary employee.
                case 5:
                    techViet.showEmployee(techViet.getHighestPaidEmployee());

                    break;

                // Sort by salary in descending order.
                case 6:
                    techViet.sortEmployeeBySalary();
                    break;

                // Export salary report (have tax).
                case 7:
                    techViet.exportPayrollReport();
                    break;

                // Remove the employee by ID.
                case 8:
                    System.out.print("Enter ID you want remove: ");
                    String id = scanner.next();
                    techViet.removeEmployeeById(id);
                    break;
            }
            System.out.println("End program!");
        }
    }
}
