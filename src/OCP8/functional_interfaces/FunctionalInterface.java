package OCP8.functional_interfaces;

public class FunctionalInterface {
    public static void main(String[] args) {
//        Climber.check((h, l) -> h.toString(), 5);         DOES NOT COMPILE!!!
        Climber.check((h, l) -> false, 5);
    }
}

interface Climb {
    boolean isTooHigh(int height, int limit);
}

class Climber {
    protected static void check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10))
            System.out.println("too high");
        else
            System.out.println("ok");
    }

}