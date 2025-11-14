package com.jdbc.StudentDatabase;

import java.sql.*;
import java.util.Scanner;

public class StudentImpl implements IStudent {
    private Connection conn;
    private Scanner sc = new Scanner(System.in);

    public StudentImpl() {
        conn = new ConnectionImpl().getConnection();
    }

    public void insertStudent() {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt(); sc.nextLine();
            System.out.print("Enter course: ");
            String course = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO student(name, age, course) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.executeUpdate();
            System.out.println("Student inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertMultipleStudents() {
        System.out.print("How many students? ");
        int count = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < count; i++) {
            insertStudent();
        }
    }

    @Override
    public void updateStudent() {
        try {
            System.out.print("Enter ID to update: ");
            int id = sc.nextInt(); sc.nextLine();
            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement("UPDATE student SET name=? WHERE id=?");
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println(" Student updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMultipleStudents() {
        insertMultipleStudents(); // Can be extended
    }

    @Override
    public void deleteStudent() {
        try {
            System.out.print("Enter ID to delete: ");
            int id = sc.nextInt();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(" Student deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMultipleStudents() {
        System.out.print("How many students to delete? ");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            deleteStudent();
        }
    }

    @Override
    public void showStudents() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                System.out.printf("%d | %s | %d | %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
