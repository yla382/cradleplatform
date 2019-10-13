package ObserverPattern;

import ObserverPattern.Observer;
import ObserverPattern.Subject;

/**
 * Created by John on 2018-12-04.
 */
public class CulturePlanner extends Observer {
    private String string;
    private Subject subject;

    public CulturePlanner(Subject subject) {
        string = "CulturePlanner";
        this.subject = subject;
        System.out.println(string);
    }

    @Override
    public void update() {
        string = subject.getFlag();
        System.out.println(string);
    }
}
