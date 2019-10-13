import java.io.IOException;
import java.util.List;

/**
 * Created by John on 10/16/2018.
 */
public class gg {
    public static void main(String args[]) throws IOException {
        FoodData data = new FoodData();
        List<Food> foods = data.getFoodList();

        for(Food food: foods) {
            System.out.println(food.getFoodName() + "  " + food.getCarbonPerKg());
        }
    }
}
