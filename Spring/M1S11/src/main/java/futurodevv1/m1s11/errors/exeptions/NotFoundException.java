package futurodevv1.m1s11.errors.exeptions;

public abstract class NotFoundException extends RuntimeException
{
    public NotFoundException(String message)
    {
        super(message);
    }
}
