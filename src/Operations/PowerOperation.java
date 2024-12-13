package Operations;

public class PowerOperation implements Operation{
    @Override
    public String apply(int number){
        return Integer.toString((int) Math.pow(number, 2));
    }
}
