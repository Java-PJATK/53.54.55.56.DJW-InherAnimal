// DJW-InherAnimal/Main.java
 
public class Main {
    public static void main (String[] args) {
        Animal[] animals = {
                new Dog("Max", 15), new Cat("Batty", 3.5),
                new Dog("Ajax", 5), new Cat("Minnie", 4)
        };
        Animal.voices(animals);
    }
}
