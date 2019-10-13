package ObserverPattern;

import ObserverPattern.Subject;

/**
 * Created by John on 2018-12-04.
 */
public class ObserverMain {
    public static void main(String args[]) {
        Subject subject = new Subject();

        Observer o1 = new SightSeeingPlanner(subject);
        Observer o2 = new SportsPlanner(subject);
        Observer o3 = new CulturePlanner(subject);

        subject.registerObserver(o1);
        subject.registerObserver(o2);
        subject.registerObserver(o3);

        System.out.println("Update Planner: There is no plan\n\n");

        subject.setChange("fuck you");
        subject.setChange("No you fuck yourself");
    }
}
