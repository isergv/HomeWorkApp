package lesson6;

public class Cat extends Animal {

    private static final int MAXRUN = 200;
    private static final int MAXSWIM = 0;
    private static int number = 0;

    public Cat(String name, int run, int swim) {
        super(name, run, swim);
        number++;
    }

    public static int getNumber() {
        return number;
    }

    @Override
    public void canRun(int run) {
        if (Math.abs(run) >= 0 && Math.abs(run) <= MAXRUN) {
            super.canRun(Math.abs(run));
        } else {
            System.out.println(name + " может пробежать только " + MAXRUN + "м, их, видимо, и пробежал");
        }
    }

    @Override
    public void canSwim(int swim) {
        if (Math.abs(swim) > 0 && Math.abs(swim) <= MAXSWIM) {
            super.canRun(Math.abs(swim));
        } else {
            System.out.println(name + " не умеет плавать");
        }
    }
}
