package itera;

/**
 * Created by John on 8/10/2016.
 */
public class Semester {
    private String semester;

    public Semester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[name=" + semester + "]";
    }
}
