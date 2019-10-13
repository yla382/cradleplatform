package Model;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by John on 8/1/2016.
 * A class that access the cvs file and store
 * then into list of CourseData. when the
 * file is not found, it generates a pop-up messege.
 */
public class CourseDataBase implements Comparator<CourseData> {
    private final String directory = "data\\course_data_2016.csv";
    private List<CourseData> list = new ArrayList<>();
    private File file;

    public CourseDataBase() throws IOException {
        file = new File(directory);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Data file (data\\course_data_2016.csv)" +
                    " not found.");
        }

        String line = null;
        while((line = reader.readLine()) != null) {
            list.add(new CourseData(line));
        }

        list.remove(0);
        java.util.Collections.sort(list, this);
    }

    @Override
    public int compare(CourseData o1, CourseData o2) {
        return Integer.parseInt(o1.getSemester()) - Integer.parseInt(o2.getSemester());
    }

    public List<CourseData> getCourseDataList() {
        return list;
    }

}
