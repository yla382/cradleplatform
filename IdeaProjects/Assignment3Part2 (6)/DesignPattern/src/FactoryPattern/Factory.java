package FactoryPattern;

/**
 * Created by John on 2018-12-04.
 */
public abstract class Factory {
    public abstract Animal pickAnimal(String animalName) throws Exception;
}
