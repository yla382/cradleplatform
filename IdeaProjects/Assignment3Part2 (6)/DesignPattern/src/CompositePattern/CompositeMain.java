package CompositePattern;

/**
 * Created by John on 2018-12-04.
 */
public class CompositeMain {
    public static void main(String args[]) {
        Teacher teacher1 = new Teacher("John", "Science");
        Teacher teacher2 = new Teacher("a", "Science");
        Teacher teacher3 = new Teacher("b", "Science");
        Teacher teacher4 = new Teacher("c", "Science");
        Teacher teacher5 = new Teacher("d", "Science");
        Teacher teacher6 = new Teacher("e", "Science");

        teacher1.addTeacher(teacher2);
        teacher1.addTeacher(teacher3);

        teacher2.addTeacher(teacher4);

        teacher3.addTeacher(teacher5);
        teacher3.addTeacher(teacher6);

        teacher1.printTeachers();
    }
}
