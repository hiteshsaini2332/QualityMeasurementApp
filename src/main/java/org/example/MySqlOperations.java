package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlOperations {
    public static volatile Connection con;
    public static Connection getConnection()  {

        if(con==null){
            synchronized (MySqlOperations.class){
                if(con==null){
                    try{
                        con= DriverManager.getConnection("jdbc:mysql:///localhost:3306\"student_db\"","Hitesh","Password");
                    }
                    catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return con;

    }
    public static void closeConnection() {
        if (con != null) {
            synchronized (MySqlOperations.class){

                if(con != null){
                    try {
                        con.close();
                        System.out.println("the connection is closed successfully");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("error in closing connection : e - " + e);
                    }
                }
                con = null;
            }
        }
    }
//    public static void createTable(String tableName){
//        if(con != null){
//            try {
//                Statement st = con.createStatement();
//                st.execute("CREATE TABLE " +  tableName + " (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(30), last_name VARCHAR(30), age INT)");
//                System.out.println("table : " + tableName + " created successfully");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }else{
//            getConnection();
//            createTable(tableName);
//        }
//    }

    public static void insertPerson(Student student){
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO student VALUES(null, ?, ?, ?)");
            st.setString(1, student.getName());
            st.setInt(2, student.getStandard());
            st.setInt(3, student.getMarks());

            System.out.println("rows affected : " + st.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> getAllStudent(){
        List<Student> ans = new ArrayList();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while(rs.next()){
                String name = rs.getString(2);
                int standard = rs.getInt(3);
                int marks = rs.getInt(4);

                Student student = new Student(name, standard, marks);
                ans.add(student);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }
    public static Student getStudentById(int id){
        Student ans = null;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student where roll_no = " + id);
            while(rs.next()){
                String name = rs.getString(2);
                int standard = rs.getInt(3);
                int marks = rs.getInt(4);

                ans = new Student(name, standard, marks);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return ans;
    }
    public static void deleteStudentById(int id){
        try{
            Statement st = con.createStatement();
            int rows_affected = st.executeUpdate("DELETE FROM Student where roll_no = " + id);
            if(rows_affected >= 1){
                System.out.println("Student with id " + id + " has been successfully deleted");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateStudentById(int id)   {
        try {
            Statement st = con.createStatement();
            int rows_affected = st.executeUpdate("UPDATE Student set marks=90  where roll_no = " + id);
            if (rows_affected >= 1) {
                System.out.println("Student with id " + id + " has been successfully updated");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
