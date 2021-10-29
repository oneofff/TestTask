package dao.exeption;

public class UserReadError extends Throwable {
    public   UserReadError()
    {
        super("Error read user from file");
    }
}
