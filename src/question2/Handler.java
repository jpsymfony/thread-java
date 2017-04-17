package question2;

/**
 * The type Handler.
 *
 * @param <T> the type parameter
 */
public abstract class Handler<T>
{
    /**
     * The Successor.
     */
    protected Handler<T> successor = null;

    /**
     * Instantiates a new Handler.
     */
    public Handler()
    {
        this.successor = null;
    }

    /**
     * Instantiates a new Handler.
     *
     * @param successor the successor
     */
    public Handler(Handler<T> successor)
    {
        this.successor = successor;
    }

    /**
     * Sets successor.
     *
     * @param successor the successor
     */
    public void setSuccessor(Handler<T> successor)
    {
        this.successor = successor;
    }

    /**
     * Gets successor.
     *
     * @return the successor
     */
    public Handler<T> getSuccessor()
    {
        return this.successor;
    }

    /**
     * Handle request boolean.
     *
     * @param value the value
     * @return the boolean
     */
    public boolean handleRequest(T value)
    {
        if (null == successor) {
            return false;
        }

        return successor.handleRequest(value);
    }
}