package Model;

import Exceptions.IllegalProbabilityException;
import Exceptions.IllegalValueException;

public class BernoulliDistribution implements DiscreteProbabilityDistribution{

    private float p;

    // Models a Bernoulli distribution with the given parameter (probability of success).
    // EFFECTS: Creates a Bernoulli distribution with the given 'p' parameter.
    //          Throws IllegalProbabilityException if the probability is a value outside the interval (0,1).
    public BernoulliDistribution(float p) throws IllegalProbabilityException {
        if (p < 0 || p > 1) {
            throw new IllegalProbabilityException();
        }
        this.p = p;
    }

    public float ExpectedValue() {
        return p;
    }

    public float Variance() {
        return p*(1-p);
    }

    public float ProbMassFunction(int x) throws IllegalValueException {
        if (x != 0 && x != 1) {
            throw new IllegalValueException();
        }

        return (float) (Math.pow(p,x)*Math.pow(1-p,1-x));
    }

    public float CumulativeDistributionFunction(int x) throws IllegalValueException {
        if (x != 0 && x != 1) {
            throw new IllegalValueException();
        }

        float returnValue = 0;

        for (int i = 0; i <= x; i++) {
            returnValue += (float) (Math.pow(p,i)*Math.pow(1-p,1-i));
        }

        return returnValue;
    }
}
