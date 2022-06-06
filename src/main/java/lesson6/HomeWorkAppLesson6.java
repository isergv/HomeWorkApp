package lesson6;

public class HomeWorkAppLesson6 {

    int number;

    public static void main(String[] args) {
        Cat cat = new Cat("Борис", 300, 2);
        Cat cat1 = new Cat("Федя", 21, 0);
        Cat cat2 = new Cat("Сфинкс", -15, 8);
        Dog dog = new Dog("Шарик", 150, 14);
        Dog dog1 = new Dog("Бобик", 999, 6);

        cat.canRun(cat.run);
        cat.canSwim(cat.swim);
        cat1.canRun(cat1.run);
        cat1.canSwim(cat1.swim);
        cat2.canRun(cat2.run);
        cat2.canSwim(cat2.swim);

        dog.canRun(dog.run);
        dog.canSwim(dog.swim);
        dog1.canRun(dog1.run);
        dog1.canSwim(dog1.swim);

        System.out.println("Котов созданно - " + Cat.getNumber());
        System.out.println("Собак созданно - " + Dog.getNumber());
        System.out.println("Животных созданно - " + Animal.getNumber());
    }



}
