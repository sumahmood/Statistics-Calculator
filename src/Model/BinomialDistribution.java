package Model;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;
import Exceptions.TrialsValueException;

public class BinomialDistribution extends CombinationDistributions implements DiscreteProbabilityDistribution {

    private int n;
    private float p;

    public BinomialDistribution(int n, float p) throws IllegalProbabilityException, TrialsValueException {

        if (p < 0 || p > 1) {
            throw new IllegalProbabilityException();
        }

        if (n < 1) {
            throw new TrialsValueException();
        }

        this.n = n;
        this.p = p;
    }

    public float ExpectedValue() {
        return n*p;
    }

    public float Variance() {
        return n*p*(1-p);
    }

    public float ProbMassFunction(int x) throws IllegalValueException {
        if (x < 0 || x > n) {
            throw new IllegalValueException();
        }

        return (float) ((choose(n,x))*(Math.pow(p, x) * Math.pow(1 - p, 1 - x)));
    }

    public float CumulativeDistributionFunction(int x) throws IllegalValueException {
        if (x < 0 || x > n) {
            throw new IllegalValueException();
        }

        float returnValue = 0;

        for (int i = 0; i <= x; i++) {
            returnValue += (float) ((choose(n,x))*(Math.pow(p, x) * Math.pow(1 - p, 1 - x)));
        }

        return returnValue;
    }
}
