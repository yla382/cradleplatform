package itera;

/**
 * Created by John on 8/10/2016.
 */
public class Course {
    private String name;
    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "[name=" + name + "]";
    }

}
