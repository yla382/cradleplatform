package Model;

/**
 * Created by John on 8/2/2016.
 * Class that holds type of componentCode
 * and its enrollCapacity and enrollTotal
 * so that CourseOrganize that store lists of
 * component codes and its enrollments totals
 * and capacities.
 */
public class CourseComponentCode {
    private String componentCode;
    private int enrollCapacity;
    private int enrollTotal;

    public CourseComponentCode(String componentCode, String enrollCapacity, String enrollTotal) {
        this.componentCode = componentCode;
        this.enrollCapacity = Integer.parseInt(enrollCapacity);
        this.enrollTotal = Integer.parseInt(enrollTotal);
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setEnrollCapacity(String size) {
        enrollCapacity += Integer.parseInt(size);
    }

    public void setEnrollTotal(String size) {
        enrollTotal += Integer.parseInt(size);
    }

    public int getEnrollCapacity() {
        return enrollCapacity;
    }

    public int getEnrollTotal() {
        return enrollTotal;
    }
}
