package Model;

public class CombinationDistributions {

    // Calculates the a choose b.
    // EFFECTS: Calculates a choose b for the given parameters a and b. Since the values chosen in this scenario have to be
    // greater than 1 based on the input limitations of the user, I did not account for additional scenarios here
    // where exception handling may be necessary.
    protected int choose(int a, int b) {
        return numerator(a)/denominator(a,b);
    }

    // Calculates the numerator of the a choose b calculation.
    // EFFECTS: Returns a!
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

    // Calculates the denominator of the a choose b calculation.
    // EFFECTS: Returns (a-b)!*b!
    private int denominator(int a, int b) {
        return numerator (a-b) *numerator(b);
    }
}
