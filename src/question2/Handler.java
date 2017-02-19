package question2;

public abstract class Handler<T>
{
    protected Handler<T> successor = null;

    public Handler()
    {
        this.successor = null;
    }

    public Handler(Handler<T> successor)
    {
        this.successor = successor;
    }

    public void setSuccessor(Handler<T> successor)
    {
        this.successor = successor;
    }

    public Handler<T> getSuccessor()
    {
        return this.successor;
    }

    public boolean handleRequest(T value)
    {
        if (null == successor) {
            return false;
        }

        return successor.handleRequest(value);
    }
}