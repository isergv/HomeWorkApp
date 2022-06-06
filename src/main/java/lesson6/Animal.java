package lesson6;

public class Animal {

    protected final String name;
    protected final int run;
    protected final int swim;
    private static int number = 0;

    public Animal(String name, int run, int swim) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        number++;
    }

    public static int getNumber() {
        return number;
    }

    public void canRun(int run) {
        System.out.println(name + " пробежал " + run + " м.");
    }

    public void canSwim(int swim) {
        System.out.println(name + " проплыл " + swim + " м.");
    }

}
