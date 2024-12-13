package Operations;

public class FactorialOperation implements Operation{
    @Override
    public String apply(int number){

        return MathMethods.factorial(number).toString();
    }
}
