package com.Relearn.util;

import com.Relearn.Student;

import java.util.ArrayList;
import java.util.List;

/*
* we'll use this class to make out lists of specified students, using the Interface too.
* for instance, we can capture a list of students for a given field (course), with a certain value (Complex Systems)
* or for a given field (yearEnrolled) with a certain value (2022)
* or for a given field (name), with a given value(Ake);
* */

public class QueryList<T extends Student & QueryItem> { //5 - using multiple upperbounds

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public List<T> getMatches(String field, String value){
        List<T> matches = new ArrayList<>();

        for (var item : items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }

        return matches;
    }

    //6 - without making this a genetic class, we will be unable to use the class's type parameter in a static method.
    // The generic class's type parameter only has meaning for an instance, and since it's not loaded with any type parameter,
    // so we can't use it in a static method: cannot be referenced from a static context .
    //We have to make it a generic method then.
    public static <T extends QueryItem> List<T> getMatches(List<T> items, String field, String value){
        List<T> matches = new ArrayList<>();

        for (var item : items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }

        return matches;
    }
}
