package itera;

/**
 * Created by John on 8/10/2016.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Degree {
    private String name;
    private List<Course> courses = new ArrayList<Course>();
    private List<Student> students = new ArrayList<>();
    private List<Semester> semesters = new ArrayList<>();

    public Degree(String name) {
        this.name = name;
    }
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addSemester(Semester semester) {
        semesters.add(semester);
    }

    public String getName() {
        return name;
    }

    /**
     * Make it so Degree is iterable
     * But, questionably meaning!
     */
//    @Override
//    public Iterator<Course> iterator() {
//        return courses.iterator();
////		return Collections.unmodifiableList(courses).iterator();
//    }

    /**
     * Make it so we can ask, by name, for courses to be iterated over.
     * (This is better than Degree implementing Iterable)
     * @return
     */
    public Iterable<Course> courses() {
        return new Iterable<Course>(){
            @Override
            public Iterator<Course> iterator() {
                return Collections.unmodifiableCollection(courses).iterator();
            }
        };
    }
	public Iterable<Student> students() {
		return new Iterable<Student>() {
            @Override
             public Iterator<Student> iterator() {
                return Collections.unmodifiableCollection(students).iterator();
            }
        };
	}
	public Iterable<Semester> semesters() {
		return new Iterable<Semester>() {
            @Override
            public Iterator<Semester> iterator() {
                return Collections.unmodifiableCollection(semesters).iterator();
            }
        };
	}

    @Override
    public String toString() {
        return getClass().getName()
                + "[name=" + name + "]";
    }


}
