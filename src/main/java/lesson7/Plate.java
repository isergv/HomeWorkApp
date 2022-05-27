package lesson7;

public class Plate {
    private int food;
    private boolean satiety;

    public Plate(int food) {
        this.food = food;
        satiety = false;
    }

    public boolean decreaseFood(String name, int n, boolean s) {
        if (s == true) {
            System.out.println(name + " не голодный");
        } else {
            if (food >= n) {
                System.out.println(name + " поел");
                food -= n;
                satiety = true;
            } else {
                System.out.println("В тарелке недостаточно еды для " + name);
                satiety = false;
            }
        }
        return satiety;

    }

    public boolean satiety() {
        return satiety;
    }

    public void addEat(int eat) {
        food += eat;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
