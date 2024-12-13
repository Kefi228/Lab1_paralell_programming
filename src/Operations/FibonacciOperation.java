package Operations;

public class FibonacciOperation implements Operation{
    @Override
    public String apply(int number) {
        return MathMethods.fibonacci(number).toString();
    }
}
