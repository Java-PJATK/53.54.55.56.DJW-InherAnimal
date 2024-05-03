# DJW-InherAnimal
53 54 55 56 DJW-InherAnimal/Animal.java DJW-InnerAnimal/Dog.java DJW-InnerAnimal/Cat.java DJW-InnerAnimal/Main.java 91 91 92 92

Cont. from [50.51.52.DJV-Inherit](https://github.com/Java-PJATK/50.51.52.DJV-Inherit)

Let us consider another example: we define an `Animal` class

## Listing 53 DJW-InherAnimal/Animal.java

```java
public class Animal {
    protected String name;
    protected double weight;
      // no default constructor!
    public Animal(String n, double w) {
        name = n;
        weight = w;
    }
    public String getVoice() {
        return "?";
    }
    public static void voices(Animal[] animals) {
        for (Animal a : animals)
            System.out.println(a + " " + a.getVoice());
    }
    @Override
    public String toString() {
        return name + "(" + weight + ")";
    }
}
```
which defines the `getVoice` method.

It also defines a static method `voices` which traverses an array of (references to) `Animal`s (not knowing what the real type of objects pointed to by the elements of the array are).

However, when calling `toString` or `getVoice`, the methods from the real type will be selected (therefore, it is a _polymorphic_ invocation).

We then create two classes which extend Animal: class Dog

## Listing 54 DJW-InherAnimal/Dog.java

```java
public class Dog extends Animal {
    public Dog(String name, double weight) {
        super(name, weight);
    }
    @Override
    public String getVoice() {
        return "Bow-Wow";
    }
    @Override
    public String toString() {
        return "Dog " + super.toString();
    }
}
```
and class `Cat`

```java

public class Cat extends Animal {
    public Cat(String name, double weight) {
        super(name, weight);
    }
    @Override
    public String getVoice() {
        return "Miaou-Miaou";
    }
    @Override
    public String toString() {
        return "Cat " + super.toString();
    }
}
```
In both classes, we _override_ (redefine) the `getVoice` method. Note that there is no default constructor in the base class `Animal` – therefore, using `super` in constructors of the derived classes is obligatory.

Now in another class  

## Listing 56 DJW-InherAnimal/Main.java

```java
Dog Max(15.0) Bow-Wow
Cat Batty(3.5) Miaou-Miaou
Dog Ajax(5.0) Bow-Wow
Cat Minnie(4.0) Miaou-Miaou
```

we create an array of various animals — some are dogs, some are cats — and pass it to the `voices` method from `Animal`. As we can see from the output

invocations in `System.out.println(a + " " + a.getVoice())` inside the `voices` method are polymorhic: both `toString` and `getVoice` have been taken from the real type of objects pointed to by elements of the array animals, although the declared type of these elements was `Animal` and there was no way for the compiler to know their real type.

Next [10.1 Importance of equal and hashCode methods 57.AAR-EquToString](https://github.com/Java-PJATK/57.AAR-EquToString)
