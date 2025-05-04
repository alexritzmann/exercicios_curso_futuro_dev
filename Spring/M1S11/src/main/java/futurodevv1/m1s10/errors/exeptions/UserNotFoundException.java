package futurodevv1.m1s10.errors.exeptions;

public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(Long id)
    {
        super("Electronic waste with id '" + id + "' not found");
    }

    public UserNotFoundException(String message)
    {
        super(message);
    }
}