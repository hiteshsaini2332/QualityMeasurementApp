package org.example;

import java.util.List;

public class Application {
    static void main() {
        List<Student> students = MySqlOperations.getAllStudent();
        System.out.println("All Students: " + students);
//        MySqlOperations.deleteStudentById(5);
//        List<Student> updatedList = MySqlOperations.getAllStudent();
//        System.out.println("After Deletion: " + updatedList);
    }
}
