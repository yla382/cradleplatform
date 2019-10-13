
/**
 * Created by John on 9/9/2018.
 */
public class QuizData {
    private int quizResult[] = new int[] {0, 0, 0, 0,};
    private String result[] = new String[]{"You are a fire bender", "You are a air bender", "You are a earth bender", "You are the AVATAR"};

    public QuizData() {
    }

    public void updateResult(String answer) {
        if(answer.equals("a")) {
           quizResult[0]++;
        }

        if(answer.equals("b")) {
            quizResult[1]++;
        }

        if(answer.equals("c")) {
            quizResult[2]++;
        }

        if(answer.equals("d")) {
            quizResult[3]++;
        }
    }

    public String getResult() {
        return result[getMostAnswered()];
    }

    private int getMostAnswered() {
        int max = quizResult[0];
        int mostAnsweredIndex = 0;
        for(int i = 1; i < quizResult.length; i++) {
            if(quizResult[i] > max) {
                mostAnsweredIndex = i;
                max = quizResult[i];
            }
        }
        return mostAnsweredIndex;
    }
}
