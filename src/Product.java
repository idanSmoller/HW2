public class Product extends MultiProduct{
    public Product(Function first, Function second) {
        super(first, second);
    }

    @Override
    public Function derivative() {
        Function first = funcs[0];
        Function second = funcs[1];
        return new Sum(new Product(first.derivative(), second), new Product(first, second.derivative()));
    }
}
