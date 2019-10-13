package ObserverPattern;

/**
 * Created by John on 2018-12-04.
 */
public interface ISubject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
