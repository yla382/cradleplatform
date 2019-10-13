package itera;

/**
 * Created by John on 8/10/2016.
 */
public class IterableDemo {
    public static void main(String args[]) {
        Degree sosyMajor = new Degree("SOSY Major");
        sosyMajor.addCourse(new Course("CMPT 130"));
        sosyMajor.addCourse(new Course("CMPT 135"));
        sosyMajor.addCourse(new Course("CMPT 213"));
        sosyMajor.addCourse(new Course("CMPT 276"));
        sosyMajor.addCourse(new Course("CMPT 373"));
        sosyMajor.addStudent(new Student("Kayden Kross"));
        sosyMajor.addStudent(new Student("Dillion Haper"));
        sosyMajor.addStudent(new Student("Asa Akira"));
        sosyMajor.addStudent(new Student("Ameri Ichinose"));
        sosyMajor.addStudent(new Student("Kirara Asuka"));
        sosyMajor.addSemester(new Semester("Fall"));
        sosyMajor.addSemester(new Semester("String"));
        sosyMajor.addSemester(new Semester("Winter"));
        sosyMajor.addSemester(new Semester("Summer"));
        sosyMajor.addSemester(new Semester("Rainy"));

        System.out.println(sosyMajor.getName() + " includes:");
        for (Course course : sosyMajor.courses()) {
            System.out.println("  " + course);
        }

        System.out.println("");

        for (Student student : sosyMajor.students()) {
            System.out.println("  " + student);
        }

        System.out.println("");

        for(Semester semster: sosyMajor.semesters()) {
            System.out.println("  " + semster);
        }
    }
}