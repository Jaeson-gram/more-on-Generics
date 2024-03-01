package com.Relearn;

import com.Relearn.util.QueryItem;
import com.Relearn.util.QueryList;

import java.util.ArrayList;
import java.util.List;

//7 - just to test the multiple upperbounds on the QueryList class
record Employee(String name) implements QueryItem{
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here

        int studentCount = 10;

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentCount; i++){
            students.add(new Student());
        }
        printList(students);
        System.out.println("-".repeat(25));

        //for LPAStudents
        //1 - why we can't have a LPAStudent in a printList(Student student), unless we make printList a generic type or use a method with a wildcard, or add a wildcard to it
        List<LPAStudents> lpastudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++){
            lpastudents.add(new LPAStudents());
        }
        printList(lpastudents);

        System.out.println("-".repeat(25));
        //passing the list lpastudents to the constructor
        var queryList = new QueryList<>(lpastudents);
        //trying to match the students taking the course 'Complex Systems' and adding them to a list
        var matches = queryList.getMatches("Course", "Computational Neuroscience");
        //passing them as a variable to the printAnotherList() method.
        printAnotherList(matches);

        //the 3 lines of code above are created to test the QueryItem Interface

        System.out.println("-".repeat(25));
        List<Student> students2021 = QueryList.getMatches(students, "yearEnrolled", "2021");
        printAnotherList(students2021);

        // QueryList<Employee> employeeQueryList = new QueryList<>(); -> can't. Because Employee does not extend 'Student as well...
    }

    //3 - use of wildcards
    public static void printAnotherList(List<? extends Student> students){ //use of a wildcard '?' -> means 'the type is yet unknown, but yeah, imagine it to be a Student type'
//        Student last = students.get(students.size() - 1);
//        students.set(0, last); -> Required Type: capture of ? extends Student. Provided: Student

//      The wildcard doesn't have enough info on whether it's a Student, or a LPAStudent, so it doesn't succumb
//      If we are going to change or set something, then the Generic method is a much better bargain, not the wildcard,
//      but in our case, the wildcard is a good solution

        for (var student : students){
            System.out.println(student.getYearEnrolled() + ":" + student);
        }

        System.out.println();
    }

    // 2 - solving the problem with our lpa vs student thing using a generic method
    public static <T extends Student> void printList(List<T> students){
        for (var student : students){
            System.out.println(student.getYearEnrolled() + ":" + student);
        }

        System.out.println();
    }


}
