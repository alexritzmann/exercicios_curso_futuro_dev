package futurodevv1.m1s09.errors.exeptions;


public class CollectionPointNotFoundException extends RuntimeException
{
    public CollectionPointNotFoundException(Long id) {
        super("Collection point with id '" + id + "' not found");
    }
}
