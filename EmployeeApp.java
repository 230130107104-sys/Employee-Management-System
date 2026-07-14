import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeApp{

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Department");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            int choice = sc.nextInt();

            switch(choice){
                case 1 -> addEmployee();
                case 2 -> viewEmployee();
                case 3 -> searchEmployee();
                case 4 -> updateDepartment();
                case 5 -> {
                    System.out.println("Exiting application. Goodbye!");
                    System.exit(0);
                }
            default -> System.out.println("Invalid choice. Please try again.");

            }
        }
    }
    static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline character
    
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
    
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
    
        employees.add(new Employee(id, name, dept));
        System.out.println("Employee added successfully.");
    }

    static void viewEmployee(){
        if(employees.isEmpty()){
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Employee List ---");
        for(Employee e : employees){
            System.out.println("ID: "+e.id+ " | Name: "+e.name+ " | Department: " + e.department);
        }
    }

    static void searchEmployee() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
    
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.println("Found: " + e.name + " (" + e.department + ")");
                return; // Exit method early if found
            }
        }
        System.out.println("Employee not found.");
    }

    static void updateDepartment() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
    
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.print("Enter New Department: ");
                e.department = sc.nextLine();
                System.out.println("Department updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }


}