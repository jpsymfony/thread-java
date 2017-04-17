package question1;

/**
 * The interface Command.
 *
 * @param <T> the type parameter
 */
public interface Command<T>
{
    /**
     * Make.
     *
     * @param f the f
     */
    public void make(T f);
}