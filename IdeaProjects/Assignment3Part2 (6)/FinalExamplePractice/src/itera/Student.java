package itera;

/**
 * Created by John on 8/10/2016.
 */
public class Student {
    private String student;
    public Student(String student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[name=" + student + "]";
    }
}
