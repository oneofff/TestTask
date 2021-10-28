package domain;

public class TelephoneNumber {
    int number;
    public TelephoneNumber(String num)
    {
        try {
            number = Integer.parseInt(num);
        }
        catch (Exception e)
        {

        }
    }
}
