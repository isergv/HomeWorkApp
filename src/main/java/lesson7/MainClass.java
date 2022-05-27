package lesson7;

public class MainClass {

    /*
    Расширить задачу про котов и тарелки с едой, выполнив следующие пункты:
            1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
            (например, в миске 10 еды, а кот пытается покушать 15-20).
            2. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
            удалось покушать (хватило еды), сытость = true.
            3. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
            наполовину сыт (это сделано для упрощения логики программы).
            4. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
            потом вывести информацию о сытости котов в консоль.
            5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
    */

    public static void main(String[] args) {
        int eatStart = 100;
        int addEat = 10;
        int appetite = 20;
        int numberOfMeals = 10;

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Barsik", (int) (Math.random()*appetite));
        cats[1] = new Cat("Шарик", (int) (Math.random()*appetite));
        cats[2] = new Cat("Мурлыка", (int) (Math.random()*appetite));
        cats[3] = new Cat("Рыжуля", (int) (Math.random()*appetite));
        cats[4] = new Cat("Гав", (int) (Math.random()*appetite));
        Plate plate = new Plate((int) (Math.random()*eatStart));

        for (int j = 0; j < 1 + (int) (Math.random()*numberOfMeals); j++) {
            System.out.println("------------ " + (j + 1));
            plate.info();
            for (int i = 0; i < cats.length; i++) {
                cats[i].eat(plate);
            }
            plate.addEat((int) (Math.random() * addEat));
        }
    }
}
