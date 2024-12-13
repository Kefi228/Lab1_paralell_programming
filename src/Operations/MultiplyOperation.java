package Operations;

public class MultiplyOperation implements Operation{
    private  int multiplier;

    public MultiplyOperation(int multiplier){
        this.multiplier = multiplier;
    }

    @Override
    public String apply(int number){
        return Integer.toString(number * multiplier);
    }
}
