package futurodevv1.m1s09.errors.exeptions;

public class ElectronicWasteNotFoundException extends RuntimeException
{
    public ElectronicWasteNotFoundException(Long id) {
        super("Electronic waste with id '" + id + "' not found");
    }

    public ElectronicWasteNotFoundException(String message) {
        super(message);
    }
}