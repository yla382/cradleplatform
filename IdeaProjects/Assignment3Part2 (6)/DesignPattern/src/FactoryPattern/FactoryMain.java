package FactoryPattern;

/**
 * Created by John on 2018-12-04.
 */
public class FactoryMain {
    public static void main(String args[]) throws Exception {
        Factory factory = new AnimalFactory();
        Animal tiger = factory.pickAnimal("Tiger");
        Animal Calvin = factory.pickAnimal("Calvin");

        tiger.speak();
        Calvin.speak();
    }
}
