import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by John on 10/16/2018.
 */
public class FoodData {
    private final String csvFilePath = "foodtable.csv";
    private List<Food> foodList = new ArrayList<>();

    public FoodData() throws IOException {
        File csvFile = new File(csvFilePath);
        Scanner scanner = new Scanner(csvFile);

        while(scanner.hasNextLine()) {
            String[] currentLine = scanner.nextLine().split(", ");
            String foodName = currentLine[0];
            double carbonPerKg = Double.valueOf(currentLine[1]);

            Food food = new Food(foodName, carbonPerKg);
            foodList.add(food);
        }
    }


    public double getCarbonPerKgByFoodName(String food) {
        int indexOfFoodList = foodList.indexOf(food);
        return foodList.get(indexOfFoodList).getCarbonPerKg();
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
