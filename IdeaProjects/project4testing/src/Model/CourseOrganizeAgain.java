package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 8/2/2016.
 * A class that uses CourseOrganized class to
 * further organize the CourseData
 * it organized that objects based on
 * their subject and catalogue numbers
 */
public class CourseOrganizeAgain {
    private String subject;
    private String cataloguNumber;
    private List<CourseOrganized> list = new ArrayList<>();

    public CourseOrganizeAgain(CourseOrganized organized) {
        subject = organized.getSubject();
        cataloguNumber = organized.getCataloguNumber();
        list.add(organized);
    }

    public String getSubject() {
        return subject;
    }

    public String getCataloguNumber() {
        return cataloguNumber;
    }

    boolean isCorrectOrganized(CourseOrganized organized) {
        int control = 0;

        if(organized.getSubject().equals(subject)) {
            control++;
        }
        if(organized.getCataloguNumber().equals(cataloguNumber)) {
            control++;
        }

        if(control == 2) {
            return true;
        } else {
            return false;
        }
    }


    public void addCourseOrganized(CourseOrganized organized) {
        list.add(organized);
    }

    public List<CourseOrganized> getList() {
        return list;
    }

    public void dumpAgain() {
        System.out.println(getSubject() + " " + getCataloguNumber());
        for(CourseOrganized organized: list) {
            organized.dump();
        }
    }
}
