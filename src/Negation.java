public class Negation extends Function{
    private final Function func;

    public Negation(Function func) {
        this.func = func;
    }

    @Override
    public double valueAt(double x) {
        return -1 * func.valueAt(x);
    }

    @Override
    public String toString() {
        return "(-" + this.func.toString() + ")";
    }

    @Override
    public Function derivative() {
        return new Negation(this.func.derivative());
    }
}
