package SingletonPattern;

/**
 * Created by John on 2018-12-04.
 */
public class MakeACaptain {
    private static MakeACaptain captain;

    private MakeACaptain() {
        System.out.println("New Captain Selected");
    }

    public static MakeACaptain pickACaption() {
        if(captain == null) {
            captain = new MakeACaptain();
        } else {
            System.out.println("Fuck you! Captain selected already");
        }

        return captain;
    }
}
