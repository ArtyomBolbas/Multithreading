package org.example.pecs;

import java.util.List;

public class AnimalServiceImpl {

    public void producer(List<? extends Cat> animals) {
        Object o = animals.get(0);
        Animal animal = animals.get(0);
        Cat cat = animals.get(0);
        //Lion lion = animals.get(0);
        //animals.add(new Animal());
        //animals.add(new Cat());
        //animals.add(new Lion());
    }

    public void consumer(List<? super Dog> animals) {
        Object o = animals.get(0);
        //Labrador labrador = animals.get(0);
        //Dog dog = animals.get(0);
        animals.add(new Labrador());
        animals.add(new Dog());
        //animals.add(new Animal());
    }

}
