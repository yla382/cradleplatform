package CompositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 2018-12-04.
 */
public class Teacher implements TeacherInterface {
    private String name;
    private String department;
    private List<Teacher> teachers;

    public Teacher(String name, String department) {
        this.name = name;
        this.department = department;
        teachers = new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void printTeachers() {
        getDetails();
        System.out.print(": ");
        for(Teacher teacher: teachers) {
            teacher.printTeachers();
        }
        System.out.println("");
    }

    @Override
    public void getDetails() {
        System.out.print(name + " " + department);
    }
}
