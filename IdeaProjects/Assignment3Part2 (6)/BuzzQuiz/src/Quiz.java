import java.util.Scanner;
/**
 * Created by John on 9/9/2018.
 */
public class Quiz {
    private static QuizData data = new QuizData();

    private static boolean checkValidAsnwer(String check) {
        if(check.equals("a") || check.equals("b") || check.equals("c") || check.equals("d")) {
            return true;
        } else {
            return false;
        }
    }

    private static void questionOne() {
        System.out.println("Pick your beverage:");
        System.out.println("a: Coffee");
        System.out.println("b: green tea");
        System.out.println("c: beer");
        System.out.println("d: bubble tea");
        System.out.println("");

        String answer = new Scanner(System.in).nextLine();
        if(checkValidAsnwer(answer)) {
            data.updateResult(answer);
        } else {
            questionOne();
        }
    }

    private static void questionTwo() {
        System.out.println("What is your favorite season:");
        System.out.println("a: Spring");
        System.out.println("b: Summer");
        System.out.println("c: Fall");
        System.out.println("d: Winter");
        System.out.println("");

        String answer = new Scanner(System.in).nextLine();
        if(checkValidAsnwer(answer)) {
            data.updateResult(answer);
        } else {
            questionTwo();
        }
    }

    private static void questionThree() {
        System.out.println("What year are you in:");
        System.out.println("a: 1st");
        System.out.println("b: 2nd");
        System.out.println("c: 3rd");
        System.out.println("d: 4th");
        System.out.println("");

        String answer = new Scanner(System.in).nextLine();
        if(checkValidAsnwer(answer)) {
            data.updateResult(answer);
        } else {
            questionThree();
        }
    }

    private static void questionFour() {
        System.out.println("Pick your sports:");
        System.out.println("a: Hockey");
        System.out.println("b: Soccer");
        System.out.println("c: basketball");
        System.out.println("d: badminton");
        System.out.println("");

        String answer = new Scanner(System.in).nextLine();
        if(checkValidAsnwer(answer)) {
            data.updateResult(answer);
        } else {
            questionFour();
        }
    }

    public static void questionFive() {
        System.out.println("What would like your rubber duck's color to be:");
        System.out.println("a: red");
        System.out.println("b: blue");
        System.out.println("c: orange:");
        System.out.println("d: yellow");
        System.out.println("");

        String answer = new Scanner(System.in).nextLine();
        if(checkValidAsnwer(answer)) {
            data.updateResult(answer);
        } else {
            questionFive();
        }
    }
    public static void main(String[] arg) {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();

        System.out.println(data.getResult());
    }
}
