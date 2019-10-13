package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by John on 8/2/2016.
 * A class that uses CourseDataBase to store
 * specific courses based on similar
 * subjects, catalogue number, campus, and semester
 */
public class CourseOrganized {
    private String semester;
    private String whichSemester;
    private int year;
    private String subject;
    private String cataloguNumber;
    private String campus;
    private String instructor;
    private List<CourseComponentCode> componentCodes = new ArrayList<>();
    private List<CourseData> list = new ArrayList<>();

    public CourseOrganized(CourseData data) {
        semester = data.getSemester();
        year = Integer.parseInt(semester.substring(1, 3)) + 2000;
        subject = data.getSubject();
        cataloguNumber = data.getCatalogNumber();
        campus = data.getLocation();
        instructor = data.getInstructor();
        setWhichSemester();
        list.add(data);
    }

    public void setWhichSemester() {
        if(semester.endsWith("1")) {
            whichSemester = "Spring";
        }

        if(semester.endsWith("4")) {
            whichSemester = "Summer";
        }

        if(semester.endsWith("7")) {
            whichSemester = "Fall";
        }
    }

    public String getWhichSemester() {
        return whichSemester;
    }

    public int getYear() {
        return year;
    }

    public String getInstructorList() {
        String[] instructors = instructor.split(", ");
        List<String> instructorList = new ArrayList<>();
        for(String string: instructors) {
            instructorList.add(string);
        }

        List<String> listTemp = new ArrayList<>();
        for(CourseData data: list) {
            String[] temp = data.getInstructor().split(", ");
            for(int i = 0; i < temp.length; i++) {
                listTemp.add(temp[i]);
            }
        }

        for(String s: listTemp) {
            int count = 0;
            for(String string: instructorList) {
                if(string.equals(s)) {
                    count++;
                }
            }
            if(count == 0) {
                instructorList.add(s);
            }
        }

        instructorList.remove("(null)");
        String instructorSum = "";
        if(instructorList.size() == 0) {

        } else {
            instructorSum = instructorList.get(0);
            for(int i = 1; i < instructorList.size(); i++) {
                instructorSum += (", " + instructorList.get(i));
            }
        }

        return instructorSum;
    }

    public void setComponentCodes() {
        for(CourseData data: list) {
            int control = 0;
            if(componentCodes.size() == 0) {
                componentCodes.add(new CourseComponentCode(data.getComponentCode(), data.getEnrolmentCapacity(), data.getEnrolmentTotal()));

            } else {
                for(CourseComponentCode componenets: componentCodes) {
                    if(componenets.getComponentCode().equals(data.getComponentCode())) {
                        componenets.setEnrollCapacity(data.getEnrolmentCapacity());
                        componenets.setEnrollTotal(data.getEnrolmentTotal());
                        control++;
                    }
                }

                if(control == 0) {
                    componentCodes.add( new CourseComponentCode(data.getComponentCode(), data.getEnrolmentCapacity(), data.getEnrolmentTotal()));
                }
            }
        }
    }

    public String getSemester() {
        return semester;
    }

    public String getSubject() {
        return subject;
    }

    public String getCataloguNumber() {
        return cataloguNumber;
    }

    public String getCampus() {
        return campus;
    }

    public String getInstructor() {
        return instructor;
    }

    public boolean isCorrectCourse(CourseData data) {
        int control = 0;

        if(data.getSemester().equals(getSemester())) {
            control++;
        }
        if(data.getSubject().equals(getSubject())) {
            control++;
        }
        if(data.getCatalogNumber().equals(getCataloguNumber())) {
            control++;
        }
        if(data.getLocation().equals(getCampus())) {
            control++;
        }

        if(control == 4) {
            return true;
        } else {
            return false;
        }
    }

    public void addCourseData(CourseData data) {
        list.add(data);
    }

    public List<CourseComponentCode> getComponentCodes() {
        return componentCodes;
    }

    public void dump() {
        System.out.println("\t" + getSemester() + " in " + getCampus() + " by " + getInstructor());
        for(CourseComponentCode components: componentCodes) {
            System.out.println("\t\t" + "Type=" + components.getComponentCode() + ", " + "Enrollment=" +
                    components.getEnrollTotal() + "/" + components.getEnrollCapacity());
        }
    }
}
