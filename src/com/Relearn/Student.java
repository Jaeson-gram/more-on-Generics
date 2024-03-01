package com.Relearn;

import com.Relearn.util.QueryItem;

import java.util.Locale;
import java.util.Random;

public class Student implements QueryItem{

    private String name;
    private String course;
    private int yearEnrolled;

    protected static Random random = new Random();
    private static String[] firstnames = {"Eze", "OreOluwa", "Ndubuisi", "Philip", "Oke"};
    private static String[] courses = {"Ground Systems Programming", "Computational Neuroscience", "CyberSecurity", "Embedded Systems", "Complex Systems"};

    public Student() {
        int lastnameIndex = random.nextInt(65, 91); //65 = A, 90 = Z. We use it to generate a letter for the name (lastname)
        name = firstnames[random.nextInt(5)] + " " + (char) lastnameIndex;
        course = courses[random.nextInt(5)];
        yearEnrolled = random.nextInt(2017, 2023);
    }

    @Override
    public String toString() {
//        return super.toString();
        return "%-15s %-15s (%d) %n".formatted(name, course, yearEnrolled);
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    // 4 - to test the Interface and esp. the QueryList class.
    @Override
    public boolean matchFieldValue(String fieldName, String value) {
//        return false;
        String fName = fieldName.toLowerCase();

        //returns a boolean whose value depends on whether the input for value matches any of our fields...
        return switch (fName){
            case "name" -> name.equalsIgnoreCase(value);
            case "course" -> course.equalsIgnoreCase(value);
            case "yearenrolled" -> yearEnrolled == (Integer.parseInt(value));
            default -> false;
        };
    }
}
