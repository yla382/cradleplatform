package itera;

import java.util.Iterator;

/**
 * Created by John on 8/10/2016.
 */
public class Matrix1d implements Iterable<Integer> {
    public static int NUM_COLS;
    private int[] values;

    public Matrix1d(int column) {
        NUM_COLS = column;
        values = new int[column];
    }

    public void setValues() {
        for(int i = 0; i < NUM_COLS; i++) {
            values[i] = i;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int col = 0;
            @Override
            public boolean hasNext() {
                return col < NUM_COLS;
            }

            @Override
            public Integer next() {
                Integer item = values[col];
                col++;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Matrix1d matrix = new Matrix1d(10);
        matrix.setValues();

        Iterator<Integer> it = matrix.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
