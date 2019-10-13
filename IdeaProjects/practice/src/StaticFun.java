/**
 * Created by John on 5/16/2016.
 */
public class StaticFun {
    public static final int TARGET_NUM_HATS = 10;
    private static int countNumMade = 0;
    private static int favNum = 0;


    public static void main (String[] args) {
        changeFavNum(42);
        displayInfo();
        favNum = 10;
        countNumMade = 9;
    }

    private void changeFavNum(int i) {
        int k = TARGET_NUM_HATS + i;
        displayInfo();
    }

    private static void displayInfo() {
        System.out.println(TARGET_NUM_HATS);
        System.out.println(countNumMade);
        System.out.println(favNum);
    }


}
