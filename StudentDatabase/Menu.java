package com.jdbc.StudentDatabase;
import java.util.Scanner;

public class Menu implements IMenu {
    private Scanner sc = new Scanner(System.in);
    private StudentImpl student = new StudentImpl();

    @Override
    public void showMenu() {
        while (true) {
            System.out.println("\nWelcome to JDBC");
            System.out.println("Student Database Menu");
            System.out.println("1. Insert a student");
            System.out.println("2. Insert multiple students");
            System.out.println("3. Update a student");
            System.out.println("4. Update multiple students");
            System.out.println("5. Delete a student");
            System.out.println("6. Delete multiple students");
            System.out.println("7. Show students");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
            case 1:
                student.insertStudent();
                break;
            case 2:
                student.insertMultipleStudents();
                break;
            case 3:
                student.updateStudent();
                break;
            case 4:
                student.updateMultipleStudents();
                break;
            case 5:
                student.deleteStudent();
                break;
            case 6:
                student.deleteMultipleStudents();
                break;
            case 7:
                student.showStudents();
                break;
            case 8:
                System.out.println(" Goodbye!");
                return;
            default:
                System.out.println("Invalid choice!");
                break;
            }

        }
    }
}


