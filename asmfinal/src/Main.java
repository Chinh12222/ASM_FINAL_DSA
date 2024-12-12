import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement sms = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Generate Random Students");
            System.out.println("6. Bubble Sort Students by Marks");
            System.out.println("7. Merge Sort Students by Marks");
            System.out.println("8. Display All Students");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    sms.addStudent(id, name, grade);
                    break;
                case 2:
                    System.out.print("Enter ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Grade: ");
                    double newGrade = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    sms.updateStudent(editId, newName, newGrade);
                    break;
                case 3:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    sms.deleteStudent(deleteId);
                    break;
                case 4:
                    System.out.print("Enter ID to search: ");
                    String searchId = scanner.nextLine();
                    sms.searchStudentById(searchId);
                    break;
                case 5:
                    System.out.print("Enter number of random students to generate: ");
                    int count = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    sms.addRandomStudents(count);
                    break;
                case 6:
                    sms.bubbleSort();
                    System.out.println("Students sorted using Bubble Sort.");
                    break;
                case 7:
                    sms.mergeSort();
                    System.out.println("Students sorted using Merge Sort.");
                    break;
                case 8:
                    sms.displayAllStudents();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}