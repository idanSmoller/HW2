public class Quotient extends Function {
    private final Function numerator;
    private final Function denominator;

    public Quotient(Function numerator, Function denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public double valueAt(double x) {
        //TODO: could the denominator be 0 at x?
        return numerator.valueAt(x) / denominator.valueAt(x);
    }

    @Override
    public String toString() {
        return "(" + numerator.toString() + " / " + denominator.toString() + ")";
    }

    @Override
    public Function derivative() {
        Function newNumerator = new Sum(new Product(numerator.derivative(), denominator),
                new Negation(new Product(numerator, denominator.derivative())));
        Function newDenominator = new Power(denominator, 2);
        return new Quotient(newNumerator, newDenominator);
    }
}
