package ObserverPattern;

import ObserverPattern.Observer;
import ObserverPattern.Subject;

/**
 * Created by John on 2018-12-04.
 */
public class SightSeeingPlanner extends Observer {
    private String string;
    private Subject subject;

    public SightSeeingPlanner(Subject subject) {
        string = "SightSeeingPlanner";
        this.subject = subject;
        System.out.println(string);
    }
    @Override
    public void update() {
        string = subject.getFlag();
        System.out.println(string);
    }
}
