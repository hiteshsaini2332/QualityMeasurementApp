package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlOperations {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db",
                    "Hitesh",
                    "Password"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to DB", e);
        }
    }
    public static void insertStudent(Student student){
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "INSERT INTO student (name, standard, marks) VALUES (?, ?, ?)")) {

            st.setString(1, student.getName());
            st.setInt(2, student.getStandard());
            st.setInt(3, student.getMarks());

            System.out.println("Rows affected: " + st.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getAllStudent(){
        List<Student> ans = new ArrayList<>();

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student")) {

            while(rs.next()){
                String name = rs.getString(2);
                int standard = rs.getInt(3);
                int marks = rs.getInt(4);

                ans.add(new Student(name, standard, marks));
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return ans;
    }

    public static Student getStudentById(int id){
        Student ans = null;

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "SELECT * FROM student WHERE roll_no = ?")) {

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                String name = rs.getString(2);
                int standard = rs.getInt(3);
                int marks = rs.getInt(4);

                ans = new Student(name, standard, marks);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return ans;
    }

    public static void deleteStudentById(int id){
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "DELETE FROM student WHERE roll_no = ?")) {

            st.setInt(1, id);
            int rows = st.executeUpdate();

            if(rows >= 1){
                System.out.println("Student with id " + id + " deleted successfully");
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateStudentById(int id){
        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(
                     "UPDATE student SET marks = 90 WHERE roll_no = ?")) {

            st.setInt(1, id);
            int rows = st.executeUpdate();

            if(rows >= 1){
                System.out.println("Student with id " + id + " updated successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}