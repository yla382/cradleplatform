package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Created by John on 7/23/2016.
 */
public class CourseDataBase {
    private final String directory = "data\\course_data_2016.csv";
    private List<CourseData> list = new ArrayList<>();
    private Vector<String> options;

    public CourseDataBase() throws IOException {
        File file = new File(directory);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while((line = reader.readLine()) != null) {
            list.add(new CourseData(line));
        }
        list.remove(0);

        options = getSubjects();
    }

    public List<CourseData> getList() {
        return list;
    }

    public Vector<String> getOptions() {
        return options;
    }

    public List<CourseData> getCoursebySubjects(String string) {
        List<CourseData> courses = new ArrayList<>();
        for(CourseData data: list) {
            if (data.getSubject().equals(string)) {
                courses.add(data);
            }
        }
        return courses;
    }

    public Vector<String> getSubjects() {
        Vector<String> subjects = new Vector<String>();

        for(CourseData data: list) {
            if(!subjects.contains(data.getSubject())) {
                subjects.add(data.getSubject());
            }
        }
        Collections.sort(subjects);

        return subjects;

    }

}
