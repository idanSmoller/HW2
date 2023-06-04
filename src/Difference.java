public class Difference extends Function{
    private final Function first;
    private final Function second;

    public Difference(Function first, Function second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public double valueAt(double x) {
        return this.first.valueAt(x) - this.second.valueAt(x);
    }

    @Override
    public Function derivative() {
        return new Difference(this.first.derivative(), this.second.derivative());
    }

    @Override
    public String toString() {
        return "(" + this.first.toString() + " - " + this.second.toString() + ")";
    }
}
