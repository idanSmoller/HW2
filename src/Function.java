public abstract class Function {
    @Override
    public abstract String toString();
    public abstract double valueAt(double x);
    public abstract Function derivative();
}
