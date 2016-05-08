package Model;

public class CombinationDistributions {

    protected int choose(int a, int b) {
        return numerator(a)/denominator(a,b);
    }

    protected int numerator(int a) {
        int value = 1;

        if (a == 0) {
            return value;
        }

        else {

            for (int i = a; i > 0; i--) {
                value *= i;
            }
        }
        return value;
    }

    private int denominator(int a, int b) {
        return numerator (a-b) *numerator(b);
    }
}
