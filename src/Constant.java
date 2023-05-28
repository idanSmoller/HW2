public class Constant extends Function{
    private final double c;

    public Constant(double value) {
        this.c = value;
    }

    @Override
    public String toString() {
        return "(" + c + ")";
    }

    @Override
    public double valueAt(double x) {
        return c;
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }
}
