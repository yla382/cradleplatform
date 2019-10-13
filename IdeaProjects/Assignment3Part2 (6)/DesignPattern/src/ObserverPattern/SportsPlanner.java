package ObserverPattern;

import ObserverPattern.Observer;
import ObserverPattern.Subject;

/**
 * Created by John on 2018-12-04.
 */
public class SportsPlanner extends Observer {
    private String string;
    private Subject subject;

    public SportsPlanner(Subject subject) {
        string = "SportsPlanner";
        this.subject = subject;
        System.out.println(string);
    }

    @ Override
    public void update() {
        string = subject.getFlag();
        System.out.println(string);
    }
}
