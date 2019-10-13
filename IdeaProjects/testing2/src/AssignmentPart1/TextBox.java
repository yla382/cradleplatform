package AssignmentPart1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 7/6/2016.
 * A class that extends Rectangle
 * Adds texts horizontally centered
 * inside of the Rectangle
 */
public class TextBox extends Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;
    private String text;

    public TextBox(int x, int y, int width, int height, String text) {
        super(x, y, width, height);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public String getMessege() {
        return text;
    }

    public void setMessage(String string) {
        this.text = string;
    }

    public List<String> drawHelperString(String text) {
        String[] words = text.trim().split(" ");
        List<String> list_helper = new ArrayList<>();

        for(String s: words) {
            if(s.length() > width - 2) {
                int count = s.length() / (width - 2);
                int begin = 0;
                int end = width - 2;
                list_helper.add((s.subSequence(begin, end).toString()));

                for(int i = 1; i < count; i++) {
                    begin = end;
                    end = begin + width - 2;
                    list_helper.add(s.subSequence(begin, end).toString());
                }

                list_helper.add(s.subSequence(end, s.length()).toString());
            } else {
                list_helper.add(s);
            }
        }

        List<String> list = new ArrayList<>();
        list.add(list_helper.get(0));


        int i = 0;
        for(int j = 1; j < list_helper.size(); j++) {
            if((list.get(i).length() + " ".length() + list_helper.get(j).length()) <= (width - 2)) {
                String temp = list.get(i);
                list.remove(i);
                list.add(i, temp + " " + list_helper.get(j));
            } else {
                i++;
                list.add(i, list_helper.get(j));
            }
        }

        return list;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        List<String> list = drawHelperString(text);

        int yPostion = y + 1;
        for(String s: list) {
            int xPostion = ((width - 2) - s.length()) / 2;
            if(yPostion > y + height - 2) {

            } else {
                for(char character: s.toCharArray()) {
                    canvas.setPointText(x + 1 + xPostion, yPostion, character);
                    xPostion++;
                }

            }
            yPostion++;
        }
    }
}
