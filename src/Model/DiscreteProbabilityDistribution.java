package Model;

import Exceptions.IllegalValueException;

public interface DiscreteProbabilityDistribution {

    // Calculates the expected value of the probability distribution.
    // EFFECTS: Returns the expected value of the probability distribution.
    public float ExpectedValue();

    //Calculates the variance of the probability distribution
    //EFFECTS: Returns the variance of the probabiltiy distribution.
    public float Variance();

    // Returns the value p(x); i.e. the probability of the random variable being x for the given distribution. Also
    // called P(X = a).
    // EFFECTS: Returns the probability of the random variable being equal to a given value. Throws IllegalValueException
    //          when the value input is lower than the value that can be taken on by the random variable.
    public float ProbMassFunction(int x) throws IllegalValueException;

    // Returns the F(x); i.e. the probability of the random variable being less than or equal to x for the given
    // distribution. Also called P(X <= a).
    // EFFECTS: Returns the probability of the random variable being less than or equal to a given value. Throws
    //          IllegalValueException when the value input is lower than the value that can be taken on by the random variable.
    public float CumulativeDistributionFunction(int x) throws IllegalValueException;
}
