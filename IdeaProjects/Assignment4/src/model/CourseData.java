package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 7/21/2016.
 */
public class CourseData {
    private String semester;
    private String subject;
    private String catalogNumber;
    private String location;
    private String enrolmentCapacity;
    private String enrolmentTotal;
    private String instructor;
    private String componentCode;

    public CourseData(String string) {

        List<String> listInfo = new ArrayList<>();
        if(string.split(",").length > 8) {
            String[] listSplit = string.split("\"");
            for(int i = 0; i < listSplit.length; i++) {
                if(i == 0) {
                    String[] listSplitSplit = listSplit[i].split(",");
                    for(String s: listSplitSplit) {
                        listInfo.add(s);
                    }
                } else if(i == 1) {
                    listInfo.add(listSplit[i]);
                } else {
                   listInfo.add(listSplit[i].substring(1));
                }
            }
        } else {
            String[] listSplit = string.split(",");
            for(String s: listSplit) {
                listInfo.add(s);
            }
        }

        this.semester = listInfo.get(0);
        this.subject = listInfo.get(1);
        this.catalogNumber = listInfo.get(2);
        this.location = listInfo.get(3);
        this.enrolmentCapacity = listInfo.get(4);
        this.enrolmentTotal = listInfo.get(5);
        this.instructor = listInfo.get(6);
        this.componentCode = listInfo.get(7);
    }

    public String getSemester() {
        return semester;
    }

    public String getSubject() {
        return subject;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public String getLocation() {
        return location;
    }

    public String getEnrolmentCapacity() {
        return enrolmentCapacity;
    }

    public String getEnrolmentTotal() {
        return enrolmentTotal;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getComponentCode() {
        return componentCode;
    }
}

