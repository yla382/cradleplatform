package FactoryPattern;

/**
 * Created by John on 2018-12-04.
 */
public class AnimalFactory extends Factory {
    @Override
    public Animal pickAnimal(String animalName) throws Exception {
        switch(animalName) {
            case "Tiger":
                return new Tiger();
            case "Calvin":
                return new Calvin();
            default:
                    throw new Exception("No such animal in our database");

        }
    }
}
